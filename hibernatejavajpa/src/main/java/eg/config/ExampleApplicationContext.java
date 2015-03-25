package eg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import eg.config.service.PersistentContextService;

@Configuration
@Import({ PersistenceContext.class})
@ComponentScan({"eg.config.service"})
public class ExampleApplicationContext {

	@Bean
    PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
	
	@Profile(Profiles.APPLICATION)
    @Configuration
    @PropertySource("classpath:application.properties")
    static class ApplicationProperties {}
}
