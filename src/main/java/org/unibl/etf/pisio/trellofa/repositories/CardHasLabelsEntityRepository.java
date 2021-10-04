package org.unibl.etf.pisio.trellofa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.pisio.trellofa.models.Board;
import org.unibl.etf.pisio.trellofa.models.entities.CardHasLabelsEntity;
import org.unibl.etf.pisio.trellofa.models.entities.InvitationEntity;

import java.util.List;

public interface CardHasLabelsEntityRepository extends JpaRepository<CardHasLabelsEntity,Integer>
{
    List<CardHasLabelsEntity> getAllByCard_Id(Integer id);
    List<CardHasLabelsEntity> getAllByLabel_Id(Integer id);
    List<CardHasLabelsEntity> getAllByCard_IdAndLabel_Id(Integer idCard, Integer idLabel);
    void deleteAllByCard_IdAndLabel_Id(Integer idCard, Integer idLabel);

}
