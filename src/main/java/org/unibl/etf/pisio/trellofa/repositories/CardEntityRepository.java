package org.unibl.etf.pisio.trellofa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.pisio.trellofa.models.entities.CardEntity;

import java.util.List;

public interface CardEntityRepository extends JpaRepository<CardEntity,Integer>
{
    List<CardEntity> getAllByList_Id(Integer id);
}
