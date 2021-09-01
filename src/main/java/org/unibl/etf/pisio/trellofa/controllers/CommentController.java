package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Comment;
import org.unibl.etf.pisio.trellofa.models.entities.CommentEntity;
import org.unibl.etf.pisio.trellofa.models.requests.CommentRequest;
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
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id)throws NotFoundException
    {
        commentService.delete(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Comment insert(@RequestBody CommentRequest commentRequest)throws NotFoundException
    {
        return commentService.insert(commentRequest);
    }
    @PutMapping("/{id}")
    Comment update(@PathVariable Integer id,@RequestBody CommentRequest commentRequest)throws NotFoundException
    {
        return commentService.update(id,commentRequest);
    }
}
