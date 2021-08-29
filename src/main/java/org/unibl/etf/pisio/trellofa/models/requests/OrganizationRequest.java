package org.unibl.etf.pisio.trellofa.models.requests;

import lombok.Data;

@Data
public class OrganizationRequest
{
    private String name;

    private String displayName;

    private String description;

    private Byte invited;

    private String url;

    private String website;
}
