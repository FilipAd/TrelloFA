package org.unibl.etf.pisio.trellofa.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.AppKeys;
import org.unibl.etf.pisio.trellofa.models.Attachment;
import org.unibl.etf.pisio.trellofa.models.entities.AppKeysEntity;
import org.unibl.etf.pisio.trellofa.models.entities.AttachmentEntity;
import org.unibl.etf.pisio.trellofa.models.requests.AppKeysRequest;
import org.unibl.etf.pisio.trellofa.models.requests.AttachmentRequest;
import org.unibl.etf.pisio.trellofa.repositories.AppKeysEntityRepository;
import org.unibl.etf.pisio.trellofa.repositories.AttachmentEntityRepository;
import org.unibl.etf.pisio.trellofa.services.AppKeysService;
import org.unibl.etf.pisio.trellofa.services.AttachmentService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AppKeysServiceImpl implements AppKeysService
{

    private final AppKeysEntityRepository repository;
    private final ModelMapper mapper;
    @PersistenceContext
    private EntityManager entityManager;

    public AppKeysServiceImpl(AppKeysEntityRepository repository, ModelMapper mapper)
    {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<AppKeys> findAll()
    {
        return repository.findAll().stream().map(e->mapper.map(e,AppKeys.class)).collect(Collectors.toList());
    }

    @Override
    public AppKeys findByKeys(String key) throws NotFoundException {
        return mapper.map(repository.findById(key).orElseThrow(NotFoundException::new),AppKeys.class);
    }

    @Override
    public void deleteByKey(String key) throws NotFoundException {
        repository.deleteByKey(key);
    }

    @Override
    public void delete(String key)throws NotFoundException
    {
        repository.deleteById(key);
    }

    @Override
    public AppKeys insert(AppKeysRequest appKeysRequest) throws NotFoundException
    {
        AppKeysEntity appKeysEntity=mapper.map(appKeysRequest,AppKeysEntity.class);
        appKeysEntity.setKey(appKeysEntity.getKey());
        appKeysEntity=repository.saveAndFlush(appKeysEntity);
        entityManager.refresh(appKeysEntity);
        return findByKeys(appKeysEntity.getKey());
    }

    @Override
    public AppKeys update(String key, AppKeysRequest appKeysRequest) throws NotFoundException
    {
        AppKeysEntity appKeysEntity=mapper.map(appKeysRequest,AppKeysEntity.class);
       // appKeysEntity.setKey(key);
        appKeysEntity=repository.saveAndFlush(appKeysEntity);
        entityManager.refresh(appKeysEntity);
        return findByKeys(appKeysEntity.getKey());
    }
}
