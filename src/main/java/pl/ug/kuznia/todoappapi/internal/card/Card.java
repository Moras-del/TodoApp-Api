package pl.ug.kuznia.todoappapi.internal.card;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import pl.ug.kuznia.todoappapi.internal.label.Label;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @ManyToMany(mappedBy = "cards")
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @JsonManagedReference
    List<Label> labels = new ArrayList<>();

    public List<Label> getLabels() {
        return Collections.unmodifiableList(labels);
    }

    public void addLabel(Label label) {
        labels.add(label);
    }

    public void removeLabel(Label label){
        labels.remove(label);
    }
}
