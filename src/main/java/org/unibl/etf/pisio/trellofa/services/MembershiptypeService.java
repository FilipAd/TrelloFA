package org.unibl.etf.pisio.trellofa.services;


import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import java.util.List;
import org.unibl.etf.pisio.trellofa.models.Membershiptype;
import org.unibl.etf.pisio.trellofa.models.SingleMembershiptype;

public interface MembershiptypeService
{
    List<Membershiptype> findAll();
    SingleMembershiptype findById (Integer id) throws NotFoundException;
}
