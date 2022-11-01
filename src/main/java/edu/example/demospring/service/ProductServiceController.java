package edu.example.demospring.service;

import edu.example.demospring.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class ProductServiceController {
    private static Map<Long, Product> productsMap = new HashMap<>();

    static {
        Product p1 = new Product();
        p1.setId(1l);
        p1.setName("Mere");
        productsMap.put(p1.getId(), p1);

        Product p2 = new Product();
        p2.setId(2l);
        p2.setName("Pere");
        productsMap.put(p2.getId(), p2);

    }


    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProducts() {
        return new ResponseEntity<>(productsMap.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productsMap.put(product.getId(), product);
        return new ResponseEntity<>("Product created", HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        productsMap.remove(id);
        productsMap.put(id, product);
        return new ResponseEntity<>("Product updated", HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") Long id) {
        Product remove = productsMap.remove(id);
        return new ResponseEntity<>(Optional.ofNullable(remove).map(p -> "Product deleted").orElse("Product not found"), HttpStatus.OK);
    }

}
