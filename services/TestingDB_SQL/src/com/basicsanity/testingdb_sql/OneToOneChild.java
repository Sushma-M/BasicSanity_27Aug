/*Copyright (c) 2018-2019 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.basicsanity.testingdb_sql;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * OneToOneChild generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`One To One Child`")
public class OneToOneChild implements Serializable {

    private String id;
    private String column2;
    private String column3;
    private OneToOneParent oneToOneParent;

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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`ID`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_One_To_One_Child_TO_OOaNqo`"))
    @Fetch(FetchMode.JOIN)
    public OneToOneParent getOneToOneParent() {
        return this.oneToOneParent;
    }

    public void setOneToOneParent(OneToOneParent oneToOneParent) {
        if(oneToOneParent != null) {
            this.id = oneToOneParent.getId();
        }

        this.oneToOneParent = oneToOneParent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OneToOneChild)) return false;
        final OneToOneChild oneToOneChild = (OneToOneChild) o;
        return Objects.equals(getId(), oneToOneChild.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}