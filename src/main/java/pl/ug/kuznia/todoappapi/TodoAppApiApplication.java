package pl.ug.kuznia.todoappapi;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import pl.ug.kuznia.todoappapi.internal.label.LabelDto;
import pl.ug.kuznia.todoappapi.internal.label.LabelService;

@SpringBootApplication
@AllArgsConstructor
public class TodoAppApiApplication {

    private final LabelService labelService;

    public static void main(String[] args) {
        SpringApplication.run(TodoAppApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner setup(ApplicationContext ctx){
        return args->{
            if (labelService.isEmpty()){
                labelService.addLabel(new LabelDto("work"));
                labelService.addLabel(new LabelDto("house"));
                labelService.addLabel(new LabelDto("gym"));
            }
        };
    }

}
