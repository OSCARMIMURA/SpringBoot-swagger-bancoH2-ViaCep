package dio.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class EnderecosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnderecosApplication.class, args);
	}

}
