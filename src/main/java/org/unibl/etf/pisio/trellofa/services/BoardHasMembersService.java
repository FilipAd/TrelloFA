package org.unibl.etf.pisio.trellofa.services;


import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.BoardHasMembers;
import org.unibl.etf.pisio.trellofa.models.entities.BoardEntity;
import org.unibl.etf.pisio.trellofa.models.requests.BoardHasMembersRequest;

import java.util.List;

public interface BoardHasMembersService
{
    List<BoardHasMembers> findAll();
    BoardHasMembers findById(Integer id) throws NotFoundException;
    void delete(Integer id);
    BoardHasMembers insert(BoardHasMembersRequest boardHasMembersRequest)throws NotFoundException;
    BoardHasMembers update(Integer id,BoardHasMembersRequest boardHasMembersRequest)throws NotFoundException;
}
