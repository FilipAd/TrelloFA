package org.unibl.etf.pisio.trellofa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.pisio.trellofa.models.entities.MembersOnCardsEntity;

import java.util.List;


public interface MembersOnCardsEntityRepository extends JpaRepository<MembersOnCardsEntity,Integer>
{
List<MembersOnCardsEntity> getAllByMember_Id(Integer id);
List<MembersOnCardsEntity> getAllByCard_Id(Integer id);
}
