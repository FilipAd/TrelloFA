package org.unibl.etf.pisio.trellofa.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Attachment;
import org.unibl.etf.pisio.trellofa.repositories.AttachmentEntityRepository;
import org.unibl.etf.pisio.trellofa.services.AttachmentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttachmentServiceImpl implements AttachmentService
{

    private final AttachmentEntityRepository repository;
    private final ModelMapper attachmentMapper;

    public AttachmentServiceImpl(AttachmentEntityRepository repository, ModelMapper attachmentMapper)
    {
        this.repository = repository;
        this.attachmentMapper = attachmentMapper;
    }


    @Override
    public List<Attachment> findAll()
    {
        return repository.findAll().stream().map(e->attachmentMapper.map(e,Attachment.class)).collect(Collectors.toList());
    }

    @Override
    public Attachment findById(Integer id) throws NotFoundException {
        return attachmentMapper.map(repository.findById(id).orElseThrow(NotFoundException::new),Attachment.class);
    }
}
