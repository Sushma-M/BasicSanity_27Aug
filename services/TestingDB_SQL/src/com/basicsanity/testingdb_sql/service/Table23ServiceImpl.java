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

import com.basicsanity.testingdb_sql.Table23;


/**
 * ServiceImpl object for domain model class Table23.
 *
 * @see Table23
 */
@Service("TestingDB_SQL.Table23Service")
@Validated
public class Table23ServiceImpl implements Table23Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table23ServiceImpl.class);


    @Autowired
    @Qualifier("TestingDB_SQL.Table23Dao")
    private WMGenericDao<Table23, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table23, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public Table23 create(Table23 table23) {
        LOGGER.debug("Creating a new Table23 with information: {}", table23);

        Table23 table23Created = this.wmGenericDao.create(table23);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(table23Created);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Table23 getById(Integer table23Id) {
        LOGGER.debug("Finding Table23 by id: {}", table23Id);
        return this.wmGenericDao.findById(table23Id);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Table23 findById(Integer table23Id) {
        LOGGER.debug("Finding Table23 by id: {}", table23Id);
        try {
            return this.wmGenericDao.findById(table23Id);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Table23 found with id: {}", table23Id, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public List<Table23> findByMultipleIds(List<Integer> table23Ids, boolean orderedReturn) {
        LOGGER.debug("Finding Table23s by ids: {}", table23Ids);

        return this.wmGenericDao.findByMultipleIds(table23Ids, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TestingDB_SQLTransactionManager")
    @Override
    public Table23 update(Table23 table23) {
        LOGGER.debug("Updating Table23 with information: {}", table23);

        this.wmGenericDao.update(table23);
        this.wmGenericDao.refresh(table23);

        return table23;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public Table23 delete(Integer table23Id) {
        LOGGER.debug("Deleting Table23 with id: {}", table23Id);
        Table23 deleted = this.wmGenericDao.findById(table23Id);
        if (deleted == null) {
            LOGGER.debug("No Table23 found with id: {}", table23Id);
            throw new EntityNotFoundException(String.valueOf(table23Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public void delete(Table23 table23) {
        LOGGER.debug("Deleting Table23 with {}", table23);
        this.wmGenericDao.delete(table23);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<Table23> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table23s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<Table23> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table23s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table Table23 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table Table23 to {} format", options.getExportType());
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