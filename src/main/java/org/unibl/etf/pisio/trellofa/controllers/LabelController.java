package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.trellofa.models.entities.LabelEntity;
import org.unibl.etf.pisio.trellofa.repositories.LabelEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/labels")

public class LabelController
{
    private final LabelEntityRepository repository;

    public LabelController(LabelEntityRepository repository)
    {
        this.repository = repository;
    }
    @GetMapping
    List<LabelEntity> findAll()
    {
        return repository.findAll();
    }

}
