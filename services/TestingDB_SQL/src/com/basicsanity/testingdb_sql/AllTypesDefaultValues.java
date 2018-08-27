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

/**
 * AllTypesDefaultValues generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`All Types Default Values`")
public class AllTypesDefaultValues implements Serializable {

    private Integer allTypesId;
    private Integer integerColumn;
    private Long longColumn;
    private Short shortColumn;
    private Float floatColumn;
    private Double doubleColumn;
    private BigInteger bigIntegerColumn;
    private BigDecimal bigDecimalColumn;
    private Byte byteColumn;
    private String stringColumn;
    private String characterColumn;
    private String textColumn;
    private String clobColumn;
    private Date dateColumn;
    private Time timeColumn;
    private LocalDateTime datetimeColumn;
    private Boolean booleanColumn = true;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`All Types ID`", nullable = false, scale = 0, precision = 10)
    public Integer getAllTypesId() {
        return this.allTypesId;
    }

    public void setAllTypesId(Integer allTypesId) {
        this.allTypesId = allTypesId;
    }

    @Column(name = "`Integer Column`", nullable = true, scale = 0, precision = 10)
    public Integer getIntegerColumn() {
        return this.integerColumn;
    }

    public void setIntegerColumn(Integer integerColumn) {
        this.integerColumn = integerColumn;
    }

    @Column(name = "`Long Column`", nullable = true, scale = 0, precision = 17)
    public Long getLongColumn() {
        return this.longColumn;
    }

    public void setLongColumn(Long longColumn) {
        this.longColumn = longColumn;
    }

    @Column(name = "`Short Column`", nullable = true, scale = 0, precision = 4)
    public Short getShortColumn() {
        return this.shortColumn;
    }

    public void setShortColumn(Short shortColumn) {
        this.shortColumn = shortColumn;
    }

    @Column(name = "`Float Column`", nullable = true, scale = 4, precision = 6)
    public Float getFloatColumn() {
        return this.floatColumn;
    }

    public void setFloatColumn(Float floatColumn) {
        this.floatColumn = floatColumn;
    }

    @Column(name = "`Double Column`", nullable = true, scale = 5, precision = 14)
    public Double getDoubleColumn() {
        return this.doubleColumn;
    }

    public void setDoubleColumn(Double doubleColumn) {
        this.doubleColumn = doubleColumn;
    }

    @Column(name = "`BigInteger Column`", nullable = true, scale = 0, precision = 38)
    public BigInteger getBigIntegerColumn() {
        return this.bigIntegerColumn;
    }

    public void setBigIntegerColumn(BigInteger bigIntegerColumn) {
        this.bigIntegerColumn = bigIntegerColumn;
    }

    @Column(name = "`BigDecimal Column`", nullable = true, scale = 16, precision = 38)
    public BigDecimal getBigDecimalColumn() {
        return this.bigDecimalColumn;
    }

    public void setBigDecimalColumn(BigDecimal bigDecimalColumn) {
        this.bigDecimalColumn = bigDecimalColumn;
    }

    @Column(name = "`Byte Column`", nullable = true, scale = 0, precision = 2)
    public Byte getByteColumn() {
        return this.byteColumn;
    }

    public void setByteColumn(Byte byteColumn) {
        this.byteColumn = byteColumn;
    }

    @Column(name = "`String Column`", nullable = true, length = 2147483647)
    public String getStringColumn() {
        return this.stringColumn;
    }

    public void setStringColumn(String stringColumn) {
        this.stringColumn = stringColumn;
    }

    @Column(name = "`Character Column`", nullable = true, length = 1)
    public String getCharacterColumn() {
        return this.characterColumn;
    }

    public void setCharacterColumn(String characterColumn) {
        this.characterColumn = characterColumn;
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

    @Column(name = "`Boolean Column`", nullable = true)
    public Boolean getBooleanColumn() {
        return this.booleanColumn;
    }

    public void setBooleanColumn(Boolean booleanColumn) {
        this.booleanColumn = booleanColumn;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AllTypesDefaultValues)) return false;
        final AllTypesDefaultValues allTypesDefaultValues = (AllTypesDefaultValues) o;
        return Objects.equals(getAllTypesId(), allTypesDefaultValues.getAllTypesId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAllTypesId());
    }
}