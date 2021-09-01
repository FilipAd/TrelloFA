package org.unibl.etf.pisio.trellofa.models;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class Member
{
    private Integer id;

    private String userName;

    private String fullName;

    private String avatarSource;

    private String bio;

    private String initials;

    private String memberType;

    private String status;

    private String url;

    private Byte confirmed;

    private String email;

    private String password_hash;
}
