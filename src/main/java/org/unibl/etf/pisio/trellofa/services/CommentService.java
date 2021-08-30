package org.unibl.etf.pisio.trellofa.services;

import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Comment;
import org.unibl.etf.pisio.trellofa.models.requests.CommentRequest;

import java.util.List;

public interface CommentService
{
    List<Comment> findAll();
    Comment findById(Integer id) throws NotFoundException;
    void delete(Integer id);
    Comment insert(CommentRequest commentRequest)throws NotFoundException;
    Comment update(Integer id,CommentRequest commentRequest) throws NotFoundException;
    List<Comment> getAllCommentsByMemberId(Integer id);
    List<Comment> getAllCommentsByCardId(Integer id);
}
