package org.unibl.etf.pisio.trellofa.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Member;
import org.unibl.etf.pisio.trellofa.models.SingleMember;
import org.unibl.etf.pisio.trellofa.repositories.MemberEntityRepository;
import org.unibl.etf.pisio.trellofa.services.MemberService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService
{
    private final MemberEntityRepository repository;
    private final ModelMapper mapper;

    public MemberServiceImpl(MemberEntityRepository repository, ModelMapper mapper)
    {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Member> findAll()
    {
        return repository.findAll().stream().map(e->mapper.map(e,Member.class)).collect(Collectors.toList());
    }

    @Override
    public SingleMember findById(Integer id) throws NotFoundException
    {
        return mapper.map(repository.findById(id).orElseThrow(NotFoundException::new),SingleMember.class);
    }
}
