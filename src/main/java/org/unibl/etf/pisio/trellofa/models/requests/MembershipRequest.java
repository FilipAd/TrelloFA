package org.unibl.etf.pisio.trellofa.models.requests;

import lombok.Data;

@Data
public class MembershipRequest
{
    private Integer id;

    private Integer idOrganization;

    private Integer idMember;

    private Integer idMembershipType;
}
