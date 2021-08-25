package org.unibl.etf.pisio.trellofa.models.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "comment")
public class CommentEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "text", nullable = true, length = -1)
    private String text;
    @Basic
    @Column(name = "date", nullable = true)
    private Date date;
    @Basic
    @Column(name = "id_card", nullable = false,insertable = false,updatable = false)
    private Integer idCard;
    @Basic
    @Column(name = "id_member", nullable = false,insertable = false,updatable = false)
    private Integer idMember;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_card", referencedColumnName = "id", nullable = false)
    private CardEntity card;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_member", referencedColumnName = "id", nullable = false)
    private MemberEntity member;

}
