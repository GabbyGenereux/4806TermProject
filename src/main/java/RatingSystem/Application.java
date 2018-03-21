package RatingSystem;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages= {"RatingSystem"})
@ComponentScan("RatingSystem")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
