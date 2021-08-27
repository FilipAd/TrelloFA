package org.unibl.etf.pisio.trellofa.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Member;
import org.unibl.etf.pisio.trellofa.models.Membership;
import org.unibl.etf.pisio.trellofa.models.SingleMember;
import org.unibl.etf.pisio.trellofa.repositories.MembershipEntityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MembershipServiceImpl implements MembershipService
{

    private final MembershipEntityRepository repository;
    private final ModelMapper mapper;

    public MembershipServiceImpl(MembershipEntityRepository repository, ModelMapper mapper)
    {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Membership> findAll() {
        return repository.findAll().stream().map(e->mapper.map(e,Membership.class)).collect(Collectors.toList());
    }

    @Override
    public Membership findById(Integer id) throws NotFoundException {
        return mapper.map(repository.findById(id).orElseThrow(NotFoundException::new),Membership.class);
    }


}
