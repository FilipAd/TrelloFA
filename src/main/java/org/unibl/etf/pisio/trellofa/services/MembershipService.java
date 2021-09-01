package org.unibl.etf.pisio.trellofa.services;

import org.aspectj.weaver.ast.Not;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Board;
import org.unibl.etf.pisio.trellofa.models.Membership;
import org.unibl.etf.pisio.trellofa.models.requests.MembershipRequest;

import java.util.List;

public interface MembershipService
{
    List<Membership> findAll();
    Membership findById(Integer id) throws NotFoundException;
    List<Membership> getAllMembershipsByOrganizationId(Integer id);
    List<Membership> getAllMembershipsByMembershiptypeId(Integer id);
    List<Membership> getAllMembershipsByMemberId(Integer id);
    void delete(Integer id) throws NotFoundException;
    Membership insert(MembershipRequest membershipRequest) throws NotFoundException;
    Membership update(Integer id,MembershipRequest membershipRequest) throws NotFoundException;

}
