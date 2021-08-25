package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.trellofa.models.entities.AttachmentEntity;
import org.unibl.etf.pisio.trellofa.repositories.AttachmentEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/attachments")
public class AttachmentController
{
    private final AttachmentEntityRepository repository;

    public AttachmentController(AttachmentEntityRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping
    List<AttachmentEntity> findAll()
    {
        return repository.findAll();
    }


}
