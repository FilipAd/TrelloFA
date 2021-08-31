package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.MembersOnCards;
import org.unibl.etf.pisio.trellofa.models.requests.MembersOnCardsRequest;
import org.unibl.etf.pisio.trellofa.services.MembersOnCardsService;

import java.util.List;

@RestController
@RequestMapping("/membersoncards")
public class MembersOnCardsController
{
    private final MembersOnCardsService membersOnCardsService;

    public MembersOnCardsController(MembersOnCardsService membersOnCardsService)
    {
        this.membersOnCardsService = membersOnCardsService;

    }
    @GetMapping
    public List<MembersOnCards> findAll()
    {
        return membersOnCardsService.findAll();
    }
    @GetMapping("/{id}")
    public MembersOnCards findById(@PathVariable Integer id) throws NotFoundException
    {
        return membersOnCardsService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id)
    {
        membersOnCardsService.delete(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MembersOnCards insert(@RequestBody MembersOnCardsRequest membersOnCardsRequest)throws NotFoundException
    {
        return membersOnCardsService.insert(membersOnCardsRequest);
    }
    @PutMapping("/{id}")
    public MembersOnCards update(@PathVariable Integer id,@RequestBody MembersOnCardsRequest membersOnCardsRequest) throws NotFoundException {
        return membersOnCardsService.update(id,membersOnCardsRequest);
    }


}
