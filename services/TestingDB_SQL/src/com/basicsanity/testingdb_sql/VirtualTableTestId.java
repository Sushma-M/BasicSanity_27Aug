/*Copyright (c) 2018-2019 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.basicsanity.testingdb_sql;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class VirtualTableTestId implements Serializable {

    private String id;
    private String column3;
    private String column4;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColumn3() {
        return this.column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    public String getColumn4() {
        return this.column4;
    }

    public void setColumn4(String column4) {
        this.column4 = column4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VirtualTableTest)) return false;
        final VirtualTableTest virtualTableTest = (VirtualTableTest) o;
        return Objects.equals(getId(), virtualTableTest.getId()) &&
                Objects.equals(getColumn3(), virtualTableTest.getColumn3()) &&
                Objects.equals(getColumn4(), virtualTableTest.getColumn4());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getColumn3(),
                getColumn4());
    }
}