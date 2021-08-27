package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.Member;
import org.unibl.etf.pisio.trellofa.models.SingleMember;
import org.unibl.etf.pisio.trellofa.models.entities.MemberEntity;
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
}
