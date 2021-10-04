package org.unibl.etf.pisio.trellofa.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Label;
import org.unibl.etf.pisio.trellofa.models.entities.LabelEntity;
import org.unibl.etf.pisio.trellofa.models.requests.LabelRequest;
import org.unibl.etf.pisio.trellofa.repositories.LabelEntityRepository;
import org.unibl.etf.pisio.trellofa.services.LabelService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LabelServiceImpl implements LabelService
{
    private final LabelEntityRepository repository;
    private final ModelMapper mapper;
    @PersistenceContext
    private EntityManager entityManager;

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

    @Override
    public void delete(Integer id) throws NotFoundException
    {
        repository.deleteById(id);
    }

    @Override
    public Label insert(LabelRequest labelRequest) throws NotFoundException
    {
        LabelEntity labelEntity=mapper.map(labelRequest,LabelEntity.class);
        labelEntity.setId(null);
        labelEntity=repository.saveAndFlush(labelEntity);
        entityManager.refresh(labelEntity);
        return findById(labelEntity.getId());

    }

    @Override
    public Label update(Integer id,LabelRequest labelRequest) throws NotFoundException
    {
        LabelEntity labelEntity=mapper.map(labelRequest,LabelEntity.class);
        labelEntity.setId(id);
        labelEntity=repository.saveAndFlush(labelEntity);
        entityManager.refresh(labelEntity);
        return findById(labelEntity.getId());
    }

  /*  @Override
    public List<Label> getAllLabelsByCardId(Integer id)
    {
        return repository.getAllByCard_Id(id).stream().map(e->mapper.map(e,Label.class)).collect(Collectors.toList());
    }*/
}
