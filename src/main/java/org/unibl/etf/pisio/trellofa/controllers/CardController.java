package org.unibl.etf.pisio.trellofa.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Card;
import org.unibl.etf.pisio.trellofa.models.Comment;
import org.unibl.etf.pisio.trellofa.models.Label;
import org.unibl.etf.pisio.trellofa.models.SingleCard;
import org.unibl.etf.pisio.trellofa.models.requests.CardRequest;
import org.unibl.etf.pisio.trellofa.services.CardService;
import org.unibl.etf.pisio.trellofa.services.CommentService;
import org.unibl.etf.pisio.trellofa.services.LabelService;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController
{
private final CardService cardService;
private final CommentService commentService;
private final LabelService labelService;

    public CardController(CardService cardService, CommentService commentService, LabelService labelService)
    {
        this.cardService = cardService;
        this.commentService = commentService;
        this.labelService = labelService;
    }



    @GetMapping
    List<Card> findAll()
    {
        return cardService.findAll();
    }
    @GetMapping("/{id}")
    SingleCard findById(@PathVariable Integer id) throws NotFoundException
    {
        return cardService.findById(id);
    }
    @GetMapping("/{id}/comments")
    public List<Comment> findAllCommentsByCardId(@PathVariable Integer id)
    {
        return commentService.getAllCommentsByCardId(id);
    }
    @GetMapping("/{id}/labels")
    public List<Label> findAllLabelsByCardId(@PathVariable Integer id)
    {
        return labelService.getAllLabelsByCardId(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id)
    {
        cardService.delete(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Card insert(@RequestBody CardRequest cardRequest)throws NotFoundException
    {
        return cardService.insert(cardRequest);
    }
    @PutMapping("/{id}")
    public Card update(@PathVariable Integer id,@RequestBody CardRequest cardRequest)throws NotFoundException
    {
        return cardService.update(id,cardRequest);
    }

}
