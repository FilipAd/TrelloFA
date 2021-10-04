package org.unibl.etf.pisio.trellofa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.pisio.trellofa.models.entities.LabelEntity;

import java.util.List;

public interface LabelEntityRepository extends JpaRepository<LabelEntity,Integer>
{
//  List<LabelEntity> getAllBy(Integer id);
}
