package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Card;
import org.unibl.etf.pisio.trellofa.models.SingleList;
import org.unibl.etf.pisio.trellofa.models.requests.ListRequest;
import org.unibl.etf.pisio.trellofa.services.CardService;
import org.unibl.etf.pisio.trellofa.services.ListService;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class ListController
{
    private final ListService service;
    private final CardService cardService;
    public ListController(ListService service, CardService cardService)
    {
        this.service = service;
        this.cardService = cardService;
    }


    @GetMapping
    List<org.unibl.etf.pisio.trellofa.models.List> findAll()
    {
        return service.findAll();
    }
    @GetMapping("/{id}/cards")
    public List<Card> findAllCardsByListId(@PathVariable Integer id)
    {
       return cardService.getAllCardsByListId(id);
    }
    @GetMapping("/{id}")
    SingleList findById(@PathVariable Integer id) throws NotFoundException
    {
        return service.findById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id)
    {
        service.delete(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public org.unibl.etf.pisio.trellofa.models.List insert(@RequestBody ListRequest listRequest)throws NotFoundException
    {
        return service.insert(listRequest);
    }
    @PutMapping("/{id}")
    public org.unibl.etf.pisio.trellofa.models.List insert(@PathVariable Integer id,@RequestBody ListRequest listRequest)throws NotFoundException
    {
        return service.update(id,listRequest);
    }

}
