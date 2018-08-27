/*Copyright (c) 2018-2019 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.basicsanity.testingdb_sql;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Table71 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TABLE71`")
public class Table71 implements Serializable {

    private Integer id;
    private String column2;
    private Date column3;
    private Table70 table70;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`COLUMN2`", nullable = true, length = 255)
    public String getColumn2() {
        return this.column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    @Column(name = "`COLUMN3`", nullable = true)
    public Date getColumn3() {
        return this.column3;
    }

    public void setColumn3(Date column3) {
        this.column3 = column3;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`COLUMN3`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_TABLE70_TO_TABLE71_IDdMvJi`"))
    @Fetch(FetchMode.JOIN)
    public Table70 getTable70() {
        return this.table70;
    }

    public void setTable70(Table70 table70) {
        if(table70 != null) {
            this.column3 = table70.getId();
        }

        this.table70 = table70;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table71)) return false;
        final Table71 table71 = (Table71) o;
        return Objects.equals(getId(), table71.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}