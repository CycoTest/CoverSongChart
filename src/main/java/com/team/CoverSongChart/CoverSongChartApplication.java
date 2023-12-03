package com.team.CoverSongChart;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Cover Song Chart Project",
				version = "1.0",
				description = "Bench Marking Youtube Music Player",
				termsOfService = "https://github.com/CycoTest/CoverSongChart",
				contact = @Contact(
						name = "Simond.K",
						email = "aceldamadk@gmail.com"
				),
				license = @License(
						name = "CsC",
						url = "http://localhost:8080/home"
				)
		)
)
@SpringBootApplication
public class CoverSongChartApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoverSongChartApplication.class, args);
	}

}
