package org.unibl.etf.pisio.trellofa.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SingleMembershiptype extends Membershiptype
{
    List<Membership> memberships;
}
