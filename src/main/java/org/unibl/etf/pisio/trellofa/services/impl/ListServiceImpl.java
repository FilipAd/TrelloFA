package org.unibl.etf.pisio.trellofa.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.List;
import org.unibl.etf.pisio.trellofa.models.SingleList;
import org.unibl.etf.pisio.trellofa.models.entities.ListEntity;
import org.unibl.etf.pisio.trellofa.models.entities.OrganizationEntity;
import org.unibl.etf.pisio.trellofa.models.requests.ListRequest;
import org.unibl.etf.pisio.trellofa.repositories.ListEntityRepository;
import org.unibl.etf.pisio.trellofa.services.ListService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ListServiceImpl implements ListService
{
    private final ListEntityRepository repository;
    private final ModelMapper mapper;
    @PersistenceContext
    private EntityManager entityManager;


    public ListServiceImpl(ListEntityRepository repository, ModelMapper mapper)
    {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public java.util.List<List> findAll()
    {
        return repository.findAll().stream().map(e->mapper.map(e,List.class)).collect(Collectors.toList());
    }

    @Override
    public SingleList findById(Integer id) throws NotFoundException
    {
        return mapper.map(repository.findById(id).orElseThrow(NotFoundException::new),SingleList.class);
    }

    @Override
    public java.util.List<List> getAllListsByBoardId(Integer id)
    {
        return repository.findAllByBoard_Id(id).stream().map(e->mapper.map(e,List.class)).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id)
    {
     repository.deleteById(id);
    }

    @Override
    public List insert(ListRequest listRequest) throws NotFoundException
    {
        ListEntity listEntity=mapper.map(listRequest,ListEntity.class);
        listEntity.setId(null);
        listEntity=repository.saveAndFlush(listEntity);
        entityManager.refresh(listEntity);
        return findById(listEntity.getId());
    }

    @Override
    public List update(Integer id, ListRequest listRequest) throws NotFoundException {
        ListEntity listEntity=mapper.map(listRequest,ListEntity.class);
        listEntity.setId(id);
        listEntity=repository.saveAndFlush(listEntity);
        entityManager.refresh(listEntity);
        return findById(listEntity.getId());
    }
}
