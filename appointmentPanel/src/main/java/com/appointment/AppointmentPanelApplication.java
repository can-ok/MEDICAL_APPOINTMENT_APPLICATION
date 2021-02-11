package com.appointment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.appointment.service.UserService;

@SpringBootApplication
public class AppointmentPanelApplication{

	public static void main(String[] args) {
		SpringApplication.run(AppointmentPanelApplication.class, args);
	}
	
}
