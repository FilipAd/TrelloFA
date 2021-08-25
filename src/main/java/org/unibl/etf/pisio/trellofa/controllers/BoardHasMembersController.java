package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.trellofa.models.entities.BoardHasMembersEntity;
import org.unibl.etf.pisio.trellofa.repositories.BoardHasMembersEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/boardhasmembers")
public class BoardHasMembersController
{
    private final BoardHasMembersEntityRepository repository;

    public BoardHasMembersController(BoardHasMembersEntityRepository repository)
    {
        this.repository = repository;

    }
    @GetMapping
    List<BoardHasMembersEntity> findAll()
    {
        return repository.findAll();
    }
}
