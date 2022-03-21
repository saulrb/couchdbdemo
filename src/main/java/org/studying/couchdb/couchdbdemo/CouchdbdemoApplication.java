package org.studying.couchdb.couchdbdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("org.studying.couchdb.couchdbdemo")
@SpringBootApplication
@EnableDiscoveryClient
public class CouchdbdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouchdbdemoApplication.class, args);
	}

}
