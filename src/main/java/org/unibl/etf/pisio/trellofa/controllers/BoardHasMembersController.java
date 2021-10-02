package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.BoardHasMembers;
import org.unibl.etf.pisio.trellofa.models.entities.BoardHasMembersEntity;
import org.unibl.etf.pisio.trellofa.models.requests.BoardHasMembersRequest;
import org.unibl.etf.pisio.trellofa.services.BoardHasMembersService;

import java.util.List;

@RestController
@RequestMapping("/boardhasmembers")
public class BoardHasMembersController
{
 private final BoardHasMembersService service;

    public BoardHasMembersController(BoardHasMembersService service)
    {
        this.service = service;
    }

    @GetMapping
    List<BoardHasMembers> findAll()
    {
        return service.findAll();
    }
    @GetMapping("/{id}")
    BoardHasMembers findById(@PathVariable Integer id) throws NotFoundException
    {
        return  service.findById(id);
    }

   @GetMapping("/{idMember}/{idBoard}")
   List<BoardHasMembers> findByMemberAndBoard(@PathVariable Integer idMember,@PathVariable Integer idBoard) throws NotFoundException
   {
      return  service.findAllBoardHasMembersByBoardAndMember(idMember,idBoard);
   }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id)throws NotFoundException
    {
        service.delete(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BoardHasMembers insert(@RequestBody BoardHasMembersRequest boardHasMembersRequest)throws NotFoundException
    {
       return service.insert(boardHasMembersRequest);
    }

    @PutMapping("/{id}")
    public BoardHasMembers update(@PathVariable Integer id,@RequestBody BoardHasMembersRequest boardHasMembersRequest)throws NotFoundException
    {
        return service.update(id,boardHasMembersRequest);
    }
}
