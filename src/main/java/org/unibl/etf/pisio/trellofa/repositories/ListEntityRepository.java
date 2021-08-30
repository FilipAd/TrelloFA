package org.unibl.etf.pisio.trellofa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.pisio.trellofa.models.entities.ListEntity;

import java.util.List;

public interface ListEntityRepository extends JpaRepository<ListEntity,Integer>
{

    List<ListEntity> findAllByBoard_Id(Integer id);
}
