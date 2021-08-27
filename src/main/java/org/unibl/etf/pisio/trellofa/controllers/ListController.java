package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.SingleList;
import org.unibl.etf.pisio.trellofa.models.entities.ListEntity;
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

}
