/*Copyright (c) 2018-2019 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.basicsanity.testingdb_sql;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class CompositePkToOneNonPkParentId implements Serializable {

    private Date createdDate;
    private Integer compositeId;

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getCompositeId() {
        return this.compositeId;
    }

    public void setCompositeId(Integer compositeId) {
        this.compositeId = compositeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositePkToOneNonPkParent)) return false;
        final CompositePkToOneNonPkParent compositePkToOneNonPkParent = (CompositePkToOneNonPkParent) o;
        return Objects.equals(getCreatedDate(), compositePkToOneNonPkParent.getCreatedDate()) &&
                Objects.equals(getCompositeId(), compositePkToOneNonPkParent.getCompositeId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCreatedDate(),
                getCompositeId());
    }
}