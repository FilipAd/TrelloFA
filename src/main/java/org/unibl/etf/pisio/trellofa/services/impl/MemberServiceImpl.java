package org.unibl.etf.pisio.trellofa.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Member;
import org.unibl.etf.pisio.trellofa.models.SingleMember;
import org.unibl.etf.pisio.trellofa.models.entities.MemberEntity;
import org.unibl.etf.pisio.trellofa.models.requests.MemberRequest;
import org.unibl.etf.pisio.trellofa.repositories.MemberEntityRepository;
import org.unibl.etf.pisio.trellofa.services.MemberService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MemberServiceImpl implements MemberService
{
    private final MemberEntityRepository repository;
    private final ModelMapper mapper;
    @PersistenceContext
    private EntityManager entityManager;

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

    @Override
    public void delete(Integer id)
    {
        repository.deleteById(id);
    }

    @Override
    public Member insert(MemberRequest memberRequest) throws NotFoundException
    {
        MemberEntity memberEntity=mapper.map(memberRequest,MemberEntity.class);
        memberEntity.setId(null);
        memberEntity=repository.saveAndFlush(memberEntity);
        entityManager.refresh(memberEntity);
        return findById(memberEntity.getId());
    }

    @Override
    public Member update(Integer id, MemberRequest memberRequest) throws NotFoundException
    {
        MemberEntity memberEntity=mapper.map(memberRequest,MemberEntity.class);
        memberEntity.setId(id);
        memberEntity=repository.saveAndFlush(memberEntity);
        entityManager.refresh(memberEntity);
        return findById(memberEntity.getId());
    }
}
