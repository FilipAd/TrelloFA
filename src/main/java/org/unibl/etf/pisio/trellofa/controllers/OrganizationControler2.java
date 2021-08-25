package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.trellofa.models.entities.OrganizationEntity;
import org.unibl.etf.pisio.trellofa.repositories.OrganizationEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/organizations2")
public class OrganizationControler2
{
    private final OrganizationEntityRepository repository;

    public OrganizationControler2(OrganizationEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<OrganizationEntity> findAll()
    {
        return repository.findAll();
    }
}
