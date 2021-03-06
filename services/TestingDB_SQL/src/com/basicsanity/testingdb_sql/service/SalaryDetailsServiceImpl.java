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

import com.basicsanity.testingdb_sql.JoiningDetails;
import com.basicsanity.testingdb_sql.SalaryDetails;


/**
 * ServiceImpl object for domain model class SalaryDetails.
 *
 * @see SalaryDetails
 */
@Service("TestingDB_SQL.SalaryDetailsService")
@Validated
public class SalaryDetailsServiceImpl implements SalaryDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SalaryDetailsServiceImpl.class);

    @Lazy
    @Autowired
    @Qualifier("TestingDB_SQL.JoiningDetailsService")
    private JoiningDetailsService joiningDetailsService;

    @Autowired
    @Qualifier("TestingDB_SQL.SalaryDetailsDao")
    private WMGenericDao<SalaryDetails, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<SalaryDetails, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public SalaryDetails create(SalaryDetails salaryDetails) {
        LOGGER.debug("Creating a new SalaryDetails with information: {}", salaryDetails);

        SalaryDetails salaryDetailsCreated = this.wmGenericDao.create(salaryDetails);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(salaryDetailsCreated);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public SalaryDetails getById(Integer salarydetailsId) {
        LOGGER.debug("Finding SalaryDetails by id: {}", salarydetailsId);
        return this.wmGenericDao.findById(salarydetailsId);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public SalaryDetails findById(Integer salarydetailsId) {
        LOGGER.debug("Finding SalaryDetails by id: {}", salarydetailsId);
        try {
            return this.wmGenericDao.findById(salarydetailsId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No SalaryDetails found with id: {}", salarydetailsId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public List<SalaryDetails> findByMultipleIds(List<Integer> salarydetailsIds, boolean orderedReturn) {
        LOGGER.debug("Finding SalaryDetails by ids: {}", salarydetailsIds);

        return this.wmGenericDao.findByMultipleIds(salarydetailsIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TestingDB_SQLTransactionManager")
    @Override
    public SalaryDetails update(SalaryDetails salaryDetails) {
        LOGGER.debug("Updating SalaryDetails with information: {}", salaryDetails);

        this.wmGenericDao.update(salaryDetails);
        this.wmGenericDao.refresh(salaryDetails);

        return salaryDetails;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public SalaryDetails delete(Integer salarydetailsId) {
        LOGGER.debug("Deleting SalaryDetails with id: {}", salarydetailsId);
        SalaryDetails deleted = this.wmGenericDao.findById(salarydetailsId);
        if (deleted == null) {
            LOGGER.debug("No SalaryDetails found with id: {}", salarydetailsId);
            throw new EntityNotFoundException(String.valueOf(salarydetailsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "TestingDB_SQLTransactionManager")
    @Override
    public void delete(SalaryDetails salaryDetails) {
        LOGGER.debug("Deleting SalaryDetails with {}", salaryDetails);
        this.wmGenericDao.delete(salaryDetails);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<SalaryDetails> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all SalaryDetails");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager")
    @Override
    public Page<SalaryDetails> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all SalaryDetails");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table SalaryDetails to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "TestingDB_SQLTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service TestingDB_SQL for table SalaryDetails to {} format", options.getExportType());
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
    public Page<JoiningDetails> findAssociatedJoiningDetailses(Integer accountId, Pageable pageable) {
        LOGGER.debug("Fetching all associated joiningDetailses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("salaryDetails.accountId = '" + accountId + "'");

        return joiningDetailsService.findAll(queryBuilder.toString(), pageable);
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service JoiningDetailsService instance
     */
    protected void setJoiningDetailsService(JoiningDetailsService service) {
        this.joiningDetailsService = service;
    }

}