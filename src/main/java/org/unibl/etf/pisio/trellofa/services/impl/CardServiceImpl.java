package org.unibl.etf.pisio.trellofa.services.impl;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Card;
import org.unibl.etf.pisio.trellofa.models.Label;
import org.unibl.etf.pisio.trellofa.models.SingleCard;
import org.unibl.etf.pisio.trellofa.models.entities.CardEntity;
import org.unibl.etf.pisio.trellofa.models.requests.CardRequest;
import org.unibl.etf.pisio.trellofa.repositories.CardEntityRepository;
import org.unibl.etf.pisio.trellofa.services.CardService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CardServiceImpl implements CardService
{

    private final CardEntityRepository repository;
    private final ModelMapper mapper;
    @PersistenceContext
    private EntityManager entityManager;

    public CardServiceImpl(CardEntityRepository repository,ModelMapper mapper)
    {
        this.repository=repository;
        this.mapper=mapper;
    }


    @Override
    public List<Card> findAll()
    {
        return repository.findAll().stream().map(e->mapper.map(e,Card.class)).collect(Collectors.toList());
    }

    @Override
    public List<Card> getAllCardsByListId(Integer id)
    {
        return repository.getAllByList_Id(id).stream().map(e->mapper.map(e,Card.class)).collect(Collectors.toList());
    }

    @Override
    public List<Label> getAllLabelsByCardId(Integer idCard) {
        return repository.getAllLabelsByCardId(idCard).stream().map(e->mapper.map(e,Label.class)).collect(Collectors.toList());
    }

    @Override
    public SingleCard findById(Integer id) throws NotFoundException {
        return mapper.map(repository.findById(id).orElseThrow(NotFoundException::new),SingleCard.class);
    }

    @Override
    public void delete(Integer id)throws NotFoundException
    {
        repository.deleteById(id);
    }

    @Override
    public Card insert(CardRequest cardRequest) throws NotFoundException
    {
        CardEntity cardEntity=mapper.map(cardRequest,CardEntity.class);
        cardEntity.setId(null);
        cardEntity=repository.saveAndFlush(cardEntity);
        entityManager.refresh(cardEntity);
        return findById(cardEntity.getId());

    }

    @Override
    public Card update(Integer id, CardRequest cardRequest) throws NotFoundException
    {
        CardEntity cardEntity=mapper.map(cardRequest,CardEntity.class);
        cardEntity.setId(id);
        cardEntity=repository.saveAndFlush(cardEntity);
        entityManager.refresh(cardEntity);
        return findById(cardEntity.getId());
    }
}
