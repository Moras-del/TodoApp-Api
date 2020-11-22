package pl.ug.kuznia.todoappapi.internal.card;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Cascade;
import pl.ug.kuznia.todoappapi.internal.label.Label;

import javax.persistence.*;
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

    @ManyToMany
    @JoinTable(
            name = "labels_cards",
            joinColumns = @JoinColumn(name = "label_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id")
    )
    @Cascade({org.hibernate.annotations.CascadeType.PERSIST,
            org.hibernate.annotations.CascadeType.MERGE,
            org.hibernate.annotations.CascadeType.REFRESH,
            org.hibernate.annotations.CascadeType.DETACH
    })
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @JsonManagedReference
    @Builder.Default
    List<Label> labels = new ArrayList<>();

    public List<Label> getLabels() {
        return Collections.unmodifiableList(labels);
    }

    public void addLabel(Label label) {
        labels.add(label);
        label.addCard(this);
    }

    public void removeLabel(Label label){
        labels.remove(label);
        label.removeCard(this);
    }
}
