package pl.ug.kuznia.todoappapi.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello world!";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserCredentials userCredentials) {
        if(!userCredentials.getUsername().equals("ven")) {
            return "Nie udalo sie zalogowac, zly login";
        }
        if(!userCredentials.getPassword().equals("nev")) {
            return "Nie udalo sie zalogowac, zle haslo";
        }
        return "Udalo sie zalogowac";
    }
}
