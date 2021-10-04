package org.unibl.etf.pisio.trellofa.services;

import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.BoardHasMembers;
import org.unibl.etf.pisio.trellofa.models.CardHasLabels;
import org.unibl.etf.pisio.trellofa.models.entities.BoardEntity;
import org.unibl.etf.pisio.trellofa.models.requests.BoardHasMembersRequest;
import org.unibl.etf.pisio.trellofa.models.requests.CardHasLabelsRequest;

import java.util.List;

public interface CardHasLabelsService
{
    List<CardHasLabels> findAll();
    List<CardHasLabels> findAllCardHasLabelsByCardId(Integer id);
    List<CardHasLabels> findAllCardHasLabelsByLabelId(Integer id);
    List<CardHasLabels> findAllCardHasLabelsByCardAndLabel(Integer idCard,Integer idLabel);
    void deleteAllCardHasLabelsByCardIdAndLabelId(Integer idCard,Integer idLabel);
    CardHasLabels findById(Integer id) throws NotFoundException;
    void delete(Integer id) throws NotFoundException;
    CardHasLabels insert(CardHasLabelsRequest cardHasLabelsRequest)throws NotFoundException;
    CardHasLabels update(Integer id, CardHasLabelsRequest cardHasLabelsRequest)throws NotFoundException;
}
