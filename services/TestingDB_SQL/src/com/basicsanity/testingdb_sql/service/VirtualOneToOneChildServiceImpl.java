/*Copyright (c) 2018-2019 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.basicsanity.testingdb_sql.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.HashMap;
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

import com.basicsanity.testingdb_sql.VirtualOneToOneChild;
import com.basicsanity.testingdb_sql.VirtualOneToOneChildId;


/**
 * ServiceImpl object for domain model class VirtualOneToOneChild.
 *
 * @see VirtualOneToOneChild
 */
@Service("TestingDB_SQL.VirtualOneToOneChildService")
@Validated
public class VirtualOneToOneChildServiceImpl implements VirtualOneToOneChildService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VirtualOneToOneChildServiceImpl.class);


    @Autowired
    @Qualifier("TestingDB_SQL.VirtualOneToOneChildDao")
    private WMGenericDao<VirtualOneToOneChild, VirtualOneToOneChildId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<VirtualOneToOneChild, VirtualOneToOneChildId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public VirtualOneToOneChild create(VirtualOneToOneChild virtualOneToOneChild) {
        LOGGER.debug("Creating a new VirtualOneToOneChild with information: {}", virtualOneToOneChild);

        VirtualOneToOneChild virtualOneToOneChildCreated = this.wmGenericDao.create(virtualOneToOneChild);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(virtualOneToOneChildCreated);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public VirtualOneToOneChild getById(VirtualOneToOneChildId virtualonetoonechildId) {
        LOGGER.debug("Finding VirtualOneToOneChild by id: {}", virtualonetoonechildId);
        return this.wmGenericDao.findById(virtualonetoonechildId);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public VirtualOneToOneChild findById(VirtualOneToOneChildId virtualonetoonechildId) {
        LOGGER.debug("Finding VirtualOneToOneChild by id: {}", virtualonetoonechildId);
        try {
            return this.wmGenericDao.findById(virtualonetoonechildId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No VirtualOneToOneChild found with id: {}", virtualonetoonechildId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public List<VirtualOneToOneChild> findByMultipleIds(List<VirtualOneToOneChildId> virtualonetoonechildIds, boolean orderedReturn) {
        LOGGER.debug("Finding VirtualOneToOneChilds by ids: {}", virtualonetoonechildIds);

        return this.wmGenericDao.findByMultipleIds(virtualonetoonechildIds, orderedReturn);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public VirtualOneToOneChild getByVirtualOneToOneParent(Integer virtualOneToOneParent) {
        Map<String, Object> virtualOneToOneParentMap = new HashMap<>();
        virtualOneToOneParentMap.put("virtualOneToOneParent", virtualOneToOneParent);

        LOGGER.debug("Finding VirtualOneToOneChild by unique keys: {}", virtualOneToOneParentMap);
        return this.wmGenericDao.findByUniqueKey(virtualOneToOneParentMap);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TestingDB_SQLTransactionManager")
    @Override
    public VirtualOneToOneChild update(VirtualOneToOneChild virtualOneToOneChild) {
        LOGGER.debug("Updating VirtualOneToOneChild with information: {}", virtualOneToOneChild);

        this.wmGenericDao.update(virtualOneToOneChild);
        this.wmGenericDao.refresh(virtualOneToOneChild);

        return virtualOneToOneChild;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public VirtualOneToOneChild delete(VirtualOneToOneChildId virtualonetoonechildId) {
        LOGGER.debug("Deleting VirtualOneToOneChild with id: {}", virtualonetoonechildId);
        VirtualOneToOneChild deleted = this.wmGenericDao.findById(virtualonetoonechildId);
        if (deleted == null) {
            LOGGER.debug("No VirtualOneToOneChild found with id: {}", virtualonetoonechildId);
            throw new EntityNotFoundException(String.valueOf(virtualonetoonechildId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public void delete(VirtualOneToOneChild virtualOneToOneChild) {
        LOGGER.debug("Deleting VirtualOneToOneChild with {}", virtualOneToOneChild);
        this.wmGenericDao.delete(virtualOneToOneChild);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<VirtualOneToOneChild> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all VirtualOneToOneChilds");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<VirtualOneToOneChild> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all VirtualOneToOneChilds");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table VirtualOneToOneChild to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table VirtualOneToOneChild to {} format", options.getExportType());
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