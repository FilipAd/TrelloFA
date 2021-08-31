package org.unibl.etf.pisio.trellofa.models.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "members_on_cards")
public class MembersOnCardsEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "id_member", nullable = false,insertable = false,updatable = false)
    private Integer idMember;
    @Basic
    @Column(name = "id_card", nullable = false,insertable = false,updatable = false)
    private Integer idCard;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_card", referencedColumnName = "id", nullable = false)
    private CardEntity card;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_member", referencedColumnName = "id", nullable = false)
    private MemberEntity member;

}
