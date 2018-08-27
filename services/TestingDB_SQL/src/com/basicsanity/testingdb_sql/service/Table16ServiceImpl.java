/*Copyright (c) 2018-2019 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.basicsanity.testingdb_sql.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.basicsanity.testingdb_sql.Table16;
import com.basicsanity.testingdb_sql.Table16Id;


/**
 * ServiceImpl object for domain model class Table16.
 *
 * @see Table16
 */
@Service("TestingDB_SQL.Table16Service")
@Validated
public class Table16ServiceImpl implements Table16Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table16ServiceImpl.class);


    @Autowired
    @Qualifier("TestingDB_SQL.Table16Dao")
    private WMGenericDao<Table16, Table16Id> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table16, Table16Id> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public Table16 create(Table16 table16) {
        LOGGER.debug("Creating a new Table16 with information: {}", table16);

        Table16 table16Created = this.wmGenericDao.create(table16);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(table16Created);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Table16 getById(Table16Id table16Id) {
        LOGGER.debug("Finding Table16 by id: {}", table16Id);
        return this.wmGenericDao.findById(table16Id);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Table16 findById(Table16Id table16Id) {
        LOGGER.debug("Finding Table16 by id: {}", table16Id);
        try {
            return this.wmGenericDao.findById(table16Id);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Table16 found with id: {}", table16Id, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public List<Table16> findByMultipleIds(List<Table16Id> table16Ids, boolean orderedReturn) {
        LOGGER.debug("Finding Table16s by ids: {}", table16Ids);

        return this.wmGenericDao.findByMultipleIds(table16Ids, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TestingDB_SQLTransactionManager")
    @Override
    public Table16 update(Table16 table16) {
        LOGGER.debug("Updating Table16 with information: {}", table16);

        this.wmGenericDao.update(table16);
        this.wmGenericDao.refresh(table16);

        return table16;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public Table16 delete(Table16Id table16Id) {
        LOGGER.debug("Deleting Table16 with id: {}", table16Id);
        Table16 deleted = this.wmGenericDao.findById(table16Id);
        if (deleted == null) {
            LOGGER.debug("No Table16 found with id: {}", table16Id);
            throw new EntityNotFoundException(String.valueOf(table16Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public void delete(Table16 table16) {
        LOGGER.debug("Deleting Table16 with {}", table16);
        this.wmGenericDao.delete(table16);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<Table16> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table16s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<Table16> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table16s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table Table16 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table Table16 to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}