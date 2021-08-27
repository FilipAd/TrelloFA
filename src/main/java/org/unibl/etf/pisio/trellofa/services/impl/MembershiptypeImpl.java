package org.unibl.etf.pisio.trellofa.services.impl;

import org.modelmapper.ModelMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Membershiptype;
import org.unibl.etf.pisio.trellofa.models.SingleMembershiptype;
import org.unibl.etf.pisio.trellofa.repositories.MembershiptypeEntityRepository;
import org.unibl.etf.pisio.trellofa.services.MembershiptypeService;

import java.util.stream.Collectors;

@Service
public class MembershiptypeImpl implements MembershiptypeService
{
    private final MembershiptypeEntityRepository repository;
    private final ModelMapper mapper;

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
}
