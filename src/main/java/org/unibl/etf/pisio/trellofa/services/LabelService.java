package org.unibl.etf.pisio.trellofa.services;

import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Label;
import org.unibl.etf.pisio.trellofa.models.requests.LabelRequest;

import java.util.List;

public interface LabelService {
    List<Label> findAll();

    Label findById(Integer id) throws NotFoundException;

    List<Label> findByMemberId(Integer id) throws  NotFoundException;

    void delete(Integer id) throws NotFoundException;

    Label insert(LabelRequest labelRequest) throws NotFoundException;

    Label update(Integer id, LabelRequest labelRequest) throws NotFoundException;


  //  List<Label> getAllLabelsByCardId(Integer id);
}


