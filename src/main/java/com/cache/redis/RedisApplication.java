package com.cache.redis;

import com.cache.redis.records.ProductRecord;
import com.cache.redis.services.ProductService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableCaching
public class RedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

	@Bean
	ApplicationRunner runner(ProductService productService) {
		return args -> {
			System.out.println("\n\n\n\n\n\n");
			Long initialTime;
			Long finalTime;
			initialTime = System.currentTimeMillis();
			System.out.println("Id: 1: "+ productService.getById(1L));
			System.out.println("Id: 2: "+ productService.getById(2L));
			System.out.println("Id: 3: "+ productService.getById(1L));
			System.out.println("Id: 4: "+ productService.getById(1L));
			System.out.println("Id: 5: "+ productService.getById(1L));
			finalTime = System.currentTimeMillis();
			System.out.println("Time taken: " + (finalTime - initialTime)/1000 + " seconds");
		};
	}

}





