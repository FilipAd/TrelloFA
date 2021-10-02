package org.unibl.etf.pisio.trellofa.services;


import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Member;
import org.unibl.etf.pisio.trellofa.models.MemberBasic;
import org.unibl.etf.pisio.trellofa.models.SingleMember;
import org.unibl.etf.pisio.trellofa.models.requests.MemberRequest;
import org.unibl.etf.pisio.trellofa.models.requests.SignUpRequest;

import java.util.List;

public interface MemberService
{
    List<Member>findAll();
    SingleMember findById(Integer id) throws NotFoundException;
    Member findByIdMember(Integer id) throws NotFoundException;
    List<MemberBasic> findByMemberUsername(String un) throws NotFoundException;
    void singUp(MemberRequest request);
    void delete(Integer id) throws NotFoundException;
    Member insert(MemberRequest memberRequest) throws NotFoundException;
    Member update(Integer id,MemberRequest memberRequest) throws NotFoundException;
}
