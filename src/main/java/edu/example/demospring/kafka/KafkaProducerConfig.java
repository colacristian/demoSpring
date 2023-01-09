package edu.example.demospring.kafka;

//@Configuration
public class KafkaProducerConfig {

//    @Value(value = "${spring.kafka.bootstrap-servers}")
//    private String bootstrapAddress;

//    public ProducerFactory<String, ProductDTO> producerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(
//                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
//                bootstrapAddress);
//        configProps.put(
//                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
//                StringSerializer.class);
//        configProps.put(
//                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
//                JsonSerializer.class);
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }

//    @Bean
//    public KafkaTemplate<String, ProductDTO> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
}
