package pl.ug.kuznia.todoappapi.internal.card;

import org.springframework.web.bind.annotation.*;
import pl.ug.kuznia.todoappapi.internal.label.LabelDto;

import java.util.List;

@RestController
@RequestMapping("cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public Iterable<Card> findAllCards() {
        return cardService.findAllCards();
    }

    @PostMapping
    public Card addNewCard(@RequestBody CardDTO cardDTO) {
        return cardService.addCard(cardDTO);
    }

    @PostMapping("/{id}/label")
    public Card attachLabel(@PathVariable long id, @RequestBody LabelDto labelDto){
        return cardService.attachLabel(id, labelDto);
    }

}
