package com.college.Employee;

import com.college.Employee.entity.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class EmployeeApplication {
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
        System.out.println("Start");

    }
}


