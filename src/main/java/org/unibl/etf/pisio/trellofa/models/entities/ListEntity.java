package org.unibl.etf.pisio.trellofa.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "list")
public class ListEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "closed", nullable = true)
    private Byte closed;
    @Basic
    @Column(name = "pos", nullable = true)
    private Integer pos;
    @Basic
    @Column(name = "subscribed", nullable = true)
    private Byte subscribed;
    @Basic
    @Column(name = "id_board", nullable = false,insertable = false,updatable = false)
    private Integer idBoard;
    @OneToMany(mappedBy = "list")
    @JsonIgnore
    private List<CardEntity> cards;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_board", referencedColumnName = "id", nullable = false)
    private BoardEntity board;

}
