package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.BoardHasMembers;
import org.unibl.etf.pisio.trellofa.models.Invitation;
import org.unibl.etf.pisio.trellofa.models.entities.BoardHasMembersEntity;
import org.unibl.etf.pisio.trellofa.models.requests.BoardHasMembersRequest;
import org.unibl.etf.pisio.trellofa.models.requests.InvitationRequest;
import org.unibl.etf.pisio.trellofa.services.BoardHasMembersService;
import org.unibl.etf.pisio.trellofa.services.InvitationService;

import java.util.List;

@RestController
@RequestMapping("/invitations")
public class InvitationController
{
    private final InvitationService service;

    public InvitationController(InvitationService service)
    {
        this.service = service;
    }

    @GetMapping
    List<Invitation> findAll()
    {
        return service.findAll();
    }
    @GetMapping("/{idMember}")
    List<Invitation> findByMemberId(@PathVariable Integer idMember) throws NotFoundException
    {
        return  service.findAllInvitationByMemberId(idMember);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id)throws NotFoundException
    {
        service.delete(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Invitation insert(@RequestBody InvitationRequest invitationRequest)throws NotFoundException
    {
        return service.insert(invitationRequest);
    }

    @PutMapping("/{id}")
    public Invitation update(@PathVariable Integer id,@RequestBody InvitationRequest invitationRequest)throws NotFoundException
    {
        return service.update(id,invitationRequest);
    }
}
