package blackboxrunner;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

@Component
public class KafkaSender {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private String destination;
    private KafkaProducer producer;
    private Properties kafkaConfig;

    @PostConstruct
    public void init (){
        producer = new KafkaProducer(kafkaConfig);
    }

    protected void processMessage(String message, Integer index) throws ExecutionException, InterruptedException {
        try {

            JSONObject jsonObj = new JSONObject(message);
            producer.send(new ProducerRecord(destination, index.toString(), message)).get();
            System.out.println(jsonObj);
        } catch (JSONException e) {
            logger.error("Ignoring non-json message which was send by black box! \n " + message);
        }
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setKafkaConfig(Properties kafkaConfig) {
        this.kafkaConfig = kafkaConfig;
    }

    @PreDestroy
    public void destroy (){
        producer.close();
    }
}
