package org.unibl.etf.pisio.trellofa.models;

import lombok.Data;

import java.util.List;

@Data
public class SingleMember extends Member
{
    List<Comment> comments;
    List<BoardHasMembers> boardHasMembers;
    List<Membership> memberships;
}
