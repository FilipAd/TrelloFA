package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Organization;
import org.unibl.etf.pisio.trellofa.models.SingleOrganization;
import org.unibl.etf.pisio.trellofa.models.entities.OrganizationEntity;
import org.unibl.etf.pisio.trellofa.services.OrganizationService;

import java.util.List;

@RestController
@RequestMapping("/organizations")
public class OrganizationController
{
  private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService)
    {
        this.organizationService = organizationService;
    }

    @GetMapping
    List<Organization> findAll()
    {
        return organizationService.findAll();
    }

    @GetMapping("/{id}")
    public SingleOrganization findById(@PathVariable Integer id) throws NotFoundException {
        return organizationService.findById(id);
    }


}
