package org.unibl.etf.pisio.trellofa.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.BoardHasMembers;
import org.unibl.etf.pisio.trellofa.repositories.BoardHasMembersEntityRepository;
import org.unibl.etf.pisio.trellofa.services.BoardHasMembersService;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BoardHasMembersServiceImpl implements BoardHasMembersService
{
    private final BoardHasMembersEntityRepository repository;
    private final ModelMapper mapper;

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
    public BoardHasMembers findById(Integer id) throws NotFoundException
    {
        return mapper.map(repository.findById(id).orElseThrow(NotFoundException::new),BoardHasMembers.class);
    }
}
