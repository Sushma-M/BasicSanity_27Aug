/*Copyright (c) 2018-2019 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.basicsanity.testingdb_sql;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ManyToOneParent generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`ManyToOne Parent`")
public class ManyToOneParent implements Serializable {

    private String pkColumn;
    private String name;
    private String description;

    @Id
    @Column(name = "`PK Column`", nullable = false, length = 255)
    public String getPkColumn() {
        return this.pkColumn;
    }

    public void setPkColumn(String pkColumn) {
        this.pkColumn = pkColumn;
    }

    @Column(name = "`Name`", nullable = true, length = 255)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "`Description`", nullable = true, length = 2147483647)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ManyToOneParent)) return false;
        final ManyToOneParent manyToOneParent = (ManyToOneParent) o;
        return Objects.equals(getPkColumn(), manyToOneParent.getPkColumn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPkColumn());
    }
}