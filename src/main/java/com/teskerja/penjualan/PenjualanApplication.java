package com.teskerja.penjualan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PenjualanApplication {

	public static void main(String[] args) {
		SpringApplication.run(PenjualanApplication.class, args);
	}

}
