package org.unibl.etf.pisio.trellofa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.pisio.trellofa.models.entities.AttachmentEntity;

import java.util.List;

public interface AttachmentEntityRepository extends JpaRepository<AttachmentEntity,Integer>
{
    List<AttachmentEntity> findAllByMember_Id(Integer id);
}
