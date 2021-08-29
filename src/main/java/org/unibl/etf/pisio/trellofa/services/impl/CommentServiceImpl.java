package org.unibl.etf.pisio.trellofa.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Comment;
import org.unibl.etf.pisio.trellofa.models.entities.CommentEntity;
import org.unibl.etf.pisio.trellofa.models.requests.CommentRequest;
import org.unibl.etf.pisio.trellofa.repositories.CommentEntityRepository;
import org.unibl.etf.pisio.trellofa.services.CommentService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CommentServiceImpl implements CommentService
{
    private final CommentEntityRepository repository;
    private final ModelMapper mapper;
    @PersistenceContext
   private EntityManager entityManager;

    public CommentServiceImpl(CommentEntityRepository repository, ModelMapper mapper)
    {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Comment> findAll() {
        return repository.findAll().stream().map(e->mapper.map(e,Comment.class)).collect(Collectors.toList());
    }

    @Override
    public Comment findById(Integer id) throws NotFoundException {
        return mapper.map(repository.findById(id).orElseThrow(NotFoundException::new),Comment.class);
    }

    @Override
    public void delete(Integer id)
    {
        repository.deleteById(id);
    }

    @Override
    public Comment insert(CommentRequest commentRequest) throws NotFoundException
    {
        CommentEntity commentEntity=mapper.map(commentRequest,CommentEntity.class);
        commentEntity.setId(null);
        commentEntity=repository.saveAndFlush(commentEntity);
        entityManager.refresh(commentEntity);
        return findById(commentEntity.getId());

    }

    @Override
    public Comment update(Integer id, CommentRequest commentRequest) throws NotFoundException
    {
        CommentEntity commentEntity=mapper.map(commentRequest,CommentEntity.class);
        commentEntity.setId(id);
        commentEntity=repository.saveAndFlush(commentEntity);
        entityManager.refresh(commentEntity);
        return findById(commentEntity.getId());
    }
}
