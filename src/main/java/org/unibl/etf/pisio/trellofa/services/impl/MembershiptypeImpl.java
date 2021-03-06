package org.unibl.etf.pisio.trellofa.services.impl;

import org.modelmapper.ModelMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Membershiptype;
import org.unibl.etf.pisio.trellofa.models.SingleMembershiptype;
import org.unibl.etf.pisio.trellofa.models.entities.MembershiptypeEntity;
import org.unibl.etf.pisio.trellofa.models.requests.MembershiptypeRequest;
import org.unibl.etf.pisio.trellofa.repositories.MembershiptypeEntityRepository;
import org.unibl.etf.pisio.trellofa.services.MembershiptypeService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@Transactional
public class MembershiptypeImpl implements MembershiptypeService
{
    private final MembershiptypeEntityRepository repository;
    private final ModelMapper mapper;
    @PersistenceContext
    private EntityManager entityManager;

    public MembershiptypeImpl(MembershiptypeEntityRepository repository, ModelMapper mapper)
    {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<Membershiptype> findAll()
    {
        return repository.findAll().stream().map(e->mapper.map(e,Membershiptype.class)).collect(Collectors.toList());
    }

    @Override
    public SingleMembershiptype findById(Integer id) throws NotFoundException {
        return mapper.map(repository.findById(id).orElseThrow(NotFoundException ::new),SingleMembershiptype.class);
    }

    @Override
    public void delete(Integer id)
    {
        repository.deleteById(id);
    }

    @Override
    public Membershiptype insert(MembershiptypeRequest membershiptypeRequest) throws NotFoundException
    {
        MembershiptypeEntity membershiptypeEntity=mapper.map(membershiptypeRequest,MembershiptypeEntity.class);
        membershiptypeEntity.setId(null);
        membershiptypeEntity=repository.saveAndFlush(membershiptypeEntity);
        entityManager.refresh(membershiptypeEntity);
        return findById(membershiptypeEntity.getId());
    }

    @Override
    public Membershiptype update(Integer id, MembershiptypeRequest membershiptypeRequest) throws NotFoundException
    {
        MembershiptypeEntity membershiptypeEntity=mapper.map(membershiptypeRequest,MembershiptypeEntity.class);
        membershiptypeEntity.setId(id);
        membershiptypeEntity=repository.saveAndFlush(membershiptypeEntity);
        entityManager.refresh(membershiptypeEntity);
        return findById(membershiptypeEntity.getId());
    }
}
