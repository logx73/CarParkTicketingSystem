import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.psystem.*"})
@ComponentScan(basePackages = {"com.psystem.*"})
@EnableJpaRepositories(basePackages = {"com.psystem.*"})
public class CarParkTicketingApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarParkTicketingApplication.class);
    }
}
