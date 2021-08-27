package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Membershiptype;
import org.unibl.etf.pisio.trellofa.models.SingleMembershiptype;
import org.unibl.etf.pisio.trellofa.services.MembershiptypeService;

import java.util.List;

@RestController
@RequestMapping("/membershiptypes")
public class MembershiptypeController
{
    private final MembershiptypeService service;

    public MembershiptypeController(MembershiptypeService service)
    {
        this.service = service;
    }


    @GetMapping
    List<Membershiptype> findAll()
    {
        return service.findAll();
    }
    @GetMapping("/{id}")
    SingleMembershiptype findById(@PathVariable Integer id) throws NotFoundException
    {
        return service.findById(id);
    }

}
