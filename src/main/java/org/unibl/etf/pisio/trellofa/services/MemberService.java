package org.unibl.etf.pisio.trellofa.services;


import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Member;
import org.unibl.etf.pisio.trellofa.models.SingleMember;
import org.unibl.etf.pisio.trellofa.models.requests.MemberRequest;

import java.util.List;

public interface MemberService
{
    List<Member>findAll();
    SingleMember findById(Integer id) throws NotFoundException;
    void delete(Integer id);
    Member insert(MemberRequest memberRequest) throws NotFoundException;
    Member update(Integer id,MemberRequest memberRequest) throws NotFoundException;
}
