/*Copyright (c) 2018-2019 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.basicsanity.testingdb_sql;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class Table16Id implements Serializable {

    private Integer column2;
    private String column3;

    public Integer getColumn2() {
        return this.column2;
    }

    public void setColumn2(Integer column2) {
        this.column2 = column2;
    }

    public String getColumn3() {
        return this.column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table16)) return false;
        final Table16 table16 = (Table16) o;
        return Objects.equals(getColumn2(), table16.getColumn2()) &&
                Objects.equals(getColumn3(), table16.getColumn3());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColumn2(),
                getColumn3());
    }
}