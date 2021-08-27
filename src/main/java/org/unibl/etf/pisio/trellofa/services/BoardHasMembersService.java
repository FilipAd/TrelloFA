package org.unibl.etf.pisio.trellofa.services;


import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.BoardHasMembers;

import java.util.List;

public interface BoardHasMembersService
{
    List<BoardHasMembers> findAll();
    BoardHasMembers findById(Integer id) throws NotFoundException;
}
