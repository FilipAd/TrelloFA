package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.trellofa.models.entities.MembershiptypeEntity;
import org.unibl.etf.pisio.trellofa.repositories.MembershiptypeEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/membershiptypes")
public class MembershiptypeController
{
    private final MembershiptypeEntityRepository repository;

    public MembershiptypeController(MembershiptypeEntityRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping
    List<MembershiptypeEntity> findAll()
    {
        return repository.findAll();
    }
}
