package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Board;
import org.unibl.etf.pisio.trellofa.models.SingleBoard;
import org.unibl.etf.pisio.trellofa.models.entities.BoardEntity;
import org.unibl.etf.pisio.trellofa.models.requests.BoardRequest;
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
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id)
    {
        boardService.delete(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Board insert(@RequestBody BoardRequest boardRequest) throws NotFoundException
    {
        return boardService.insert(boardRequest);
    }
    @PutMapping("/{id}")
    public Board update(@PathVariable Integer id,@RequestBody BoardRequest boardRequest) throws NotFoundException
    {
        return boardService.update(id,boardRequest);
    }


}
