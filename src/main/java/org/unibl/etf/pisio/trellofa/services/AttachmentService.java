package org.unibl.etf.pisio.trellofa.services;


import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Attachment;
import org.unibl.etf.pisio.trellofa.models.Board;
import org.unibl.etf.pisio.trellofa.models.SingleBoard;

import java.util.List;

public interface AttachmentService
{
    List<Attachment> findAll();
    Attachment findById(Integer id) throws NotFoundException;
}
