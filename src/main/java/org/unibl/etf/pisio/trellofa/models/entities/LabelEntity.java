package org.unibl.etf.pisio.trellofa.models.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "label")
public class LabelEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "color", nullable = true, length = 255)
    private String color;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "text", nullable = true, length = -1)
    private String text;
    @Basic
    @Column(name = "id_card", nullable = false,insertable = false,updatable = false)
    private Integer idCard;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_card", referencedColumnName = "id", nullable = false)
    private CardEntity card;

}
