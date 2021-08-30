package org.unibl.etf.pisio.trellofa.services;

import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Card;
import org.unibl.etf.pisio.trellofa.models.SingleCard;
import org.unibl.etf.pisio.trellofa.models.requests.CardRequest;

import java.util.List;

public interface CardService
{
    List<Card> findAll();
    List<Card> getAllCardsByListId(Integer id);
    SingleCard findById(Integer id) throws NotFoundException;
    void delete(Integer id);
    Card insert(CardRequest cardRequest)throws NotFoundException;
    Card update(Integer id, CardRequest cardRequest)throws NotFoundException;

}
