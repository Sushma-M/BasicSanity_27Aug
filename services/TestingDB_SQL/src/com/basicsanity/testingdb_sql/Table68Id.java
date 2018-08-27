/*Copyright (c) 2018-2019 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.basicsanity.testingdb_sql;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class Table68Id implements Serializable {

    private String column2;
    private String column3;
    private Integer column4;

    public String getColumn2() {
        return this.column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    public String getColumn3() {
        return this.column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    public Integer getColumn4() {
        return this.column4;
    }

    public void setColumn4(Integer column4) {
        this.column4 = column4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table68)) return false;
        final Table68 table68 = (Table68) o;
        return Objects.equals(getColumn2(), table68.getColumn2()) &&
                Objects.equals(getColumn3(), table68.getColumn3()) &&
                Objects.equals(getColumn4(), table68.getColumn4());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColumn2(),
                getColumn3(),
                getColumn4());
    }
}