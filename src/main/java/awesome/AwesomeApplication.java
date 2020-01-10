package awesome;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("awesome")
public class AwesomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwesomeApplication.class, args);
    }

}
