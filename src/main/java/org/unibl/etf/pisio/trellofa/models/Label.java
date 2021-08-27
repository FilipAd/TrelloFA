package org.unibl.etf.pisio.trellofa.models;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class Label
{

    private Integer id;

    private String color;

    private String name;

    private String text;

    private Integer idCard;
}
