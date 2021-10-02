package org.unibl.etf.pisio.trellofa.services;

import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.BoardHasMembers;
import org.unibl.etf.pisio.trellofa.models.Invitation;
import org.unibl.etf.pisio.trellofa.models.requests.BoardHasMembersRequest;
import org.unibl.etf.pisio.trellofa.models.requests.InvitationRequest;

import java.util.List;

public interface InvitationService
{
    List<Invitation> findAll();
    List<Invitation> findAllInvitationByMemberId(Integer id);
    List<Invitation> findAllInvitationByBoardId(Integer id);
    Invitation findById(Integer id) throws NotFoundException;
    void delete(Integer id) throws NotFoundException;
    Invitation insert(InvitationRequest invitationRequest)throws NotFoundException;
    Invitation update(Integer id,InvitationRequest invitationRequest)throws NotFoundException;
}
