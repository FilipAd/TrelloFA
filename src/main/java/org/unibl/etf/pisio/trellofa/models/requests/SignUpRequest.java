package org.unibl.etf.pisio.trellofa.models.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SignUpRequest
{
    @NotBlank
    private String username;
    @NotBlank
    private String fullname;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
