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

import com.basicsanity.testingdb_sql.VirtualTable;
import com.basicsanity.testingdb_sql.VirtualTableId;


/**
 * ServiceImpl object for domain model class VirtualTable.
 *
 * @see VirtualTable
 */
@Service("TestingDB_SQL.VirtualTableService")
@Validated
public class VirtualTableServiceImpl implements VirtualTableService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VirtualTableServiceImpl.class);


    @Autowired
    @Qualifier("TestingDB_SQL.VirtualTableDao")
    private WMGenericDao<VirtualTable, VirtualTableId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<VirtualTable, VirtualTableId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public VirtualTable create(VirtualTable virtualTable) {
        LOGGER.debug("Creating a new VirtualTable with information: {}", virtualTable);

        VirtualTable virtualTableCreated = this.wmGenericDao.create(virtualTable);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(virtualTableCreated);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public VirtualTable getById(VirtualTableId virtualtableId) {
        LOGGER.debug("Finding VirtualTable by id: {}", virtualtableId);
        return this.wmGenericDao.findById(virtualtableId);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public VirtualTable findById(VirtualTableId virtualtableId) {
        LOGGER.debug("Finding VirtualTable by id: {}", virtualtableId);
        try {
            return this.wmGenericDao.findById(virtualtableId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No VirtualTable found with id: {}", virtualtableId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public List<VirtualTable> findByMultipleIds(List<VirtualTableId> virtualtableIds, boolean orderedReturn) {
        LOGGER.debug("Finding VirtualTables by ids: {}", virtualtableIds);

        return this.wmGenericDao.findByMultipleIds(virtualtableIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TestingDB_SQLTransactionManager")
    @Override
    public VirtualTable update(VirtualTable virtualTable) {
        LOGGER.debug("Updating VirtualTable with information: {}", virtualTable);

        this.wmGenericDao.update(virtualTable);
        this.wmGenericDao.refresh(virtualTable);

        return virtualTable;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public VirtualTable delete(VirtualTableId virtualtableId) {
        LOGGER.debug("Deleting VirtualTable with id: {}", virtualtableId);
        VirtualTable deleted = this.wmGenericDao.findById(virtualtableId);
        if (deleted == null) {
            LOGGER.debug("No VirtualTable found with id: {}", virtualtableId);
            throw new EntityNotFoundException(String.valueOf(virtualtableId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public void delete(VirtualTable virtualTable) {
        LOGGER.debug("Deleting VirtualTable with {}", virtualTable);
        this.wmGenericDao.delete(virtualTable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<VirtualTable> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all VirtualTables");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<VirtualTable> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all VirtualTables");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table VirtualTable to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table VirtualTable to {} format", options.getExportType());
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