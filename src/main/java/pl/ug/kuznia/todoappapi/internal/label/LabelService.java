package pl.ug.kuznia.todoappapi.internal.label;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

    public List<Label> findAllLabels() {
        return labelRepository.findAll();
    }
}
