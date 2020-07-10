package br.com.filipeapp.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Validated
@Configuration
@ConfigurationProperties(prefix = "filipeapp")
public class AppConfigurationProperties {

	@URL(message = "Invalid URL")
	private String defaultHost;
	
	@NotEmpty(message = "One or more APIs should be configurated")
	private List<ApiProperties> apis = new ArrayList<>();
	
	
	
	@Getter
	@Setter
	public static class ApiProperties{
		
		@Pattern(regexp = "([0-9a-z]{1,10})", message = "Name must be ([0-9a-z]{1, 10})")
		private String name;

		@URL(message = "Invalid URL endpoint Service")
		private String endpointService;		
		
		@NotNull(message = "Timeout can not be null")
		@Range(min = 100, max = 5000, message = "Range must be between 100 and 5000")
		private Long timeout;
		
	}
	
}
