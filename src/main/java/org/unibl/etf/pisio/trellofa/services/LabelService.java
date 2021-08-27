package org.unibl.etf.pisio.trellofa.services;

import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Label;

import java.util.List;

public interface LabelService
{
    List<Label> findAll();
    Label findById(Integer id) throws NotFoundException;
}
