package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.trellofa.models.entities.MembershipEntity;
import org.unibl.etf.pisio.trellofa.repositories.MemberEntityRepository;
import org.unibl.etf.pisio.trellofa.repositories.MembershipEntityRepository;
import org.unibl.etf.pisio.trellofa.repositories.MembershiptypeEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/memberships")
public class MembershipController
{
    private final MembershipEntityRepository repository;

    public MembershipController(MembershipEntityRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping
    List<MembershipEntity> findAll()
    {
       return repository.findAll();
    }

}
