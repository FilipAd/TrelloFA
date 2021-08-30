package org.unibl.etf.pisio.trellofa.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Member;
import org.unibl.etf.pisio.trellofa.models.Membership;
import org.unibl.etf.pisio.trellofa.models.SingleMember;
import org.unibl.etf.pisio.trellofa.models.entities.MembershipEntity;
import org.unibl.etf.pisio.trellofa.models.requests.MembershipRequest;
import org.unibl.etf.pisio.trellofa.repositories.MembershipEntityRepository;
import org.unibl.etf.pisio.trellofa.services.MembershipService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MembershipServiceImpl implements MembershipService
{

    private final MembershipEntityRepository repository;
    private final ModelMapper mapper;
    @PersistenceContext
    private EntityManager  entityManager;

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

    @Override
    public List<Membership> getAllMembershipsByOrganizationId(Integer id)
    {
        return repository.getAllByOrganization_Id(id).stream().map(e->mapper.map(e,Membership.class)).collect(Collectors.toList());
    }

    @Override
    public List<Membership> getAllMembershipsByMembershiptypeId(Integer id)
    {
        return repository.getAllByMembershiptype_Id(id).stream().map(e->mapper.map(e,Membership.class)).collect(Collectors.toList());
    }

    @Override
    public List<Membership> getAllMembershipsByMemberId(Integer id)
    {
        return repository.getAllByMember_Id(id).stream().map(e->mapper.map(e,Membership.class)).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id)
    {
        repository.deleteById(id);
    }

    @Override
    public Membership insert(MembershipRequest membershipRequest) throws NotFoundException
    {
        MembershipEntity membershipEntity=mapper.map(membershipRequest,MembershipEntity.class);
        membershipEntity.setId(null);
        membershipEntity=repository.saveAndFlush(membershipEntity);
        entityManager.refresh(membershipEntity);
        return findById(membershipEntity.getId());
    }

    @Override
    public Membership update(Integer id, MembershipRequest membershipRequest) throws NotFoundException
    {
        MembershipEntity membershipEntity=mapper.map(membershipRequest,MembershipEntity.class);
        membershipEntity.setId(id);
        membershipEntity=repository.saveAndFlush(membershipEntity);
        entityManager.refresh(membershipEntity);
        return findById(membershipEntity.getId());
    }


}
