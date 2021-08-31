package org.unibl.etf.pisio.trellofa.services;

import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.MembersOnCards;
import org.unibl.etf.pisio.trellofa.models.Membership;
import org.unibl.etf.pisio.trellofa.models.requests.MembersOnCardsRequest;
import org.unibl.etf.pisio.trellofa.models.requests.MembershipRequest;

import java.util.List;

public interface MembersOnCardsService
{
List<MembersOnCards> findAll();
List<MembersOnCards> getAllMembersOnCardsByMemberId(Integer id);
List<MembersOnCards> getAllMembersOnCardsByCardId(Integer id);
MembersOnCards findById(Integer id) throws NotFoundException;
    void delete(Integer id);
    MembersOnCards insert(MembersOnCardsRequest membersOnCardsRequest) throws NotFoundException;
    MembersOnCards update(Integer id,MembersOnCardsRequest membersOnCardsRequest) throws NotFoundException;
}
