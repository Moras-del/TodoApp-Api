package pl.ug.kuznia.todoappapi.internal.card;

import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.ug.kuznia.todoappapi.internal.exceptions.ResourceNotFoundException;
import pl.ug.kuznia.todoappapi.internal.label.Label;
import pl.ug.kuznia.todoappapi.internal.label.LabelDto;
import pl.ug.kuznia.todoappapi.internal.label.LabelService;

import java.net.http.HttpResponse;
import java.util.List;

@Service
@AllArgsConstructor
public class CardService {

    private final CardRepository cardRepository;
    private final LabelService labelService;

    public Card addCard(CardDTO cardDTO) {
        //ToDo validate cardDTO
        Card cardToAdd = cardDTO.createCard();
        return cardRepository.save(cardToAdd);
    }

    public Iterable<Card> findAllCards() {
        return cardRepository.findAll();
    }

    public Card attachLabel(long id, LabelDto labelDto) {
        Card card = cardRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Card"));

        Label label = labelService.get(labelDto);
        card.addLabel(label);
        return cardRepository.save(card);
    }
}
