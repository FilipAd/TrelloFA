package org.unibl.etf.pisio.trellofa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.pisio.trellofa.models.entities.ListEntity;

public interface ListEntityRepository extends JpaRepository<ListEntity,Integer>
{
}
