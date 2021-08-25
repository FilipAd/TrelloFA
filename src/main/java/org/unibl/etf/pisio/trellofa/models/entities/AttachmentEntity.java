package org.unibl.etf.pisio.trellofa.models.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "attachment")
public class AttachmentEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "bytes", nullable = true)
    private Integer bytes;
    @Basic
    @Column(name = "date", nullable = true)
    private Date date;
    @Basic
    @Column(name = "is_upload", nullable = true)
    private Byte isUpload;
    @Basic
    @Column(name = "mime_type", nullable = true, length = 255)
    private String mimeType;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "url", nullable = true, length = 255)
    private String url;
    @Basic
    @Column(name = "id_member", nullable = false,insertable = false,updatable = false)
    private Integer idMember;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_member", referencedColumnName = "id", nullable = false)
    private MemberEntity member;

}
