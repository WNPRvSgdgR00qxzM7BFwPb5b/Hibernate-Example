package pl.sda.sapiens.ep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "pl.sda.sapiens.ep")
public class ProjectTemplateApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ProjectTemplateApplication.class);
    }

    public static void main(String[] args) {

        SpringApplication.run(ProjectTemplateApplication.class, args);

    }

}
