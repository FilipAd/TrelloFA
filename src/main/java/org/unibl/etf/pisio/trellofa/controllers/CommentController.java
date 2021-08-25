package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.trellofa.models.entities.CommentEntity;
import org.unibl.etf.pisio.trellofa.repositories.CommentEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController
{
    private final CommentEntityRepository repository;

    public CommentController(CommentEntityRepository repository)
    {
        this.repository = repository;
    }
    @GetMapping
    List<CommentEntity> findAll()
    {
        return repository.findAll();
    }
}
