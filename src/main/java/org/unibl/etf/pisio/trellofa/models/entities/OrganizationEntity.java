package org.unibl.etf.pisio.trellofa.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "organization")
public class OrganizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "display_name", nullable = true, length = 255)
    private String displayName;
    @Basic
    @Column(name = "description", nullable = true, length = 255)
    private String description;
    @Basic
    @Column(name = "invited", nullable = true)
    private Byte invited;
    @Basic
    @Column(name = "url", nullable = true, length = 255)
    private String url;
    @Basic
    @Column(name = "website", nullable = true, length = 255)
    private String website;
    @OneToMany(mappedBy = "organization")
    @JsonIgnore
    private List<BoardEntity> boards;
    @OneToMany(mappedBy = "organization")
    @JsonIgnore
    private List<MembershipEntity> memberships;

}
