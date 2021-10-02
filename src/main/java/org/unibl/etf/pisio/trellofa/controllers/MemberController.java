package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.*;
import org.unibl.etf.pisio.trellofa.models.requests.MemberRequest;
import org.unibl.etf.pisio.trellofa.services.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController
{
    private final MemberService memeberService;
    private final MembershipService membershipService;
    private final AttachmentService attachmentService;
    private final CommentService commentService;
    private final BoardHasMembersService boardHasMembersService;
    private final MembersOnCardsService membersOnCardsService;
    private final BoardService boardService;

    public MemberController(MemberService memebeService, MembershipService membershipService, AttachmentService attachmentService, CommentService commentService, BoardHasMembersService boardHasMembersService, MembersOnCardsService membersOnCardsService, BoardService boardService)
    {
        this.memeberService = memebeService;
        this.membershipService = membershipService;
        this.attachmentService = attachmentService;
        this.commentService = commentService;
        this.boardHasMembersService = boardHasMembersService;
        this.membersOnCardsService = membersOnCardsService;
        this.boardService = boardService;
    }

    @GetMapping
    List<Member> findAll()
    {
        return memeberService.findAll();
    }

    @GetMapping("/{id}")
    SingleMember findById(@PathVariable Integer id) throws NotFoundException
    {
        return memeberService.findById(id);
    }
    @GetMapping("/byusername/{un}")
        List<MemberBasic> findAllByUsername(@PathVariable String un) throws NotFoundException {
            return memeberService.findByMemberUsername(un);
        }
    @GetMapping("/{id}/boardsbymember")
    public List<Board> findBoardsByMemberId(@PathVariable Integer id)
    {
        return boardService.getBoardsByMemberId(id);
    }

    @GetMapping("/{id}/memberships")
    public List<Membership> findAllMembershipsByMemberId(@PathVariable Integer id)
    {
        return membershipService.getAllMembershipsByMemberId(id);
    }
    @GetMapping("/{id}/attachments")
    public List<Attachment> findAllAttachmentsByMemberId(@PathVariable Integer id)
    {
        return attachmentService.getAllAttachmentsByMemberId(id);
    }
    @GetMapping("/{id}/comments")
    public List<Comment> findAllCommentsByMemberId(@PathVariable Integer id)
    {
        return commentService.getAllCommentsByMemberId(id);
    }
    @GetMapping(("/{id}/boardhasmembers"))
    public List<BoardHasMembers> findAllBoardHasMembersByMemberId(@PathVariable Integer id)
    {
        return boardHasMembersService.findAllBoardHasMembersByMemberId(id);
    }
    @GetMapping("/{id}/membersoncards")
    public List<MembersOnCards> findAllMembersOnCardsByMemberId(@PathVariable Integer id)
    {
        return membersOnCardsService.getAllMembersOnCardsByMemberId(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id)throws NotFoundException
    {
        memeberService.delete(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Member insert(@RequestBody MemberRequest memberRequest) throws NotFoundException
    {
        return memeberService.insert(memberRequest);
    }
    @PutMapping("/{id}")
    public Member update(@PathVariable Integer id,@RequestBody MemberRequest memberRequest) throws NotFoundException
    {
        return memeberService.update(id,memberRequest);
    }
}
