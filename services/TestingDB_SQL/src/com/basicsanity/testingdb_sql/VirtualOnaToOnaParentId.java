/*Copyright (c) 2018-2019 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.basicsanity.testingdb_sql;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class VirtualOnaToOnaParentId implements Serializable {

    private String column3;
    private Integer column2;

    public String getColumn3() {
        return this.column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    public Integer getColumn2() {
        return this.column2;
    }

    public void setColumn2(Integer column2) {
        this.column2 = column2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VirtualOnaToOnaParent)) return false;
        final VirtualOnaToOnaParent virtualOnaToOnaParent = (VirtualOnaToOnaParent) o;
        return Objects.equals(getColumn3(), virtualOnaToOnaParent.getColumn3()) &&
                Objects.equals(getColumn2(), virtualOnaToOnaParent.getColumn2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColumn3(),
                getColumn2());
    }
}