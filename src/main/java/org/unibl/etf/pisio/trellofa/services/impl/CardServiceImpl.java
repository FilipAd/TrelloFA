package org.unibl.etf.pisio.trellofa.services.impl;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Card;
import org.unibl.etf.pisio.trellofa.models.SingleCard;
import org.unibl.etf.pisio.trellofa.repositories.CardEntityRepository;
import org.unibl.etf.pisio.trellofa.services.CardService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService
{

    private final CardEntityRepository repository;
    private final ModelMapper mapper;

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
    public SingleCard findById(Integer id) throws NotFoundException {
        return mapper.map(repository.findById(id).orElseThrow(NotFoundException::new),SingleCard.class);
    }
}
