package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Comment;
import org.unibl.etf.pisio.trellofa.models.entities.CommentEntity;
import org.unibl.etf.pisio.trellofa.services.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController
{
    private final CommentService commentService;

    public CommentController(CommentService commentService)
    {
        this.commentService = commentService;
    }

    @GetMapping
    List<Comment> findAll()
    {
        return commentService.findAll();
    }
    @GetMapping("/{id}")
    Comment findById(@PathVariable Integer id) throws NotFoundException
    {
        return commentService.findById(id);
    }
}
