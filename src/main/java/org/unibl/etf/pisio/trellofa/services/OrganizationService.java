package org.unibl.etf.pisio.trellofa.services;

import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Organization;
import org.unibl.etf.pisio.trellofa.models.SingleOrganization;
import org.unibl.etf.pisio.trellofa.models.requests.OrganizationRequest;

import java.util.List;

public interface OrganizationService
{
    List<Organization> findAll();
    SingleOrganization findById(Integer id) throws NotFoundException;
    Organization insert(OrganizationRequest organizationRequest) throws NotFoundException;
    Organization update(Integer id,OrganizationRequest organizationRequest) throws NotFoundException;
    void delete(Integer id);



}
