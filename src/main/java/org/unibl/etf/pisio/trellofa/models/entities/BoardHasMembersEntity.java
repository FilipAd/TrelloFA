package org.unibl.etf.pisio.trellofa.models.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "board_has_members")
public class BoardHasMembersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "id_board", nullable = false,insertable = false,updatable = false)
    private Integer idBoard;
    @Basic
    @Column(name = "id_member", nullable = false,insertable = false,updatable = false)
    private Integer idMember;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_board", referencedColumnName = "id", nullable = false)
    private BoardEntity board;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_member", referencedColumnName = "id", nullable = false)
    private MemberEntity member;

}
