package org.unibl.etf.pisio.trellofa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.unibl.etf.pisio.trellofa.models.Board;
import org.unibl.etf.pisio.trellofa.models.entities.InvitationEntity;

import java.util.List;

public interface InvitationEntityRepository extends JpaRepository<InvitationEntity,Integer>
{
    List<InvitationEntity> getAllByMember_Id(Integer id);
    List<InvitationEntity> getAllByBoard_Id(Integer id);
}
