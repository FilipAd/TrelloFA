package org.unibl.etf.pisio.trellofa.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Board;
import org.unibl.etf.pisio.trellofa.models.SingleBoard;
import org.unibl.etf.pisio.trellofa.models.entities.BoardEntity;
import org.unibl.etf.pisio.trellofa.models.requests.BoardRequest;
import org.unibl.etf.pisio.trellofa.repositories.BoardEntityRepository;
import org.unibl.etf.pisio.trellofa.services.BoardService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BoardServiceImpl implements BoardService
{
    private final ModelMapper mapper;
    private final BoardEntityRepository repository;
    @PersistenceContext
    private EntityManager entityManager;

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

    @Override
    public List<Board> getAllBoardsByOrganizationId(Integer id)
    {
        return repository.getAllByOrganization_Id(id).stream().map(e->mapper.map(e,Board.class)).collect(Collectors.toList());
    }

    @Override
    public List<Board> getBoardsByMemberId(Integer id) {
        return repository.getBoardsByMemberId(id).stream().map(e->mapper.map(e,Board.class)).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id)throws NotFoundException
    {
        repository.deleteById(id);
    }

    @Override
    public Board insert(BoardRequest boardRequest) throws NotFoundException
    {
        BoardEntity boardEntity=mapper.map(boardRequest,BoardEntity.class);
        boardEntity.setId(null);
        boardEntity=repository.saveAndFlush(boardEntity);
        entityManager.refresh(boardEntity);
        return findById(boardEntity.getId());
    }

    @Override
    public Board update(Integer id, BoardRequest boardRequest) throws NotFoundException
    {
        BoardEntity boardEntity=mapper.map(boardRequest,BoardEntity.class);
        boardEntity.setId(id);
        boardEntity=repository.saveAndFlush(boardEntity);
        entityManager.refresh(boardEntity);
        return findById(boardEntity.getId());
    }
}
