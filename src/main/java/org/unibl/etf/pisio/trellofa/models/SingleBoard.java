package org.unibl.etf.pisio.trellofa.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SingleBoard extends Board
{
    private List<org.unibl.etf.pisio.trellofa.models.List> lists;
    private List<BoardHasMembers> boardHasMembers;
}
