package org.unibl.etf.pisio.trellofa.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Attachment;
import org.unibl.etf.pisio.trellofa.models.entities.AttachmentEntity;
import org.unibl.etf.pisio.trellofa.models.entities.OrganizationEntity;
import org.unibl.etf.pisio.trellofa.models.requests.AttachmentRequest;
import org.unibl.etf.pisio.trellofa.repositories.AttachmentEntityRepository;
import org.unibl.etf.pisio.trellofa.services.AttachmentService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AttachmentServiceImpl implements AttachmentService
{

    private final AttachmentEntityRepository repository;
    private final ModelMapper attachmentMapper;
    @PersistenceContext
    private EntityManager entityManager;

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

    @Override
    public List<Attachment> getAllAttachmentsByMemberId(Integer id)
    {
        return repository.findAllByMember_Id(id).stream().map(e->attachmentMapper.map(e,Attachment.class)).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id)throws NotFoundException
    {
        repository.deleteById(id);
    }

    @Override
    public Attachment insert(AttachmentRequest attachmentRequest) throws NotFoundException
    {
        AttachmentEntity attachmentEntity=attachmentMapper.map(attachmentRequest,AttachmentEntity.class);
        attachmentEntity.setId(null);
        attachmentEntity=repository.saveAndFlush(attachmentEntity);
        entityManager.refresh(attachmentEntity);
        return findById(attachmentEntity.getId());
    }

    @Override
    public Attachment update(Integer id, AttachmentRequest attachmentRequest) throws NotFoundException
    {
        AttachmentEntity attachmentEntity=attachmentMapper.map(attachmentRequest,AttachmentEntity.class);
        attachmentEntity.setId(id);
        attachmentEntity=repository.saveAndFlush(attachmentEntity);
        entityManager.refresh(attachmentEntity);
        return findById(attachmentEntity.getId());
    }
}
