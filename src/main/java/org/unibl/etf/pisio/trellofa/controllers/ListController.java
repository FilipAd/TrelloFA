package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.SingleList;
import org.unibl.etf.pisio.trellofa.models.entities.ListEntity;
import org.unibl.etf.pisio.trellofa.models.requests.ListRequest;
import org.unibl.etf.pisio.trellofa.services.ListService;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class ListController
{
    private final ListService service;

    public ListController(ListService service)
    {
        this.service = service;
    }


    @GetMapping
    List<org.unibl.etf.pisio.trellofa.models.List> findAll()
    {
        return service.findAll();
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
