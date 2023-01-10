package edu.example.demospring.kafka;

import java.util.logging.Logger;

//@EnableKafka
//@Configuration
public class KafkaConsumerConfig {

    private static final Logger log = Logger.getLogger(KafkaConsumerConfig.class.getCanonicalName());
    private static final String TOPIC_NAME = "spring-topic";

//    @Value(value = "${spring.kafka.bootstrap-servers}")
//    private String bootstrapAddress;

//    @Bean
//    public ConsumerFactory<String, ProductDTO> consumerFactory() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(
//                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
//                bootstrapAddress);
//        props.put(
//                ConsumerConfig.GROUP_ID_CONFIG,
//                "my-group");
//        props.put(
//                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
//                StringDeserializer.class);
//        props.put(
//                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
//                JsonDeserializer.class);
//        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new org.springframework.kafka.support.serializer.JsonDeserializer<>(ProductDTO.class));
//    }

//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, ProductDTO>
//    kafkaListenerContainerFactory() {
//
//        ConcurrentKafkaListenerContainerFactory<String, ProductDTO> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }
}
