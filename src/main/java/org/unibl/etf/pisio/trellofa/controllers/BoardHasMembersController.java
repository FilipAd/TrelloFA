package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.BoardHasMembers;
import org.unibl.etf.pisio.trellofa.models.entities.BoardHasMembersEntity;
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
}
