package org.unibl.etf.pisio.trellofa.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.List;
import org.unibl.etf.pisio.trellofa.models.SingleList;
import org.unibl.etf.pisio.trellofa.repositories.ListEntityRepository;
import org.unibl.etf.pisio.trellofa.services.ListService;

import java.util.stream.Collectors;

@Service
public class ListServiceImpl implements ListService
{
    private final ListEntityRepository repository;
    private final ModelMapper mapper;


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
}
