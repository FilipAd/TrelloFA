package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Label;
import org.unibl.etf.pisio.trellofa.models.entities.LabelEntity;
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

}
