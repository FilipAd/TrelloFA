package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Member;
import org.unibl.etf.pisio.trellofa.models.SingleMember;
import org.unibl.etf.pisio.trellofa.models.entities.MemberEntity;
import org.unibl.etf.pisio.trellofa.models.requests.MemberRequest;
import org.unibl.etf.pisio.trellofa.services.MemberService;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController
{
    private final MemberService memebeService;

    public MemberController(MemberService memebeService)
    {
        this.memebeService = memebeService;
    }

    @GetMapping
    List<Member> findAll()
    {
        return memebeService.findAll();
    }
    @GetMapping("/{id}")
    SingleMember findById(@PathVariable Integer id) throws NotFoundException
    {
        return memebeService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id)
    {
        memebeService.delete(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Member insert(@RequestBody MemberRequest memberRequest) throws NotFoundException
    {
        return memebeService.insert(memberRequest);
    }

    @PutMapping("/{id}")
    public Member update(@PathVariable Integer id,@RequestBody MemberRequest memberRequest) throws NotFoundException
    {
        return memebeService.update(id,memberRequest);
    }
}
