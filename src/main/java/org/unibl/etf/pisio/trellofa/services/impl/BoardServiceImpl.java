package org.unibl.etf.pisio.trellofa.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Board;
import org.unibl.etf.pisio.trellofa.models.SingleBoard;
import org.unibl.etf.pisio.trellofa.repositories.BoardEntityRepository;
import org.unibl.etf.pisio.trellofa.services.BoardService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService
{
    private final ModelMapper mapper;
    private final BoardEntityRepository repository;

    public BoardServiceImpl(ModelMapper mapper, BoardEntityRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<Board> findAll()
    {
        return repository.findAll().stream().map(e->mapper.map(e,Board.class)).collect(Collectors.toList());
    }

    @Override
    public SingleBoard findById(Integer id) throws NotFoundException
    {
        return mapper.map(repository.findById(id).orElseThrow(NotFoundException::new),SingleBoard.class);
    }
}
