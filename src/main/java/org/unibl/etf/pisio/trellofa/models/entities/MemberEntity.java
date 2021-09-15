package org.unibl.etf.pisio.trellofa.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.unibl.etf.pisio.trellofa.models.enums.Role;
import org.unibl.etf.pisio.trellofa.models.enums.Status;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "username", nullable = true, length = 255)
    private String username;
    @Basic
    @Column(name = "fullname", nullable = true, length = 255)
    private String fullname;
    @Basic
    @Column(name = "avatar_source", nullable = true, length = 255)
    private String avatarSource;
    @Basic
    @Column(name = "bio", nullable = true, length = 255)
    private String bio;
    @Basic
    @Column(name = "initials", nullable = true, length = 45)
    private String initials;
    @Basic
    @Column(name = "member_type", nullable = true, length = 255)
    private String memberType;
    @Basic
    @Column(name = "url", nullable = true, length = 255)
    private String url;
    @Basic
    @Column(name = "confirmed", nullable = true)
    private Byte confirmed;
    @Basic
    @Column(name = "email", nullable = true, length = 255)
    private String email;
    @Basic
    @Column(name = "password", nullable = true, length = 255)
    private String password;
    @Enumerated(EnumType.ORDINAL)
    @Column(name="role",nullable = false)
    private Role role;
    @Enumerated(EnumType.ORDINAL)
    @Column(name= "status",nullable = false)
    private Status status;
    @OneToMany(mappedBy = "member")
    @JsonIgnore
    private List<AttachmentEntity> attachments;
    @OneToMany(mappedBy = "member")
    @JsonIgnore
    private List<BoardHasMembersEntity> boardHasMembers;
    @OneToMany(mappedBy = "member")
    @JsonIgnore
    private List<CommentEntity> comments;
    @OneToMany(mappedBy = "member")
    @JsonIgnore
    private List<MembershipEntity> memberships;

}
