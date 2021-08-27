package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Membership;
import org.unibl.etf.pisio.trellofa.models.entities.MembershipEntity;
import org.unibl.etf.pisio.trellofa.services.MembershipService;

import java.util.List;

@RestController
@RequestMapping("/memberships")
public class MembershipController
{
   private final MembershipService membershipService;

    public MembershipController(MembershipService membershipService)
    {
        this.membershipService = membershipService;
    }


    @GetMapping
    List<Membership> findAll()
    {
       return membershipService.findAll();
    }
    @GetMapping("/{id}")
    Membership findById(@PathVariable Integer id) throws NotFoundException
    {
        return membershipService.findById(id);
    }

}
