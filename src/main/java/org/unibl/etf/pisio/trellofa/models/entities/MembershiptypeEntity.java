package org.unibl.etf.pisio.trellofa.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "membershiptype")
public class MembershiptypeEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "Type", nullable = true, length = 255)
    private String type;
    @OneToMany(mappedBy = "membershiptype")
    @JsonIgnore
    private List<MembershipEntity> memberships;

}
