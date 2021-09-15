package org.unibl.etf.pisio.trellofa.models.requests;

import lombok.Data;
import org.unibl.etf.pisio.trellofa.models.enums.Role;
import org.unibl.etf.pisio.trellofa.models.enums.Status;

@Data
public class MemberRequest
{
    private String username;

    private String fullname;

    private String avatarSource;

    private String bio;

    private String initials;

    private String memberType;

    private Status status;

    private Role role;

    private String url;

    private Byte confirmed;

    private String email;

    private String password;
}
