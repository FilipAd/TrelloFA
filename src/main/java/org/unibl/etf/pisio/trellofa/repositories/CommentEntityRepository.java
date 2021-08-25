package org.unibl.etf.pisio.trellofa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.pisio.trellofa.models.entities.CommentEntity;

public interface CommentEntityRepository extends JpaRepository<CommentEntity,Integer>
{
}
