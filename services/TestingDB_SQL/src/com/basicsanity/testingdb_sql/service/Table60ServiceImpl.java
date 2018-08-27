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

import com.basicsanity.testingdb_sql.Table60;
import com.basicsanity.testingdb_sql.Table60Id;


/**
 * ServiceImpl object for domain model class Table60.
 *
 * @see Table60
 */
@Service("TestingDB_SQL.Table60Service")
@Validated
public class Table60ServiceImpl implements Table60Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table60ServiceImpl.class);


    @Autowired
    @Qualifier("TestingDB_SQL.Table60Dao")
    private WMGenericDao<Table60, Table60Id> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table60, Table60Id> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public Table60 create(Table60 table60) {
        LOGGER.debug("Creating a new Table60 with information: {}", table60);

        Table60 table60Created = this.wmGenericDao.create(table60);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(table60Created);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Table60 getById(Table60Id table60Id) {
        LOGGER.debug("Finding Table60 by id: {}", table60Id);
        return this.wmGenericDao.findById(table60Id);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Table60 findById(Table60Id table60Id) {
        LOGGER.debug("Finding Table60 by id: {}", table60Id);
        try {
            return this.wmGenericDao.findById(table60Id);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Table60 found with id: {}", table60Id, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public List<Table60> findByMultipleIds(List<Table60Id> table60Ids, boolean orderedReturn) {
        LOGGER.debug("Finding Table60s by ids: {}", table60Ids);

        return this.wmGenericDao.findByMultipleIds(table60Ids, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TestingDB_SQLTransactionManager")
    @Override
    public Table60 update(Table60 table60) {
        LOGGER.debug("Updating Table60 with information: {}", table60);

        this.wmGenericDao.update(table60);
        this.wmGenericDao.refresh(table60);

        return table60;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public Table60 delete(Table60Id table60Id) {
        LOGGER.debug("Deleting Table60 with id: {}", table60Id);
        Table60 deleted = this.wmGenericDao.findById(table60Id);
        if (deleted == null) {
            LOGGER.debug("No Table60 found with id: {}", table60Id);
            throw new EntityNotFoundException(String.valueOf(table60Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public void delete(Table60 table60) {
        LOGGER.debug("Deleting Table60 with {}", table60);
        this.wmGenericDao.delete(table60);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<Table60> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table60s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<Table60> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table60s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table Table60 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table Table60 to {} format", options.getExportType());
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