package pl.ug.kuznia.todoappapi.internal.label;

import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import pl.ug.kuznia.todoappapi.internal.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class LabelService {

    private final LabelRepository labelRepository;

    public boolean isEmpty(){
        return labelRepository.count() == 0;
    }

    public Label addLabel(LabelDto dto){
        Label label = dto.createLabel();
        return labelRepository.save(label);
    }

    public void setupLabels(String... names){
        if (isEmpty()) {
            for (String name : names)
                labelRepository.save(new Label(name));
        }
    }

    public Iterable<Label> findAllLabels() {
        return labelRepository.findAll();
    }

    public Label get(LabelDto labelDto) {
        return labelRepository.findByName(labelDto.getName())
                .orElseThrow(()->new ResourceNotFoundException("Label"));
    }
}
