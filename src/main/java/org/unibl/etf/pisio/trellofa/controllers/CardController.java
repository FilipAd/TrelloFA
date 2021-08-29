package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Card;
import org.unibl.etf.pisio.trellofa.models.SingleCard;
import org.unibl.etf.pisio.trellofa.models.requests.CardRequest;
import org.unibl.etf.pisio.trellofa.services.CardService;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController
{
private final CardService cardService;

    public CardController(CardService cardService)
    {
        this.cardService = cardService;
    }


    @GetMapping
    List<Card> findAll()
    {
        return cardService.findAll();
    }
    @GetMapping("/{id}")
    SingleCard findById(@PathVariable Integer id) throws NotFoundException
    {
        return cardService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id)
    {
        cardService.delete(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Card insert(@RequestBody CardRequest cardRequest)throws NotFoundException
    {
        return cardService.insert(cardRequest);
    }
    @PutMapping("/{id}")
    public Card update(@PathVariable Integer id,@RequestBody CardRequest cardRequest)throws NotFoundException
    {
        return cardService.update(id,cardRequest);
    }

}
