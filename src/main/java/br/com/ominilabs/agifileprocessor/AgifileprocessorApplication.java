package br.com.ominilabs.agifileprocessor;

import br.com.ominilabs.agifileprocessor.routes.FileRouteBuilder;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgifileprocessorApplication {

	public static void main(String[] args) {

		SpringApplication.run(AgifileprocessorApplication.class, args);

		CamelContext context = new DefaultCamelContext();
		RouteBuilder fileRoute = new FileRouteBuilder();

		try {
			context.addRoutes(fileRoute);
			context.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
