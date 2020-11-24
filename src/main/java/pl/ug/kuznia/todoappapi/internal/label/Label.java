package pl.ug.kuznia.todoappapi.internal.label;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.Cascade;
import pl.ug.kuznia.todoappapi.internal.card.Card;

@Entity
@Data
@NoArgsConstructor
public class Label {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String name;

    @ManyToMany(mappedBy = "labels")
    @Setter(AccessLevel.NONE)
    @JsonBackReference
    private List<Card> cards = new ArrayList<>();

    public Label(@NotNull String name) {
        this.name = name;
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card){
        cards.remove(card);
    }
}
