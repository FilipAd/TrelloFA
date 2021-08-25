package org.unibl.etf.pisio.trellofa.services;

import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Organization;
import org.unibl.etf.pisio.trellofa.models.SingleOrganization;

import java.util.List;

public interface OrganizationService
{
    List<Organization> findAll();
    SingleOrganization findById(Integer id) throws NotFoundException;

}
