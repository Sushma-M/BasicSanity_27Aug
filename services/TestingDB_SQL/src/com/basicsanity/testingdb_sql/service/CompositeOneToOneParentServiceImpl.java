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

import com.basicsanity.testingdb_sql.CompositeOneToOneParent;
import com.basicsanity.testingdb_sql.CompositeOneToOneParentId;


/**
 * ServiceImpl object for domain model class CompositeOneToOneParent.
 *
 * @see CompositeOneToOneParent
 */
@Service("TestingDB_SQL.CompositeOneToOneParentService")
@Validated
public class CompositeOneToOneParentServiceImpl implements CompositeOneToOneParentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompositeOneToOneParentServiceImpl.class);


    @Autowired
    @Qualifier("TestingDB_SQL.CompositeOneToOneParentDao")
    private WMGenericDao<CompositeOneToOneParent, CompositeOneToOneParentId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<CompositeOneToOneParent, CompositeOneToOneParentId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public CompositeOneToOneParent create(CompositeOneToOneParent compositeOneToOneParent) {
        LOGGER.debug("Creating a new CompositeOneToOneParent with information: {}", compositeOneToOneParent);

        CompositeOneToOneParent compositeOneToOneParentCreated = this.wmGenericDao.create(compositeOneToOneParent);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(compositeOneToOneParentCreated);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public CompositeOneToOneParent getById(CompositeOneToOneParentId compositeonetooneparentId) {
        LOGGER.debug("Finding CompositeOneToOneParent by id: {}", compositeonetooneparentId);
        return this.wmGenericDao.findById(compositeonetooneparentId);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public CompositeOneToOneParent findById(CompositeOneToOneParentId compositeonetooneparentId) {
        LOGGER.debug("Finding CompositeOneToOneParent by id: {}", compositeonetooneparentId);
        try {
            return this.wmGenericDao.findById(compositeonetooneparentId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No CompositeOneToOneParent found with id: {}", compositeonetooneparentId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public List<CompositeOneToOneParent> findByMultipleIds(List<CompositeOneToOneParentId> compositeonetooneparentIds, boolean orderedReturn) {
        LOGGER.debug("Finding CompositeOneToOneParents by ids: {}", compositeonetooneparentIds);

        return this.wmGenericDao.findByMultipleIds(compositeonetooneparentIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TestingDB_SQLTransactionManager")
    @Override
    public CompositeOneToOneParent update(CompositeOneToOneParent compositeOneToOneParent) {
        LOGGER.debug("Updating CompositeOneToOneParent with information: {}", compositeOneToOneParent);

        this.wmGenericDao.update(compositeOneToOneParent);
        this.wmGenericDao.refresh(compositeOneToOneParent);

        return compositeOneToOneParent;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public CompositeOneToOneParent delete(CompositeOneToOneParentId compositeonetooneparentId) {
        LOGGER.debug("Deleting CompositeOneToOneParent with id: {}", compositeonetooneparentId);
        CompositeOneToOneParent deleted = this.wmGenericDao.findById(compositeonetooneparentId);
        if (deleted == null) {
            LOGGER.debug("No CompositeOneToOneParent found with id: {}", compositeonetooneparentId);
            throw new EntityNotFoundException(String.valueOf(compositeonetooneparentId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public void delete(CompositeOneToOneParent compositeOneToOneParent) {
        LOGGER.debug("Deleting CompositeOneToOneParent with {}", compositeOneToOneParent);
        this.wmGenericDao.delete(compositeOneToOneParent);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<CompositeOneToOneParent> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all CompositeOneToOneParents");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<CompositeOneToOneParent> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all CompositeOneToOneParents");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table CompositeOneToOneParent to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table CompositeOneToOneParent to {} format", options.getExportType());
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