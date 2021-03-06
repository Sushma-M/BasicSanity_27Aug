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
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * VirtualOneToOneParent generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`Virtual One to One Parent`", uniqueConstraints = {
            @UniqueConstraint(name = "`UK_Virtual_One_to_One_PaSAN27`", columnNames = {"`Virtual ID`"})})
@IdClass(VirtualOneToOneParentId.class)
public class VirtualOneToOneParent implements Serializable {

    private Integer virtualId;
    private String virtualName;
    private String virtualDesc;

    @Id
    @Column(name = "`Virtual ID`", nullable = true, scale = 0, precision = 10)
    public Integer getVirtualId() {
        return this.virtualId;
    }

    public void setVirtualId(Integer virtualId) {
        this.virtualId = virtualId;
    }

    @Id
    @Column(name = "`Virtual Name`", nullable = true, length = 20)
    public String getVirtualName() {
        return this.virtualName;
    }

    public void setVirtualName(String virtualName) {
        this.virtualName = virtualName;
    }

    @Id
    @Column(name = "`Virtual Desc`", nullable = true, length = 100)
    public String getVirtualDesc() {
        return this.virtualDesc;
    }

    public void setVirtualDesc(String virtualDesc) {
        this.virtualDesc = virtualDesc;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VirtualOneToOneParent)) return false;
        final VirtualOneToOneParent virtualOneToOneParent = (VirtualOneToOneParent) o;
        return Objects.equals(getVirtualId(), virtualOneToOneParent.getVirtualId()) &&
                Objects.equals(getVirtualName(), virtualOneToOneParent.getVirtualName()) &&
                Objects.equals(getVirtualDesc(), virtualOneToOneParent.getVirtualDesc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVirtualId(),
                getVirtualName(),
                getVirtualDesc());
    }
}