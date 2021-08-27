package org.unibl.etf.pisio.trellofa.services;


import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Member;
import org.unibl.etf.pisio.trellofa.models.SingleMember;

import java.util.List;

public interface MemberService
{
    List<Member>findAll();
    SingleMember findById(Integer id) throws NotFoundException;
}
