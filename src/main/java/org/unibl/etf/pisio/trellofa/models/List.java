package org.unibl.etf.pisio.trellofa.models;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Data
public class List
{
private Integer id;

    private String name;

    private Byte closed;

    private Integer pos;

    private Byte subscribed;

    private Integer idBoard;

    private java.util.List<Card> cards;

}
