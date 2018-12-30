package blackboxrunner;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Properties;

/**
 * Created by Erik Feigin on 30/12/2018.
 */
@Configuration
public class Config {
    @Autowired
    private Environment env;

    @Bean
    public KafkaSender kafkaSender(){

        KafkaSender kafkaSender = new KafkaSender();
        kafkaSender.setDestination("from-black-box");
        Properties kafkaConfig = new Properties();
        kafkaConfig.put("bootstrap.servers", env.getProperty("kafka.bootstrap.servers"));
        kafkaConfig.put("client.id", env.getProperty("spring.kafka.producer.client-id"));
        kafkaConfig.put("key.serializer", StringSerializer.class);
        kafkaConfig.put("value.serializer", StringSerializer.class);
        kafkaSender.setKafkaConfig(kafkaConfig);
        return kafkaSender;
    }
}
