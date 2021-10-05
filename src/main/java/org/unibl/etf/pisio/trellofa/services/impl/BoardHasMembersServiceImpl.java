package org.unibl.etf.pisio.trellofa.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.BoardHasMembers;
import org.unibl.etf.pisio.trellofa.models.entities.BoardHasMembersEntity;
import org.unibl.etf.pisio.trellofa.models.requests.BoardHasMembersRequest;
import org.unibl.etf.pisio.trellofa.repositories.BoardHasMembersEntityRepository;
import org.unibl.etf.pisio.trellofa.services.BoardHasMembersService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class BoardHasMembersServiceImpl implements BoardHasMembersService
{
    private final BoardHasMembersEntityRepository repository;
    private final ModelMapper mapper;
    @PersistenceContext
    private EntityManager entityManager;

    public BoardHasMembersServiceImpl(BoardHasMembersEntityRepository repository, ModelMapper mapper)
    {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public List<BoardHasMembers> findAll()
    {
        return repository.findAll().stream().map(e->mapper.map(e,BoardHasMembers.class)).collect(Collectors.toList());
    }

    @Override
    public List<BoardHasMembers> findAllBoardHasMembersByMemberId(Integer id)
    {
        return repository.getAllByMember_Id(id).stream().map(e->mapper.map(e,BoardHasMembers.class)).collect(Collectors.toList());
    }

    @Override
    public List<BoardHasMembers> findAllBoardHasMembersByBoardId(Integer id)
    {
        return repository.getAllByBoard_Id(id).stream().map(e->mapper.map(e,BoardHasMembers.class)).collect(Collectors.toList());
    }

    @Override
    public List<BoardHasMembers> findAllBoardHasMembersByBoardAndMember(Integer idMember, Integer idBoard)
    {
        return repository.getAllByMember_IdAndBoard_Id(idMember,idBoard).stream().map(e->mapper.map(e,BoardHasMembers.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteAllBoardHasMembersByMemberIdAndBoardId(Integer idMember, Integer idBoard) throws NotFoundException
    {
        repository.deleteAllByMember_IdAndBoard_Id(idMember,idBoard);
    }

    @Override
    public BoardHasMembers findById(Integer id) throws NotFoundException
    {
        return mapper.map(repository.findById(id).orElseThrow(NotFoundException::new),BoardHasMembers.class);
    }

    @Override
    public void delete(Integer id)throws NotFoundException
    {
        repository.deleteById(id);
    }

    @Override
    public BoardHasMembers insert(BoardHasMembersRequest boardHasMembersRequest)throws NotFoundException
    {
        BoardHasMembersEntity boardHasMembersEntit=mapper.map(boardHasMembersRequest,BoardHasMembersEntity.class);
        boardHasMembersEntit.setId(null);
        boardHasMembersEntit=repository.saveAndFlush(boardHasMembersEntit);
        entityManager.refresh(boardHasMembersEntit);
        return findById(boardHasMembersEntit.getId());

    }

    @Override
    public BoardHasMembers update(Integer id, BoardHasMembersRequest boardHasMembersRequest) throws NotFoundException
    {
        BoardHasMembersEntity boardHasMembersEntit=mapper.map(boardHasMembersRequest,BoardHasMembersEntity.class);
        boardHasMembersEntit.setId(id);
        boardHasMembersEntit=repository.saveAndFlush(boardHasMembersEntit);
        entityManager.refresh(boardHasMembersEntit);
        return findById(boardHasMembersEntit.getId());
    }
}
