package org.unibl.etf.pisio.trellofa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.unibl.etf.pisio.trellofa.models.entities.CardEntity;
import org.unibl.etf.pisio.trellofa.models.entities.LabelEntity;

import java.util.List;

public interface CardEntityRepository extends JpaRepository<CardEntity,Integer>
{
    List<CardEntity> getAllByList_Id(Integer id);
    @Query("select l from LabelEntity l join CardHasLabelsEntity chl on l.id=chl.idLabel  where chl.idCard= :idCard")
    List<LabelEntity> getAllLabelsByCardId(Integer idCard);
}
