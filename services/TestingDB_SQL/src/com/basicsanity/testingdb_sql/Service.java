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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Service generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`Service`")
public class Service implements Serializable {

    private Integer id;
    private String column3;
    private String column4;
    private Integer column2;
    private Users users;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`COLUMN3`", nullable = true, length = 255)
    public String getColumn3() {
        return this.column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    @Column(name = "`COLUMN4`", nullable = true, length = 255)
    public String getColumn4() {
        return this.column4;
    }

    public void setColumn4(String column4) {
        this.column4 = column4;
    }

    @Column(name = "`COLUMN2`", nullable = true, scale = 0, precision = 10)
    public Integer getColumn2() {
        return this.column2;
    }

    public void setColumn2(Integer column2) {
        this.column2 = column2;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`COLUMN2`", referencedColumnName = "`Users`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_Service_TO_Users_COLUR1xxt`"))
    @Fetch(FetchMode.JOIN)
    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        if(users != null) {
            this.column2 = users.getUsers();
        }

        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Service)) return false;
        final Service service = (Service) o;
        return Objects.equals(getId(), service.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}