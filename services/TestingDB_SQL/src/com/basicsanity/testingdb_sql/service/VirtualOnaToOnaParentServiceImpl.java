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

import com.basicsanity.testingdb_sql.VirtualOnaToOnaParent;
import com.basicsanity.testingdb_sql.VirtualOnaToOnaParentId;


/**
 * ServiceImpl object for domain model class VirtualOnaToOnaParent.
 *
 * @see VirtualOnaToOnaParent
 */
@Service("TestingDB_SQL.VirtualOnaToOnaParentService")
@Validated
public class VirtualOnaToOnaParentServiceImpl implements VirtualOnaToOnaParentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VirtualOnaToOnaParentServiceImpl.class);


    @Autowired
    @Qualifier("TestingDB_SQL.VirtualOnaToOnaParentDao")
    private WMGenericDao<VirtualOnaToOnaParent, VirtualOnaToOnaParentId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<VirtualOnaToOnaParent, VirtualOnaToOnaParentId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public VirtualOnaToOnaParent create(VirtualOnaToOnaParent virtualOnaToOnaParent) {
        LOGGER.debug("Creating a new VirtualOnaToOnaParent with information: {}", virtualOnaToOnaParent);

        VirtualOnaToOnaParent virtualOnaToOnaParentCreated = this.wmGenericDao.create(virtualOnaToOnaParent);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(virtualOnaToOnaParentCreated);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public VirtualOnaToOnaParent getById(VirtualOnaToOnaParentId virtualonatoonaparentId) {
        LOGGER.debug("Finding VirtualOnaToOnaParent by id: {}", virtualonatoonaparentId);
        return this.wmGenericDao.findById(virtualonatoonaparentId);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public VirtualOnaToOnaParent findById(VirtualOnaToOnaParentId virtualonatoonaparentId) {
        LOGGER.debug("Finding VirtualOnaToOnaParent by id: {}", virtualonatoonaparentId);
        try {
            return this.wmGenericDao.findById(virtualonatoonaparentId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No VirtualOnaToOnaParent found with id: {}", virtualonatoonaparentId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public List<VirtualOnaToOnaParent> findByMultipleIds(List<VirtualOnaToOnaParentId> virtualonatoonaparentIds, boolean orderedReturn) {
        LOGGER.debug("Finding VirtualOnaToOnaParents by ids: {}", virtualonatoonaparentIds);

        return this.wmGenericDao.findByMultipleIds(virtualonatoonaparentIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TestingDB_SQLTransactionManager")
    @Override
    public VirtualOnaToOnaParent update(VirtualOnaToOnaParent virtualOnaToOnaParent) {
        LOGGER.debug("Updating VirtualOnaToOnaParent with information: {}", virtualOnaToOnaParent);

        this.wmGenericDao.update(virtualOnaToOnaParent);
        this.wmGenericDao.refresh(virtualOnaToOnaParent);

        return virtualOnaToOnaParent;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public VirtualOnaToOnaParent delete(VirtualOnaToOnaParentId virtualonatoonaparentId) {
        LOGGER.debug("Deleting VirtualOnaToOnaParent with id: {}", virtualonatoonaparentId);
        VirtualOnaToOnaParent deleted = this.wmGenericDao.findById(virtualonatoonaparentId);
        if (deleted == null) {
            LOGGER.debug("No VirtualOnaToOnaParent found with id: {}", virtualonatoonaparentId);
            throw new EntityNotFoundException(String.valueOf(virtualonatoonaparentId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public void delete(VirtualOnaToOnaParent virtualOnaToOnaParent) {
        LOGGER.debug("Deleting VirtualOnaToOnaParent with {}", virtualOnaToOnaParent);
        this.wmGenericDao.delete(virtualOnaToOnaParent);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<VirtualOnaToOnaParent> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all VirtualOnaToOnaParents");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<VirtualOnaToOnaParent> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all VirtualOnaToOnaParents");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table VirtualOnaToOnaParent to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table VirtualOnaToOnaParent to {} format", options.getExportType());
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