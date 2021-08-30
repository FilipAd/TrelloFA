package org.unibl.etf.pisio.trellofa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.pisio.trellofa.models.entities.MembershipEntity;

import java.util.List;

public interface MembershipEntityRepository extends JpaRepository<MembershipEntity,Integer>
{
    List<MembershipEntity>getAllByOrganization_Id(Integer id);
    List<MembershipEntity>getAllByMembershiptype_Id(Integer id);
    List<MembershipEntity>getAllByMember_Id(Integer id);
}
