package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Board;
import org.unibl.etf.pisio.trellofa.models.BoardHasMembers;
import org.unibl.etf.pisio.trellofa.models.SingleBoard;
import org.unibl.etf.pisio.trellofa.models.requests.BoardRequest;
import org.unibl.etf.pisio.trellofa.services.BoardHasMembersService;
import org.unibl.etf.pisio.trellofa.services.BoardService;
import org.unibl.etf.pisio.trellofa.services.ListService;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController
{
    @Autowired
    private final BoardService boardService;
    private final BoardHasMembersService boardHasMembersService;
    private final ListService listService;

    public BoardController(BoardService boardService, BoardHasMembersService boardHasMembersService, ListService listService)
    {
        this.boardService = boardService;
        this.boardHasMembersService = boardHasMembersService;
        this.listService = listService;
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
    @GetMapping("/{id}/lists")
    public List<org.unibl.etf.pisio.trellofa.models.List> findAllListsByBoardId(@PathVariable Integer id)
    {
        return listService.getAllListsByBoardId(id);
    }
    @GetMapping("/{id}/boardhasmembers")
    public List<BoardHasMembers> findAllBoardHasMembersByBoardId(@PathVariable Integer id)
    {
        return boardHasMembersService.findAllBoardHasMembersByBoardId(id);
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
