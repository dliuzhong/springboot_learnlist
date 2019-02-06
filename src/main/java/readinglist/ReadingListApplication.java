package readinglist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ReadingListApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ReadingListApplication.class, args);
	}
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/readingList");
	}

}

