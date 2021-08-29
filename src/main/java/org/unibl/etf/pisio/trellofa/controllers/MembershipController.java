package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Membership;
import org.unibl.etf.pisio.trellofa.models.entities.MembershipEntity;
import org.unibl.etf.pisio.trellofa.models.requests.MembershipRequest;
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
    public List<Membership> findAll()
    {
       return membershipService.findAll();
    }
    @GetMapping("/{id}")
    public Membership findById(@PathVariable Integer id) throws NotFoundException
    {
        return membershipService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id)
    {
        membershipService.delete(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Membership insert(@RequestBody MembershipRequest membershipRequest) throws NotFoundException
    {
       return membershipService.insert(membershipRequest);
    }

    @PutMapping("/{id}")
    public Membership update(@PathVariable Integer id,@RequestBody MembershipRequest membershipRequest) throws NotFoundException
    {
        return membershipService.update(id,membershipRequest);
    }




}
