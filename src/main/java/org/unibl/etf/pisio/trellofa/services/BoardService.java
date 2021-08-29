package org.unibl.etf.pisio.trellofa.services;

import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Board;
import org.unibl.etf.pisio.trellofa.models.Organization;
import org.unibl.etf.pisio.trellofa.models.SingleBoard;
import org.unibl.etf.pisio.trellofa.models.SingleOrganization;
import org.unibl.etf.pisio.trellofa.models.requests.BoardRequest;

import java.util.List;

public interface BoardService
{
    List<Board> findAll();
    SingleBoard findById(Integer id) throws NotFoundException;
    List<Board> getAllBoardsByOrganizationId(Integer id);
    void delete(Integer id);
    Board insert(BoardRequest boardRequest) throws NotFoundException;
    Board update(Integer id,BoardRequest boardRequest) throws NotFoundException;

}
