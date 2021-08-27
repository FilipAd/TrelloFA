package org.unibl.etf.pisio.trellofa.services;

import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Membership;

import java.util.List;

public interface MembershipService
{
    List<Membership> findAll();
    Membership findById(Integer id) throws NotFoundException;
}
