package org.unibl.etf.pisio.trellofa.models;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;

@Data
public class Membership
{
    private Integer id;

    private Integer idOrganization;

    private Integer idMember;

    private Integer idMembershipType;
}
