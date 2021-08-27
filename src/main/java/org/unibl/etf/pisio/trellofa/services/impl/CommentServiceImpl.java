package org.unibl.etf.pisio.trellofa.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Comment;
import org.unibl.etf.pisio.trellofa.repositories.CommentEntityRepository;
import org.unibl.etf.pisio.trellofa.services.CommentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService
{
    private final CommentEntityRepository repository;
    private final ModelMapper mapper;

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
}
