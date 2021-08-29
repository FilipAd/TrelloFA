package org.unibl.etf.pisio.trellofa.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "card")
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = true, length = 100)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "url", nullable = true, length = 255)
    private String url;
    @Basic
    @Column(name = "due", nullable = true)
    private Date due;
    @Basic
    @Column(name = "due_complete", nullable = true)
    private Byte dueComplete;
    @Basic
    @Column(name = "closed", nullable = true)
    private Byte closed;
    @Basic
    @Column(name = "date_last_activity", nullable = true)
    private Date dateLastActivity;
    @Basic
    @Column(name = "id_short", nullable = true, length = 150)
    private String idShort;
    @Basic
    @Column(name = "pos", nullable = true)
    private Long pos;
    @Basic
    @Column(name = "short_link", nullable = true, length = 150)
    private String shortLink;
    @Basic
    @Column(name = "short_url", nullable = true, length = 150)
    private String shortUrl;
    @Basic
    @Column(name = "subscribed", nullable = true)
    private Byte subscribed;
    @Basic
    @Column(name = "id_list", nullable = false,insertable = false,updatable = false)
    private Integer idList;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_list", referencedColumnName = "id", nullable = false)
    private ListEntity list;
    @OneToMany(mappedBy = "card")
    @JsonIgnore
    private List<CommentEntity> comments;
    @OneToMany(mappedBy = "card")
    @JsonIgnore
    private List<LabelEntity> labels;

}
