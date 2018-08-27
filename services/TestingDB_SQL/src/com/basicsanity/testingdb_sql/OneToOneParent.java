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
import javax.persistence.UniqueConstraint;

/**
 * OneToOneParent generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`One to One Parent`", uniqueConstraints = {
            @UniqueConstraint(name = "`UK_One_to_One_Parent_ID_uBbJ5`", columnNames = {"`ID`", "`COLUMN2`"})})
public class OneToOneParent implements Serializable {

    private String id;
    private String column2;
    private String column3;

    @Id
    @Column(name = "`ID`", nullable = false, length = 255)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "`COLUMN2`", nullable = true, length = 255)
    public String getColumn2() {
        return this.column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    @Column(name = "`COLUMN3`", nullable = true, length = 255)
    public String getColumn3() {
        return this.column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OneToOneParent)) return false;
        final OneToOneParent oneToOneParent = (OneToOneParent) o;
        return Objects.equals(getId(), oneToOneParent.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}