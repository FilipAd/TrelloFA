package org.unibl.etf.pisio.trellofa.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.BoardHasMembers;
import org.unibl.etf.pisio.trellofa.models.Invitation;
import org.unibl.etf.pisio.trellofa.models.entities.BoardHasMembersEntity;
import org.unibl.etf.pisio.trellofa.models.entities.InvitationEntity;
import org.unibl.etf.pisio.trellofa.models.requests.BoardHasMembersRequest;
import org.unibl.etf.pisio.trellofa.models.requests.InvitationRequest;
import org.unibl.etf.pisio.trellofa.repositories.BoardHasMembersEntityRepository;
import org.unibl.etf.pisio.trellofa.repositories.InvitationEntityRepository;
import org.unibl.etf.pisio.trellofa.services.BoardHasMembersService;
import org.unibl.etf.pisio.trellofa.services.InvitationService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class InvitationServiceImpl implements InvitationService
{
    private final InvitationEntityRepository repository;
    private final ModelMapper mapper;
    @PersistenceContext
    private EntityManager entityManager;

    public InvitationServiceImpl(InvitationEntityRepository repository, ModelMapper mapper)
    {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public List<Invitation> findAll()
    {
        return repository.findAll().stream().map(e->mapper.map(e,Invitation.class)).collect(Collectors.toList());
    }

    @Override
    public List<Invitation> findAllInvitationByMemberId(Integer id)
    {
        return repository.getAllByMember_Id(id).stream().map(e->mapper.map(e,Invitation.class)).collect(Collectors.toList());
    }

    @Override
    public List<Invitation> findAllInvitationByBoardId(Integer id)
    {
        return repository.getAllByBoard_Id(id).stream().map(e->mapper.map(e,Invitation.class)).collect(Collectors.toList());
    }

    @Override
    public Invitation findById(Integer id) throws NotFoundException
    {
        return mapper.map(repository.findById(id).orElseThrow(NotFoundException::new),Invitation.class);
    }

    @Override
    public void delete(Integer id)throws NotFoundException
    {
        repository.deleteById(id);
    }

    @Override
    public Invitation insert(InvitationRequest invitationRequest)throws NotFoundException
    {
        InvitationEntity invitationEntity=mapper.map(invitationRequest,InvitationEntity.class);
        invitationEntity.setId(null);
        invitationEntity=repository.saveAndFlush(invitationEntity);
        entityManager.refresh(invitationEntity);
        return findById(invitationEntity.getId());

    }

    @Override
    public Invitation update(Integer id, InvitationRequest invitationRequest) throws NotFoundException
    {
        InvitationEntity invitationEntity=mapper.map(invitationRequest,InvitationEntity.class);
        invitationEntity.setId(id);
        invitationEntity=repository.saveAndFlush(invitationEntity);
        entityManager.refresh(invitationEntity);
        return findById(invitationEntity.getId());
    }
}
