package org.unibl.etf.pisio.trellofa.services.impl;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.ConflictException;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Member;
import org.unibl.etf.pisio.trellofa.models.MemberBasic;
import org.unibl.etf.pisio.trellofa.models.SingleMember;
import org.unibl.etf.pisio.trellofa.models.entities.MemberEntity;
import org.unibl.etf.pisio.trellofa.models.enums.Role;
import org.unibl.etf.pisio.trellofa.models.enums.Status;
import org.unibl.etf.pisio.trellofa.models.requests.MemberRequest;
import org.unibl.etf.pisio.trellofa.models.requests.SignUpRequest;
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
    private final PasswordEncoder passwordEncoder;
    private final JmsTemplate jmsTemplate;

    @PersistenceContext
    private EntityManager entityManager;
    @Value("${mq.topic}")
    private String topicName;
    @Value("${authorization.default.username:}")
    private String defaultUsername;
    @Value("${authorization.default.fullname:}")
    private String defaultFullname;
    @Value("${authorization.default.email:}")
    private String defaultEmail;
    @Value("${authorization.default.password:}")
    private String defaultPassword;
    @Value("${mq.queue}")
    private String queueName;




    public MemberServiceImpl(MemberEntityRepository repository, ModelMapper mapper, PasswordEncoder passwordEncoder, JmsTemplate jmsTemplate)
    {
        this.repository = repository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
        this.jmsTemplate = jmsTemplate;
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
    public Member findByIdMember(Integer id) throws NotFoundException {
        return mapper.map(repository.findById(id).orElseThrow(NotFoundException::new),Member.class);
    }

    @Override
    public List<MemberBasic> findByMemberUsername(String un) throws NotFoundException {
        return repository.getAllByUsernameContains(un).stream().map(e->mapper.map(e,MemberBasic.class)).collect(Collectors.toList());
    }

    @Override
    public void singUp(MemberRequest request)
    {
        if (repository.existsByUsername(request.getUsername()))
            throw new ConflictException();
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        request.setStatus(Status.ACTIVE);
        request.setRole(Role.USER);
        Member member=null;
        try
        { member=insert(request);}
        catch (NotFoundException ex)
        {
            ex.printStackTrace();
        }
      //  jmsTemplate.convertAndSend(new ActiveMQQueue(queueName),member);
       // jmsTemplate.convertAndSend(new ActiveMQTopic(topicName),member);
    }


    @Override
    public void delete(Integer id)throws NotFoundException
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
