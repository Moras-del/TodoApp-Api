package pl.ug.kuznia.todoappapi.internal.label;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("labels")
@AllArgsConstructor
public class LabelController {

    private final LabelService labelService;

    @GetMapping
    public Iterable<Label> findAllLabels(){
        return labelService.findAllLabels();
    }

    @PostMapping
    public Label addNewLabel(@RequestBody LabelDto labelDto){
        return labelService.addLabel(labelDto);
    }


}
