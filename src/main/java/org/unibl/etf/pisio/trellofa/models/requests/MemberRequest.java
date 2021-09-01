package org.unibl.etf.pisio.trellofa.models.requests;

import lombok.Data;

@Data
public class MemberRequest
{
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
