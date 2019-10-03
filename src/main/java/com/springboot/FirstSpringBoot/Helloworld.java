package com.springboot.FirstSpringBoot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworld 
{
	@RequestMapping("/hello")
	public String hello()
	{
		System.out.println("Hello!");
		return "hello!";
	}
}
