package org.unibl.etf.pisio.trellofa.services;

import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Board;
import org.unibl.etf.pisio.trellofa.models.Organization;
import org.unibl.etf.pisio.trellofa.models.SingleBoard;
import org.unibl.etf.pisio.trellofa.models.SingleOrganization;

import java.util.List;

public interface BoardService
{
    List<Board> findAll();
    SingleBoard findById(Integer id) throws NotFoundException;
}
