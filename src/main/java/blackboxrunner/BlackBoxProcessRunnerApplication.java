package blackboxrunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class BlackBoxProcessRunnerApplication {


    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(BlackBoxProcessRunnerApplication.class);
        ConfigurableApplicationContext context = new SpringApplicationBuilder().sources(BlackBoxProcessRunnerApplication.class).run(args);

        BlackBoxRunner blackBoxRunner = context.getBean(BlackBoxRunner.class);

        try {
            blackBoxRunner.run();
        } catch (Exception e) {
            logger.error("An exception was thrown when running black box.", e);
        }

    }
}
