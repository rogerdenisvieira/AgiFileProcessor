package br.com.ominilabs.agifileprocessor;


import br.com.ominilabs.agifileprocessor.routes.FileRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.language.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication


public class AgiFileprocessorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgiFileprocessorApplication.class, args);

    }
}
