package org.unibl.etf.pisio.trellofa.models.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "card_has_labels")
public class CardHasLabelsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "id_card", nullable = false,insertable = false,updatable = false)
    private Integer idCard;
    @Basic
    @Column(name = "id_label", nullable = false,insertable = false,updatable = false)
    private Integer idLabel;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_card", referencedColumnName = "id", nullable = false)
    private CardEntity card;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_label", referencedColumnName = "id", nullable = false)
    private LabelEntity label;

}
