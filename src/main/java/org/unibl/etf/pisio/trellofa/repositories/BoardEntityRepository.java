package org.unibl.etf.pisio.trellofa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.unibl.etf.pisio.trellofa.models.Board;
import org.unibl.etf.pisio.trellofa.models.entities.BoardEntity;

import java.util.List;

public interface BoardEntityRepository extends JpaRepository<BoardEntity,Integer>
{
    List<BoardEntity> getAllByOrganization_Id(Integer id);
    @Query("select b from BoardEntity b join BoardHasMembersEntity  bhm on b.id=bhm.idBoard  where bhm.idMember= :id")
    List<BoardEntity> getBoardsByMemberId(Integer id);
}
