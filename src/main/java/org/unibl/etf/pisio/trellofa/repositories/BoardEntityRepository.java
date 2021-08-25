package org.unibl.etf.pisio.trellofa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.pisio.trellofa.models.entities.BoardEntity;

public interface BoardEntityRepository extends JpaRepository<BoardEntity,Integer>
{
}
