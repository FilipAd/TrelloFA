package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.trellofa.models.entities.ListEntity;
import org.unibl.etf.pisio.trellofa.repositories.ListEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class ListController
{
    private final ListEntityRepository repository;

    public ListController(ListEntityRepository repository)
    {
        this.repository = repository;
    }
    @GetMapping
    List<ListEntity> findAll()
    {
        return repository.findAll();
    }

}
