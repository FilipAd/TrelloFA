package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Board;
import org.unibl.etf.pisio.trellofa.models.SingleBoard;
import org.unibl.etf.pisio.trellofa.models.entities.BoardEntity;
import org.unibl.etf.pisio.trellofa.services.BoardService;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController
{
    @Autowired
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    @GetMapping
    List<Board> findAll()
    {
        return boardService.findAll();
    }
    @GetMapping("/{id}")
    SingleBoard findById(@PathVariable Integer id) throws NotFoundException
    {
          return boardService.findById(id);
    }


}
