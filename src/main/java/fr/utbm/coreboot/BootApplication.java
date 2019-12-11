package fr.utbm.coreboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = {"fr.utbm.coreboot"})
@EnableJpaAuditing
public class BootApplication
        extends SpringBootServletInitializer implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BootApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
