package org.unibl.etf.pisio.trellofa.services;

import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Comment;

import java.util.List;

public interface CommentService
{
    List<Comment> findAll();
    Comment findById(Integer id) throws NotFoundException;
}
