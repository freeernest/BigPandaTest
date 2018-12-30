package blackboxrunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

/**
 * Created by Erik Feigin on 29/12/2018.
 */
@Component
public class BlackBoxRunner {

    @Autowired
    public KafkaSender kafkaSender;

    String path = this.getClass().getClassLoader().getResource("generator-windows-amd64.exe").getPath();
    String line;
    int counter;

    public void run() throws ExecutionException, InterruptedException, IOException {
        Process process = Runtime.getRuntime().exec(path);
        try (BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            while ((line = input.readLine()) != null) {
                counter++;
                kafkaSender.processMessage(line, counter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            process.destroyForcibly();
        }
    }

    public void setKafkaSender(String kafkaSender) {
    }
}
