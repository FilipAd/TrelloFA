package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Attachment;
import org.unibl.etf.pisio.trellofa.models.entities.AttachmentEntity;
import org.unibl.etf.pisio.trellofa.services.AttachmentService;

import java.nio.file.NotDirectoryException;
import java.util.List;

@RestController
@RequestMapping("/attachments")
public class AttachmentController
{
  private final AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService)
    {
        this.attachmentService = attachmentService;
    }


    @GetMapping
    List<Attachment> findAll()
    {

        return attachmentService.findAll();
    }
    @GetMapping("/{id}")
    Attachment findById(@PathVariable Integer id) throws NotFoundException
    {
        return attachmentService.findById(id);
    }


}
