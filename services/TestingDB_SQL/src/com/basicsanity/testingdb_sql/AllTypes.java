/*Copyright (c) 2018-2019 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.basicsanity.testingdb_sql;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * AllTypes generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`All types`")
public class AllTypes implements Serializable {

    private Integer id;
    private Integer integerColumn;
    private Byte byteColumn;
    private Short shortColumn;
    private Long longColumn;
    private BigInteger bigIntegerColumn;
    private Float floatColumn;
    private Double doubleColumn;
    private BigDecimal bigDecimalColumn;
    private String stringColumn;
    private String textColumn;
    private String clobColumn;
    private String characterColumn;
    private Boolean booleanColumn;
    private Date dateColumn;
    private Time timeColumn;
    private LocalDateTime datetimeColumn;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] blobColumn;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`Integer Column`", nullable = true, scale = 0, precision = 10)
    public Integer getIntegerColumn() {
        return this.integerColumn;
    }

    public void setIntegerColumn(Integer integerColumn) {
        this.integerColumn = integerColumn;
    }

    @Column(name = "`Byte Column`", nullable = true, scale = 0, precision = 2)
    public Byte getByteColumn() {
        return this.byteColumn;
    }

    public void setByteColumn(Byte byteColumn) {
        this.byteColumn = byteColumn;
    }

    @Column(name = "`Short Column`", nullable = true, scale = 0, precision = 4)
    public Short getShortColumn() {
        return this.shortColumn;
    }

    public void setShortColumn(Short shortColumn) {
        this.shortColumn = shortColumn;
    }

    @Column(name = "`Long Column`", nullable = true, scale = 0, precision = 15)
    public Long getLongColumn() {
        return this.longColumn;
    }

    public void setLongColumn(Long longColumn) {
        this.longColumn = longColumn;
    }

    @Column(name = "`BigInteger Column`", nullable = true, scale = 0, precision = 32)
    public BigInteger getBigIntegerColumn() {
        return this.bigIntegerColumn;
    }

    public void setBigIntegerColumn(BigInteger bigIntegerColumn) {
        this.bigIntegerColumn = bigIntegerColumn;
    }

    @Column(name = "`Float Column`", nullable = true, scale = 4, precision = 6)
    public Float getFloatColumn() {
        return this.floatColumn;
    }

    public void setFloatColumn(Float floatColumn) {
        this.floatColumn = floatColumn;
    }

    @Column(name = "`Double Column`", nullable = true, scale = 4, precision = 15)
    public Double getDoubleColumn() {
        return this.doubleColumn;
    }

    public void setDoubleColumn(Double doubleColumn) {
        this.doubleColumn = doubleColumn;
    }

    @Column(name = "`BigDecimal Column`", nullable = true, scale = 16, precision = 38)
    public BigDecimal getBigDecimalColumn() {
        return this.bigDecimalColumn;
    }

    public void setBigDecimalColumn(BigDecimal bigDecimalColumn) {
        this.bigDecimalColumn = bigDecimalColumn;
    }

    @Column(name = "`String Column`", nullable = true, length = 70)
    public String getStringColumn() {
        return this.stringColumn;
    }

    public void setStringColumn(String stringColumn) {
        this.stringColumn = stringColumn;
    }

    @Column(name = "`Text Column`", nullable = true, length = 2147483647)
    public String getTextColumn() {
        return this.textColumn;
    }

    public void setTextColumn(String textColumn) {
        this.textColumn = textColumn;
    }

    @Column(name = "`Clob Column`", nullable = true, length = 2147483647)
    public String getClobColumn() {
        return this.clobColumn;
    }

    public void setClobColumn(String clobColumn) {
        this.clobColumn = clobColumn;
    }

    @Column(name = "`Character Column`", nullable = true, length = 1)
    public String getCharacterColumn() {
        return this.characterColumn;
    }

    public void setCharacterColumn(String characterColumn) {
        this.characterColumn = characterColumn;
    }

    @Column(name = "`Boolean Column`", nullable = true)
    public Boolean getBooleanColumn() {
        return this.booleanColumn;
    }

    public void setBooleanColumn(Boolean booleanColumn) {
        this.booleanColumn = booleanColumn;
    }

    @Column(name = "`Date Column`", nullable = true)
    public Date getDateColumn() {
        return this.dateColumn;
    }

    public void setDateColumn(Date dateColumn) {
        this.dateColumn = dateColumn;
    }

    @Column(name = "`Time Column`", nullable = true)
    public Time getTimeColumn() {
        return this.timeColumn;
    }

    public void setTimeColumn(Time timeColumn) {
        this.timeColumn = timeColumn;
    }

    @Column(name = "`Datetime Column`", nullable = true)
    public LocalDateTime getDatetimeColumn() {
        return this.datetimeColumn;
    }

    public void setDatetimeColumn(LocalDateTime datetimeColumn) {
        this.datetimeColumn = datetimeColumn;
    }

    @Column(name = "`Blob Column`", nullable = true)
    public byte[] getBlobColumn() {
        return this.blobColumn;
    }

    public void setBlobColumn(byte[] blobColumn) {
        this.blobColumn = blobColumn;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AllTypes)) return false;
        final AllTypes allTypes = (AllTypes) o;
        return Objects.equals(getId(), allTypes.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}