package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Label;
import org.unibl.etf.pisio.trellofa.models.entities.LabelEntity;
import org.unibl.etf.pisio.trellofa.models.requests.LabelRequest;
import org.unibl.etf.pisio.trellofa.services.LabelService;

import java.util.List;

@RestController
@RequestMapping("/labels")

public class LabelController
{
    private final LabelService labelService;

    public LabelController(LabelService labelService)
    {
        this.labelService = labelService;
    }

    @GetMapping
    List<Label> findAll()
    {
        return labelService.findAll();
    }
    @GetMapping("/{id}")
    Label findById(@PathVariable Integer id) throws NotFoundException
    {
        return labelService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(Integer id)throws NotFoundException
    {
        labelService.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Label insert(@RequestBody LabelRequest labelRequest)throws NotFoundException
    {
        return labelService.insert(labelRequest);
    }
    @PutMapping("/{id}")
    public Label update(@PathVariable Integer id,@RequestBody LabelRequest labelRequest)throws NotFoundException
    {
        return labelService.update(id,labelRequest);
    }



}
