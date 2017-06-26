package com.sample.concurrent;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main application configuration class
 * 
 * @author pbansal
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.sample.concurrent")
public class Application {

    /**
     * Main class to start code flow.
     * 
     * @param args
     *            Arguments passed in line while deploying.
     */
    public static void main(final String... args) {

        new SpringApplicationBuilder(Application.class).build().run(args);

    }

}
