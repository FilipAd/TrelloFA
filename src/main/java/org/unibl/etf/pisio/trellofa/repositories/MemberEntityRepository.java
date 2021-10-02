package org.unibl.etf.pisio.trellofa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.unibl.etf.pisio.trellofa.models.entities.BoardEntity;
import org.unibl.etf.pisio.trellofa.models.entities.MemberEntity;
import org.unibl.etf.pisio.trellofa.models.enums.Status;

import java.util.List;
import java.util.Optional;

public interface MemberEntityRepository extends JpaRepository<MemberEntity,Integer>
{    Optional<MemberEntity> findByUsernameAndStatus(String username, Status active);
     Boolean existsByUsername(String username);
     Boolean existsByUsernameAndIdNot(String username,Integer id);
     List<MemberEntity> getAllByUsernameContains(String un);
}
