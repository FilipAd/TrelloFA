package org.unibl.etf.pisio.trellofa.models.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "membership")
public class MembershipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "id_organization", nullable = false)
    private Integer idOrganization;
    @Basic
    @Column(name = "id_member", nullable = false)
    private Integer idMember;
    @Basic
    @Column(name = "id_membership_type", nullable = false)
    private Integer idMembershipType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_organization", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private OrganizationEntity organization;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_member", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private MemberEntity member;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_membership_type", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private MembershiptypeEntity membershiptype;

}
