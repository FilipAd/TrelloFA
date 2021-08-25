package org.unibl.etf.pisio.trellofa.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Organization;
import org.unibl.etf.pisio.trellofa.models.SingleOrganization;
import org.unibl.etf.pisio.trellofa.repositories.OrganizationEntityRepository;
import org.unibl.etf.pisio.trellofa.services.OrganizationService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl implements OrganizationService
{
    private final OrganizationEntityRepository repository;
    private final ModelMapper mapper;

    public OrganizationServiceImpl(OrganizationEntityRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Organization> findAll()
    {
        return repository.findAll().stream().map(e->mapper.map(e,Organization.class)).collect(Collectors.toList());
    }

    @Override
    public SingleOrganization findById(Integer id) throws NotFoundException {
        return mapper.map(repository.findById(id).orElseThrow(NotFoundException::new),SingleOrganization.class);
    }
}
