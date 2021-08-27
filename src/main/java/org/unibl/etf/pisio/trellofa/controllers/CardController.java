package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Card;
import org.unibl.etf.pisio.trellofa.models.SingleCard;
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

}
