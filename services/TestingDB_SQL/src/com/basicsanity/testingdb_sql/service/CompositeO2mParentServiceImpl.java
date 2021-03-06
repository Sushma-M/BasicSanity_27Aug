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
import org.springframework.context.annotation.Lazy;
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

import com.basicsanity.testingdb_sql.CompositeO2mChild;
import com.basicsanity.testingdb_sql.CompositeO2mParent;
import com.basicsanity.testingdb_sql.CompositeO2mParentId;


/**
 * ServiceImpl object for domain model class CompositeO2mParent.
 *
 * @see CompositeO2mParent
 */
@Service("TestingDB_SQL.CompositeO2mParentService")
@Validated
public class CompositeO2mParentServiceImpl implements CompositeO2mParentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompositeO2mParentServiceImpl.class);

    @Lazy
    @Autowired
    @Qualifier("TestingDB_SQL.CompositeO2mChildService")
    private CompositeO2mChildService compositeO2mChildService;

    @Autowired
    @Qualifier("TestingDB_SQL.CompositeO2mParentDao")
    private WMGenericDao<CompositeO2mParent, CompositeO2mParentId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<CompositeO2mParent, CompositeO2mParentId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public CompositeO2mParent create(CompositeO2mParent compositeO2mParent) {
        LOGGER.debug("Creating a new CompositeO2mParent with information: {}", compositeO2mParent);

        CompositeO2mParent compositeO2mParentCreated = this.wmGenericDao.create(compositeO2mParent);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(compositeO2mParentCreated);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public CompositeO2mParent getById(CompositeO2mParentId compositeo2mparentId) {
        LOGGER.debug("Finding CompositeO2mParent by id: {}", compositeo2mparentId);
        return this.wmGenericDao.findById(compositeo2mparentId);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public CompositeO2mParent findById(CompositeO2mParentId compositeo2mparentId) {
        LOGGER.debug("Finding CompositeO2mParent by id: {}", compositeo2mparentId);
        try {
            return this.wmGenericDao.findById(compositeo2mparentId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No CompositeO2mParent found with id: {}", compositeo2mparentId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public List<CompositeO2mParent> findByMultipleIds(List<CompositeO2mParentId> compositeo2mparentIds, boolean orderedReturn) {
        LOGGER.debug("Finding CompositeO2mParents by ids: {}", compositeo2mparentIds);

        return this.wmGenericDao.findByMultipleIds(compositeo2mparentIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TestingDB_SQLTransactionManager")
    @Override
    public CompositeO2mParent update(CompositeO2mParent compositeO2mParent) {
        LOGGER.debug("Updating CompositeO2mParent with information: {}", compositeO2mParent);

        this.wmGenericDao.update(compositeO2mParent);
        this.wmGenericDao.refresh(compositeO2mParent);

        return compositeO2mParent;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public CompositeO2mParent delete(CompositeO2mParentId compositeo2mparentId) {
        LOGGER.debug("Deleting CompositeO2mParent with id: {}", compositeo2mparentId);
        CompositeO2mParent deleted = this.wmGenericDao.findById(compositeo2mparentId);
        if (deleted == null) {
            LOGGER.debug("No CompositeO2mParent found with id: {}", compositeo2mparentId);
            throw new EntityNotFoundException(String.valueOf(compositeo2mparentId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public void delete(CompositeO2mParent compositeO2mParent) {
        LOGGER.debug("Deleting CompositeO2mParent with {}", compositeO2mParent);
        this.wmGenericDao.delete(compositeO2mParent);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<CompositeO2mParent> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all CompositeO2mParents");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<CompositeO2mParent> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all CompositeO2mParents");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table CompositeO2mParent to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table CompositeO2mParent to {} format", options.getExportType());
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

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<CompositeO2mChild> findAssociatedCompositeO2mChilds(Integer id, String column2, Pageable pageable) {
        LOGGER.debug("Fetching all associated compositeO2mChilds");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("compositeO2mParent.id = '" + id + "'");
        queryBuilder.append(" and ");
        queryBuilder.append("compositeO2mParent.column2 = '" + column2 + "'");

        return compositeO2mChildService.findAll(queryBuilder.toString(), pageable);
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service CompositeO2mChildService instance
     */
    protected void setCompositeO2mChildService(CompositeO2mChildService service) {
        this.compositeO2mChildService = service;
    }

}