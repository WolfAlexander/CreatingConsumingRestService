package application.configuration;

import application.model.StudentHandler;
import application.persistence.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public RestClient restClient(RestTemplate restTemplate){
        return new RestClient(restTemplate);
    }

    @Bean
    @Lazy
    public StudentHandler studentHandler(RestClient restClient){
        return new StudentHandler(restClient);
    }
}
