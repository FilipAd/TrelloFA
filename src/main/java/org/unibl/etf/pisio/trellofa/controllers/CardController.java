package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.trellofa.models.entities.CardEntity;
import org.unibl.etf.pisio.trellofa.repositories.CardEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController
{
    private final CardEntityRepository repository;

    public CardController(CardEntityRepository repository)
    {
        this.repository = repository;
    }
    @GetMapping
    List<CardEntity> findAll()
    {
        return repository.findAll();
    }
}
