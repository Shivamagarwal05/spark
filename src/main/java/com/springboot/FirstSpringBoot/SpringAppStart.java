package com.springboot.FirstSpringBoot;


	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.springboot.FirstSpringBoot.Repository.UserRepository;
import com.springboot.FirstSpringBoot.Service.UserRepositoryService;
	//import org.springframework.context.annotation.ComponentScan;
	@SpringBootApplication(scanBasePackages={
			"com.springboot.FirstSpringBoot.Controller", "com.springboot.FirstSpringBoot.Model","com.springboot.FirstSpringBoot.Repository","com.springboot.FirstSpringBoot.Service"})

	public class SpringAppStart {
		
		public static void main(String[] args) 
		{
			// TODO Auto-generated method stub
			SpringApplication.run(SpringAppStart.class, args);

		}

	}

