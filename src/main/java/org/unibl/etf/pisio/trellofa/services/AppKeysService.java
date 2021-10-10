package org.unibl.etf.pisio.trellofa.services;

import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.AppKeys;
import org.unibl.etf.pisio.trellofa.models.Attachment;
import org.unibl.etf.pisio.trellofa.models.requests.AppKeysRequest;
import org.unibl.etf.pisio.trellofa.models.requests.AttachmentRequest;

import java.util.List;

public interface AppKeysService
{
    List<AppKeys> findAll();
    AppKeys findByKeys(String key) throws NotFoundException;
    void deleteByKey(String key) throws NotFoundException;
    void delete(String key) throws NotFoundException;
    AppKeys insert(AppKeysRequest appKeysRequest)throws NotFoundException;
    AppKeys update(String key,AppKeysRequest appKeysRequest)throws NotFoundException;
}
