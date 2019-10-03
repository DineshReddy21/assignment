import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"userInput"})
public class UserInputApplication extends SpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserInputApplication.class, args);
    }
}
