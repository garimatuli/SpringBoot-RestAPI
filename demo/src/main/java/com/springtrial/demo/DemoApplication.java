package com.springtrial.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This class which contains @SpringBootApplication annotation and has the main method is the entry point of spring boot application

@SpringBootApplication
public class DemoApplication {

	// The main() method uses Spring Boot’s SpringApplication.run() method to launch an application.
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

/* @SpringBootApplication annotation is used to mark a configuration class
 * that declares one or more @Bean methods and also triggers auto-configuration and component scanning.
 * It's same as declaring a class with @Configuration, @EnableAutoConfiguration and @ComponentScan annotations.
 *
 * @EnableAutoConfiguration automatically configures classes present on the classpath,
 * For example, if spring-webmvc is on the classpath,
 * this annotation flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet.
 * Auto-configuration solves the problem of doing amount of configuration in Spring framework,
 * it detects the dependency in a pom.xml file and according to that it configures the spring boot application.
 *
 * @Configuration annotation indicates that a class declares one or more @Bean methods and
 * may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime.
 * This is called Spring Java Config feature (using @Configuration annotation)
 *
 * Using the annotation @ComponentScan , you can tell Spring where do your Spring-managed components lie in the com/example package,
 *
 * whereas @SpringBootApplication  is equivalent to three annotations, so it does configurations as well as component scanning./
 */
