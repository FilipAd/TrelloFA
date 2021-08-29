package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Board;
import org.unibl.etf.pisio.trellofa.models.Membership;
import org.unibl.etf.pisio.trellofa.models.Organization;
import org.unibl.etf.pisio.trellofa.models.SingleOrganization;
import org.unibl.etf.pisio.trellofa.models.requests.OrganizationRequest;
import org.unibl.etf.pisio.trellofa.services.BoardService;
import org.unibl.etf.pisio.trellofa.services.MembershipService;
import org.unibl.etf.pisio.trellofa.services.OrganizationService;

import java.util.List;

@RestController
@RequestMapping("/organizations")
public class OrganizationController
{
  private final OrganizationService organizationService;
  private final BoardService boardService;
  private final MembershipService membershipService;

    public OrganizationController(OrganizationService organizationService, BoardService boardService, MembershipService membershipService)
    {
        this.organizationService = organizationService;
        this.boardService = boardService;
        this.membershipService = membershipService;
    }

    @GetMapping
    List<Organization> findAll()
    {
        return organizationService.findAll();
    }

    @GetMapping("/{id}")
    public SingleOrganization findById(@PathVariable Integer id) throws NotFoundException
    {
        return organizationService.findById(id);
    }
    @GetMapping("/{id}/boards")
    public List<Board> getAllBoardsByOrganizationId(@PathVariable Integer id)
    {
        return boardService.getAllBoardsByOrganizationId(id);
    }
    @GetMapping("/{id}/memberships")
    public List<Membership> getAllMembershipsByOrganizationId(@PathVariable Integer id)
    {
        return membershipService.getAllMembershipsByOrganizationId(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id)
    {
        organizationService.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Organization insert(@RequestBody OrganizationRequest organizationRequest) throws NotFoundException
    {
        return organizationService.insert(organizationRequest);
    }
    @PutMapping("/{id}")
    public Organization update(@PathVariable Integer id,@RequestBody OrganizationRequest organizationRequest) throws NotFoundException {
        return organizationService.update(id,organizationRequest);
    }




}
