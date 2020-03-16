package de.fintegra;

import de.fintegra.service.HelloMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.exit;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Autowired
    private HelloMessageService helloService;

    public static void main(String[] args) throws Exception {

        SpringApplication app = new SpringApplication(SpringBootConsoleApplication.class);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {

        if (args.length > 0 ) {
            System.out.println(helloService.getMessage(args[0].toString()));
        }else{
            System.out.println(helloService.getMessage());
        }
        // wait until sigterm?
        Thread.currentThread().join();
        exit(0);
    }
}