package org.unibl.etf.pisio.trellofa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.pisio.trellofa.models.entities.BoardHasMembersEntity;

import java.util.List;

public interface BoardHasMembersEntityRepository extends JpaRepository<BoardHasMembersEntity,Integer>
{
    List<BoardHasMembersEntity> getAllByMember_Id(Integer id);
    List<BoardHasMembersEntity> getAllByBoard_Id(Integer id);
}
