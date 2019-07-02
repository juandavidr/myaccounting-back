package com.example.demo;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.data.ExpenseRepository;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableEurekaClient
@EnableSwagger2
@RefreshScope
@RestController
public class DemoApplication {
	private static final Logger LOG = Logger.getLogger(DemoApplication.class.getName());

	@Value("${welcome.message}")
	String welcomeText;
	@Autowired
	ExpenseRepository pRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/products").allowedOrigins("http://localhost:8080");
				registry.addMapping("/").allowedOrigins("http://localhost:8761");
				registry.addMapping("/expenses").allowedOrigins("http://localhost:3000");
				registry.addMapping("/expenses-types").allowedOrigins("http://localhost:3000");
				registry.addMapping("/payment-type").allowedOrigins("http://localhost:3000");
			}
		};
	}

	/**
	 * Index method returning the configured welcome message
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		LOG.log(Level.INFO, "Index API is calling");
		return welcomeText + "\n this is also de eureka client";
	}

	/**
	 * Clase necesaria para registrarse en el admin server
	 * 
	 * @author jd.rodriguez
	 *
	 */
	@Configuration
	public static class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
		}
	}

	/**
	 * Bean necesario para habilitar swagger en el paquete indicado
	 * 
	 * @return
	 */
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller")).build();
	}

	/**
	 * Demo cmd for JPA access
	 * 
	 * @param repository
	 * @return
	 */

	@GetMapping(path = "/test")
	public @ResponseBody String demo() {

//		LOG.info("Starting demo");
//		// save a couple of customers
//		repository.save(new Customer("Jack", "Bauer"));
//		repository.save(new Customer("Chloe", "O'Brian"));
//		repository.save(new Customer("Kim", "Bauer"));
//		repository.save(new Customer("David", "Palmer"));
//		repository.save(new Customer("Michelle", "Dessler"));
//
//		// fetch all customers
//		LOG.info("Customers found with findAll():");
//		LOG.info("-------------------------------");
//		for (Customer customer : repository.findAll()) {
//			LOG.info(customer.toString());
//		}
//		LOG.info("");
//
//		// fetch an individual customer by ID
//		repository.findById(1L).ifPresent(customer -> {
//			LOG.info("Customer found with findById(1L):");
//			LOG.info("--------------------------------");
//			LOG.info(customer.toString());
//			LOG.info("");
//		});
//
//		// fetch customers by last name
//		LOG.info("Customer found with findByLastName('Bauer'):");
//		LOG.info("--------------------------------------------");
//		repository.findByLastName("Bauer").forEach(bauer -> {
//			LOG.info(bauer.toString());
//		});
//
//		LOG.info("Adding products");
//		for(int i = 0; i<10; i++) {
//			pRepository.save(new Product("Producto_"+i));
//		}
//		LOG.info("finding product with name like 1");
//		pRepository.findByName("1").forEach(product ->{
//			LOG.info(product.toString());
//		});;
//		LOG.info("");
		return "nothing done";

	}

}