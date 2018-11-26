package com.example.demogridflow;

import com.example.demogridflow.entity.Price;
import com.example.demogridflow.entity.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class DemoGridFlowApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoGridFlowApplication.class, args);
	}

	//@Bean
//	public CommandLineRunner st(PriceRepository repository) {
//		return args->repository.save(new Price(LocalDate.now()));
//	}
}
