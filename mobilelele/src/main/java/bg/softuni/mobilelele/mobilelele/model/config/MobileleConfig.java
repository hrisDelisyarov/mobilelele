package bg.softuni.mobilelele.mobilelele.model.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MobileleConfig {

    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
}
