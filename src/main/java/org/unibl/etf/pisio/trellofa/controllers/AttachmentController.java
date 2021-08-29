package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Attachment;
import org.unibl.etf.pisio.trellofa.models.entities.AttachmentEntity;
import org.unibl.etf.pisio.trellofa.models.requests.AttachmentRequest;
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
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id)
    {
        attachmentService.delete(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Attachment insert(@RequestBody AttachmentRequest attachmentRequest)throws NotFoundException
    {
        return attachmentService.insert(attachmentRequest);
    }

    @PutMapping("/{id}")
    public Attachment update(@PathVariable Integer id,@RequestBody AttachmentRequest attachmentRequest)throws NotFoundException
    {
        return attachmentService.update(id,attachmentRequest);
    }


}
