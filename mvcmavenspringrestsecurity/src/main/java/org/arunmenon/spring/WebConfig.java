package org.arunmenon.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan("org.arunmenon.web")
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    public WebConfig() {
        super();
    }

}
