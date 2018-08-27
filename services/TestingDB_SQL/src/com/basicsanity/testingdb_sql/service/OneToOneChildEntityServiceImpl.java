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

import com.basicsanity.testingdb_sql.OneToOneChildEntity;


/**
 * ServiceImpl object for domain model class OneToOneChildEntity.
 *
 * @see OneToOneChildEntity
 */
@Service("TestingDB_SQL.OneToOneChildEntityService")
@Validated
public class OneToOneChildEntityServiceImpl implements OneToOneChildEntityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OneToOneChildEntityServiceImpl.class);


    @Autowired
    @Qualifier("TestingDB_SQL.OneToOneChildEntityDao")
    private WMGenericDao<OneToOneChildEntity, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<OneToOneChildEntity, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public OneToOneChildEntity create(OneToOneChildEntity oneToOneChildEntity) {
        LOGGER.debug("Creating a new OneToOneChildEntity with information: {}", oneToOneChildEntity);

        OneToOneChildEntity oneToOneChildEntityCreated = this.wmGenericDao.create(oneToOneChildEntity);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(oneToOneChildEntityCreated);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public OneToOneChildEntity getById(Integer onetoonechildentityId) {
        LOGGER.debug("Finding OneToOneChildEntity by id: {}", onetoonechildentityId);
        return this.wmGenericDao.findById(onetoonechildentityId);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public OneToOneChildEntity findById(Integer onetoonechildentityId) {
        LOGGER.debug("Finding OneToOneChildEntity by id: {}", onetoonechildentityId);
        try {
            return this.wmGenericDao.findById(onetoonechildentityId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No OneToOneChildEntity found with id: {}", onetoonechildentityId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public List<OneToOneChildEntity> findByMultipleIds(List<Integer> onetoonechildentityIds, boolean orderedReturn) {
        LOGGER.debug("Finding OneToOneChildEntities by ids: {}", onetoonechildentityIds);

        return this.wmGenericDao.findByMultipleIds(onetoonechildentityIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TestingDB_SQLTransactionManager")
    @Override
    public OneToOneChildEntity update(OneToOneChildEntity oneToOneChildEntity) {
        LOGGER.debug("Updating OneToOneChildEntity with information: {}", oneToOneChildEntity);

        this.wmGenericDao.update(oneToOneChildEntity);
        this.wmGenericDao.refresh(oneToOneChildEntity);

        return oneToOneChildEntity;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public OneToOneChildEntity delete(Integer onetoonechildentityId) {
        LOGGER.debug("Deleting OneToOneChildEntity with id: {}", onetoonechildentityId);
        OneToOneChildEntity deleted = this.wmGenericDao.findById(onetoonechildentityId);
        if (deleted == null) {
            LOGGER.debug("No OneToOneChildEntity found with id: {}", onetoonechildentityId);
            throw new EntityNotFoundException(String.valueOf(onetoonechildentityId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public void delete(OneToOneChildEntity oneToOneChildEntity) {
        LOGGER.debug("Deleting OneToOneChildEntity with {}", oneToOneChildEntity);
        this.wmGenericDao.delete(oneToOneChildEntity);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<OneToOneChildEntity> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all OneToOneChildEntities");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<OneToOneChildEntity> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all OneToOneChildEntities");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table OneToOneChildEntity to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table OneToOneChildEntity to {} format", options.getExportType());
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