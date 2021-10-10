package org.unibl.etf.pisio.trellofa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.entities.AppKeysEntity;
import org.unibl.etf.pisio.trellofa.models.entities.OrganizationEntity;

public interface AppKeysEntityRepository extends JpaRepository<AppKeysEntity,String>
{
    void deleteByKey(String key) throws NotFoundException;
}

