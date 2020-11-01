package pl.ug.kuznia.todoappapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TodoAppApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoAppApiApplication.class, args);
    }

    @GetMapping
    String hello(){
        return "hello";
    }
}
