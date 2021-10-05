package org.unibl.etf.pisio.trellofa.services;


import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.BoardHasMembers;
import org.unibl.etf.pisio.trellofa.models.entities.BoardEntity;
import org.unibl.etf.pisio.trellofa.models.requests.BoardHasMembersRequest;

import java.util.List;

public interface BoardHasMembersService
{
    List<BoardHasMembers> findAll();
    List<BoardHasMembers> findAllBoardHasMembersByMemberId(Integer id);
    List<BoardHasMembers> findAllBoardHasMembersByBoardId(Integer id);
    List<BoardHasMembers> findAllBoardHasMembersByBoardAndMember(Integer idMember,Integer idBoard);
    void deleteAllBoardHasMembersByMemberIdAndBoardId(Integer idMember,Integer idBoard) throws NotFoundException;
    BoardHasMembers findById(Integer id) throws NotFoundException;
    void delete(Integer id) throws NotFoundException;
    BoardHasMembers insert(BoardHasMembersRequest boardHasMembersRequest)throws NotFoundException;
    BoardHasMembers update(Integer id,BoardHasMembersRequest boardHasMembersRequest)throws NotFoundException;
}
