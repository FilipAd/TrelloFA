package org.unibl.etf.pisio.trellofa.models;

import lombok.Data;

@Data
public class SingleList extends List
{
    java.util.List<Card> cards;
}
