package org.unibl.etf.pisio.trellofa.services;

import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.SingleList;

import java.util.List;

public interface ListService
{
    List<org.unibl.etf.pisio.trellofa.models.List> findAll();
    SingleList findById(Integer id) throws NotFoundException;
}
