package org.unibl.etf.pisio.trellofa.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.MembersOnCards;
import org.unibl.etf.pisio.trellofa.models.entities.MembersOnCardsEntity;
import org.unibl.etf.pisio.trellofa.models.requests.MembersOnCardsRequest;
import org.unibl.etf.pisio.trellofa.repositories.MembersOnCardsEntityRepository;
import org.unibl.etf.pisio.trellofa.repositories.MembershiptypeEntityRepository;
import org.unibl.etf.pisio.trellofa.services.MembersOnCardsService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
public class MembersOnCardsServiceImpl implements MembersOnCardsService
{
    private final MembersOnCardsEntityRepository repository;
    private final ModelMapper mapper;
    @PersistenceContext
    private EntityManager entityManager;


    public MembersOnCardsServiceImpl(MembersOnCardsEntityRepository repository, ModelMapper mapper)
    {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<MembersOnCards> findAll()
    {
        return repository.findAll().stream().map(e->mapper.map(e,MembersOnCards.class)).collect(Collectors.toList());
    }

    @Override
    public List<MembersOnCards> getAllMembersOnCardsByMemberId(Integer id)
    {
        return repository.getAllByMember_Id(id).stream().map(e->mapper.map(e,MembersOnCards.class)).collect(Collectors.toList());
    }

    @Override
    public List<MembersOnCards> getAllMembersOnCardsByCardId(Integer id)
    {
        return repository.getAllByCard_Id(id).stream().map(e->mapper.map(e,MembersOnCards.class)).collect(Collectors.toList());
    }

    @Override
    public MembersOnCards findById(Integer id)throws NotFoundException
    {
        return mapper.map(repository.findById(id).orElseThrow(NotFoundException::new),MembersOnCards.class);
    }

    @Override
    public void delete(Integer id)throws NotFoundException
    {
        repository.deleteById(id);
    }

    @Override
    public MembersOnCards insert(MembersOnCardsRequest membersOnCardsRequest) throws NotFoundException
    {
        MembersOnCardsEntity membersOnCardsEntity=mapper.map(membersOnCardsRequest,MembersOnCardsEntity.class);
        membersOnCardsEntity.setId(null);
        membersOnCardsEntity=repository.saveAndFlush(membersOnCardsEntity);
        entityManager.refresh(membersOnCardsEntity);
        return findById(membersOnCardsEntity.getId());

    }

    @Override
    public MembersOnCards update(Integer id, MembersOnCardsRequest membersOnCardsRequest) throws NotFoundException
    {
        MembersOnCardsEntity membersOnCardsEntity=mapper.map(membersOnCardsRequest,MembersOnCardsEntity.class);
        membersOnCardsEntity.setId(id);
        membersOnCardsEntity=repository.saveAndFlush(membersOnCardsEntity);
        entityManager.refresh(membersOnCardsEntity);
        return findById(membersOnCardsEntity.getId());
    }
}
