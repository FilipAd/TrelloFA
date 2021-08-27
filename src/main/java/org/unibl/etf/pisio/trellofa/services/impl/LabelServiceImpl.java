package org.unibl.etf.pisio.trellofa.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Label;
import org.unibl.etf.pisio.trellofa.repositories.LabelEntityRepository;
import org.unibl.etf.pisio.trellofa.services.LabelService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabelServiceImpl implements LabelService
{
    private final LabelEntityRepository repository;
    private final ModelMapper mapper;

    public LabelServiceImpl(LabelEntityRepository repository, ModelMapper mapper)
    {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Label> findAll() {
        return repository.findAll().stream().map(e->mapper.map(e,Label.class)).collect(Collectors.toList());
    }

    @Override
    public Label findById(Integer id) throws NotFoundException {
        return mapper.map(repository.findById(id).orElseThrow(NotFoundException::new),Label.class);
    }
}
