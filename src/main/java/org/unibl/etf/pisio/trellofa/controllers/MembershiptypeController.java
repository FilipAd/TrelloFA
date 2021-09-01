package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Membership;
import org.unibl.etf.pisio.trellofa.models.Membershiptype;
import org.unibl.etf.pisio.trellofa.models.SingleMembershiptype;
import org.unibl.etf.pisio.trellofa.models.requests.MembershiptypeRequest;
import org.unibl.etf.pisio.trellofa.services.MembershipService;
import org.unibl.etf.pisio.trellofa.services.MembershiptypeService;

import java.util.List;

@RestController
@RequestMapping("/membershiptypes")
public class MembershiptypeController
{
    private final MembershiptypeService service;
    private final MembershipService membershipService;

    public MembershiptypeController(MembershiptypeService service, MembershipService membershipService)
    {
        this.service = service;
        this.membershipService = membershipService;
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
    @GetMapping("/{id}/memberships")
    public List<Membership> findAllMembershipsByMembershiptype(@PathVariable Integer id)
    {
        return membershipService.getAllMembershipsByMembershiptypeId(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id)throws NotFoundException
    {
        service.delete(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Membershiptype insert(@RequestBody MembershiptypeRequest membershiptypeRequest) throws NotFoundException
    {
        return service.insert(membershiptypeRequest);
    }
    @PutMapping("/{id}")
    public  Membershiptype update(@PathVariable Integer id,@RequestBody MembershiptypeRequest membershiptypeRequest) throws NotFoundException
    {
        return service.update(id,membershiptypeRequest);
    }

}
