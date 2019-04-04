package org.lalajiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class Application {

    public static void main(final String... args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping({"/", "/login"})
    public String info() {
        return "index";
    }
}
