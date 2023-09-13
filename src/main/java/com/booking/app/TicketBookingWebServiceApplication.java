package com.booking.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class TicketBookingWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingWebServiceApplication.class, args);
	}

}
