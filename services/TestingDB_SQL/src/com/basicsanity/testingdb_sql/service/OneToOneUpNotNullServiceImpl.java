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

import com.basicsanity.testingdb_sql.OneToOneUpNotNull;


/**
 * ServiceImpl object for domain model class OneToOneUpNotNull.
 *
 * @see OneToOneUpNotNull
 */
@Service("TestingDB_SQL.OneToOneUpNotNullService")
@Validated
public class OneToOneUpNotNullServiceImpl implements OneToOneUpNotNullService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OneToOneUpNotNullServiceImpl.class);


    @Autowired
    @Qualifier("TestingDB_SQL.OneToOneUpNotNullDao")
    private WMGenericDao<OneToOneUpNotNull, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<OneToOneUpNotNull, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public OneToOneUpNotNull create(OneToOneUpNotNull oneToOneUpNotNull) {
        LOGGER.debug("Creating a new OneToOneUpNotNull with information: {}", oneToOneUpNotNull);

        OneToOneUpNotNull oneToOneUpNotNullCreated = this.wmGenericDao.create(oneToOneUpNotNull);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(oneToOneUpNotNullCreated);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public OneToOneUpNotNull getById(Integer onetooneupnotnullId) {
        LOGGER.debug("Finding OneToOneUpNotNull by id: {}", onetooneupnotnullId);
        return this.wmGenericDao.findById(onetooneupnotnullId);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public OneToOneUpNotNull findById(Integer onetooneupnotnullId) {
        LOGGER.debug("Finding OneToOneUpNotNull by id: {}", onetooneupnotnullId);
        try {
            return this.wmGenericDao.findById(onetooneupnotnullId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No OneToOneUpNotNull found with id: {}", onetooneupnotnullId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public List<OneToOneUpNotNull> findByMultipleIds(List<Integer> onetooneupnotnullIds, boolean orderedReturn) {
        LOGGER.debug("Finding OneToOneUpNotNulls by ids: {}", onetooneupnotnullIds);

        return this.wmGenericDao.findByMultipleIds(onetooneupnotnullIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TestingDB_SQLTransactionManager")
    @Override
    public OneToOneUpNotNull update(OneToOneUpNotNull oneToOneUpNotNull) {
        LOGGER.debug("Updating OneToOneUpNotNull with information: {}", oneToOneUpNotNull);

        this.wmGenericDao.update(oneToOneUpNotNull);
        this.wmGenericDao.refresh(oneToOneUpNotNull);

        return oneToOneUpNotNull;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public OneToOneUpNotNull delete(Integer onetooneupnotnullId) {
        LOGGER.debug("Deleting OneToOneUpNotNull with id: {}", onetooneupnotnullId);
        OneToOneUpNotNull deleted = this.wmGenericDao.findById(onetooneupnotnullId);
        if (deleted == null) {
            LOGGER.debug("No OneToOneUpNotNull found with id: {}", onetooneupnotnullId);
            throw new EntityNotFoundException(String.valueOf(onetooneupnotnullId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public void delete(OneToOneUpNotNull oneToOneUpNotNull) {
        LOGGER.debug("Deleting OneToOneUpNotNull with {}", oneToOneUpNotNull);
        this.wmGenericDao.delete(oneToOneUpNotNull);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<OneToOneUpNotNull> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all OneToOneUpNotNulls");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<OneToOneUpNotNull> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all OneToOneUpNotNulls");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table OneToOneUpNotNull to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table OneToOneUpNotNull to {} format", options.getExportType());
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