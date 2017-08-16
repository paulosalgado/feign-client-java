package com.paulosalgado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class FeignClientJavaApplication {
	
	@Autowired
    private GreetingClient greetingClient;
	
	public static void main(String[] args) {
		SpringApplication.run(FeignClientJavaApplication.class, args);
	}
	
	@RequestMapping("/get-greeting")
	public String greeting(Model model) {
		model.addAttribute("greeting", greetingClient.greeting());
		return "greeting-view";
	}
	
}
