package org.unibl.etf.pisio.trellofa.models;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class Invitation
{
        private Integer id;

        private Integer idBoard;

        private Integer idMember;

        private String sender;

        private String boardName;
}
