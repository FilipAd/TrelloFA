package org.unibl.etf.pisio.trellofa.services;


import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import java.util.List;
import org.unibl.etf.pisio.trellofa.models.Membershiptype;
import org.unibl.etf.pisio.trellofa.models.SingleMembershiptype;
import org.unibl.etf.pisio.trellofa.models.requests.MembershiptypeRequest;

public interface MembershiptypeService
{
    List<Membershiptype> findAll();
    SingleMembershiptype findById (Integer id) throws NotFoundException;
    void delete(Integer id) throws NotFoundException;
    Membershiptype insert(MembershiptypeRequest membershiptypeRequest) throws NotFoundException;
    Membershiptype update(Integer id,MembershiptypeRequest membershiptypeRequest) throws NotFoundException;
}
