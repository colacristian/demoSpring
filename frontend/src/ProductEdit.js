import {Component} from "react";
import {Link, withRouter} from 'react-router-dom';
import {Button, Container, Form, FormGroup, Input, Label} from 'reactstrap';
import {Client} from '@stomp/stompjs';
import AppNavbar from './AppNavbar';

const SOCKET_URL = 'ws://localhost:8080/ws-message';


class ProductEdit extends Component {
    emptyItem = {
        name: '',
        price: 0
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        }
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        console.log(this.props);
        if (this.props.match.params.id !== 'new') {
            const product = await (await fetch(`/products/${this.props.match.params.id}`)).json();
            console.log(product);
            this.setState({item: product});
        }

        let onConnected = () => {
            console.log("Connected!!")
            client.subscribe(`/product_update/${this.props.match.params.id}`, (msg) => {
                if (msg.body) {
                    const product = JSON.parse(msg.body);
                    console.log("Price:" + product.price);
                    console.log(product);
                    this.setState({item: product});

                }
            });
        }

        let onDisconnected = () => {
            console.log("Disconnected!!")
        }

        const client = new Client({
            brokerURL: SOCKET_URL,
            reconnectDelay: 5000,
            heartbeatIncoming: 4000,
            heartbeatOutgoing: 4000,
            onConnect: onConnected,
            onDisconnect: onDisconnected
        });

        client.activate();
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});
    }

    async handleSubmit(event) {
        event.preventDefault();
        const {item} = this.state;

        await fetch('/products' + (item.id ? '/' + item.id : ''), {
            method: (item.id) ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push('/products');
    }


    render() {
        const {item} = this.state;
        const title = <h2>{item.id ? 'Edit Product' : 'Add Product'}</h2>;

        return (<div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="name">Name</Label>
                        <Input type="text" name="name" id="name" value={item.name}
                               onChange={this.handleChange} autoComplete="name"/>

                        <Label for="price">Price</Label>
                        <Input type="text" name="price" id="price" value={item.price}
                               onChange={this.handleChange}
                               autoComplete="price"/>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>
                        <Button color="secondary" tag={Link} to="/products">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>)
    }

}

export default withRouter(ProductEdit);