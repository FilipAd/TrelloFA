package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.trellofa.models.entities.MemberEntity;
import org.unibl.etf.pisio.trellofa.repositories.MemberEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController
{
    private final MemberEntityRepository repository;

    public MemberController(MemberEntityRepository repository)
    {
        this.repository = repository;
    }
    @GetMapping
    List<MemberEntity> findAll()
    {
        return repository.findAll();
    }
}
