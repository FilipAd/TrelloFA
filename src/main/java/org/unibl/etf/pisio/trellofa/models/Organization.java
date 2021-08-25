package org.unibl.etf.pisio.trellofa.models;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class Organization
{

    private Integer id;

    private String name;

    private String displayName;

    private String desc;

    private Byte invited;

    private String url;

    private String website;
}
