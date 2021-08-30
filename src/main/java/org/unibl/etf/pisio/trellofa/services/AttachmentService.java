package org.unibl.etf.pisio.trellofa.services;


import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Attachment;
import org.unibl.etf.pisio.trellofa.models.Board;
import org.unibl.etf.pisio.trellofa.models.SingleBoard;
import org.unibl.etf.pisio.trellofa.models.requests.AttachmentRequest;

import java.util.List;

public interface AttachmentService
{
    List<Attachment> findAll();
    Attachment findById(Integer id) throws NotFoundException;
    List<Attachment> getAllAttachmentsByMemberId(Integer id);
    void delete(Integer id);
    Attachment insert(AttachmentRequest attachmentRequest)throws NotFoundException;
    Attachment update(Integer id,AttachmentRequest attachmentRequest)throws NotFoundException;
}
