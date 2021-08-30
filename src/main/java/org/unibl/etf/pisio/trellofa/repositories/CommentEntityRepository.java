package org.unibl.etf.pisio.trellofa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.pisio.trellofa.models.entities.CommentEntity;

import java.util.List;

public interface CommentEntityRepository extends JpaRepository<CommentEntity,Integer>
{
    List<CommentEntity> getAllByMember_Id(Integer id);
    List<CommentEntity> getAllByCard_Id(Integer id);
}
