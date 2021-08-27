package org.unibl.etf.pisio.trellofa.services;

import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Card;
import org.unibl.etf.pisio.trellofa.models.SingleCard;

import java.util.List;

public interface CardService
{
    List<Card> findAll();
    SingleCard findById(Integer id) throws NotFoundException;

}
