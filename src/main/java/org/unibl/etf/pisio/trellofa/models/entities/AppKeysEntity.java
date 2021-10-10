package org.unibl.etf.pisio.trellofa.models.entities;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "app_keys")
public class AppKeysEntity
{
    @Id
    @Column(name = "`key`", nullable = false)
    private String key;
}
