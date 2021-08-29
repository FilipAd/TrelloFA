package org.unibl.etf.pisio.trellofa.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "closed", nullable = true)
    private Byte closed;
    @Basic
    @Column(name = "pinned", nullable = true)
    private Byte pinned;
    @Basic
    @Column(name = "url", nullable = true, length = 255)
    private String url;
    @Basic
    @Column(name = "invited", nullable = true)
    private Byte invited;
    @Basic
    @Column(name = "short_url", nullable = true, length = 150)
    private String shortUrl;
    @Basic
    @Column(name = "subscribed", nullable = true)
    private Byte subscribed;
    @Basic
    @Column(name = "date_last_activity", nullable = true)
    private Timestamp dateLastActivity;
    @Basic
    @Column(name = "date_last_view", nullable = true)
    private Timestamp dateLastView;
    @Basic
    @Column(name = "short_link", nullable = true, length = 150)
    private String shortLink;
    @Basic
    @Column(name = "id_organization", nullable = false,insertable = false,updatable = false)
    private Integer idOrganization;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_organization", referencedColumnName = "id", nullable = false)
    private OrganizationEntity organization;
    @OneToMany(mappedBy = "board")
    @JsonIgnore
    private List<BoardHasMembersEntity> boardHasMembers;
    @OneToMany(mappedBy = "board")
    @JsonIgnore
    private List<ListEntity> lists;

}
