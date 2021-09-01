package org.unibl.etf.pisio.trellofa.services;

import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.SingleList;
import org.unibl.etf.pisio.trellofa.models.requests.ListRequest;

import java.util.List;

public interface ListService
{
    List<org.unibl.etf.pisio.trellofa.models.List> findAll();
    SingleList findById(Integer id) throws NotFoundException;
    List<org.unibl.etf.pisio.trellofa.models.List>getAllListsByBoardId(Integer id);
    void delete(Integer id) throws  NotFoundException;
    org.unibl.etf.pisio.trellofa.models.List insert(ListRequest listRequest)throws NotFoundException;
    org.unibl.etf.pisio.trellofa.models.List update(Integer id,ListRequest listRequest) throws NotFoundException;
}
