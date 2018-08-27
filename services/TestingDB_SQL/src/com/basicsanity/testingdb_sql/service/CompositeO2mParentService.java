/*Copyright (c) 2018-2019 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.basicsanity.testingdb_sql.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
 * Service object for domain model class {@link CompositeO2mParent}.
 */
public interface CompositeO2mParentService {

    /**
     * Creates a new CompositeO2mParent. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on CompositeO2mParent if any.
     *
     * @param compositeO2mParent Details of the CompositeO2mParent to be created; value cannot be null.
     * @return The newly created CompositeO2mParent.
     */
    CompositeO2mParent create(@Valid CompositeO2mParent compositeO2mParent);


	/**
     * Returns CompositeO2mParent by given id if exists.
     *
     * @param compositeo2mparentId The id of the CompositeO2mParent to get; value cannot be null.
     * @return CompositeO2mParent associated with the given compositeo2mparentId.
	 * @throws EntityNotFoundException If no CompositeO2mParent is found.
     */
    CompositeO2mParent getById(CompositeO2mParentId compositeo2mparentId);

    /**
     * Find and return the CompositeO2mParent by given id if exists, returns null otherwise.
     *
     * @param compositeo2mparentId The id of the CompositeO2mParent to get; value cannot be null.
     * @return CompositeO2mParent associated with the given compositeo2mparentId.
     */
    CompositeO2mParent findById(CompositeO2mParentId compositeo2mparentId);

	/**
     * Find and return the list of CompositeO2mParents by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param compositeo2mparentIds The id's of the CompositeO2mParent to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return CompositeO2mParents associated with the given compositeo2mparentIds.
     */
    List<CompositeO2mParent> findByMultipleIds(List<CompositeO2mParentId> compositeo2mparentIds, boolean orderedReturn);


    /**
     * Updates the details of an existing CompositeO2mParent. It replaces all fields of the existing CompositeO2mParent with the given compositeO2mParent.
     *
     * This method overrides the input field values using Server side or database managed properties defined on CompositeO2mParent if any.
     *
     * @param compositeO2mParent The details of the CompositeO2mParent to be updated; value cannot be null.
     * @return The updated CompositeO2mParent.
     * @throws EntityNotFoundException if no CompositeO2mParent is found with given input.
     */
    CompositeO2mParent update(@Valid CompositeO2mParent compositeO2mParent);

    /**
     * Deletes an existing CompositeO2mParent with the given id.
     *
     * @param compositeo2mparentId The id of the CompositeO2mParent to be deleted; value cannot be null.
     * @return The deleted CompositeO2mParent.
     * @throws EntityNotFoundException if no CompositeO2mParent found with the given id.
     */
    CompositeO2mParent delete(CompositeO2mParentId compositeo2mparentId);

    /**
     * Deletes an existing CompositeO2mParent with the given object.
     *
     * @param compositeO2mParent The instance of the CompositeO2mParent to be deleted; value cannot be null.
     */
    void delete(CompositeO2mParent compositeO2mParent);

    /**
     * Find all CompositeO2mParents matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching CompositeO2mParents.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<CompositeO2mParent> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all CompositeO2mParents matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching CompositeO2mParents.
     *
     * @see Pageable
     * @see Page
     */
    Page<CompositeO2mParent> findAll(String query, Pageable pageable);

    /**
     * Exports all CompositeO2mParents matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
     */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

    /**
     * Exports all CompositeO2mParents matching the given input query to the given exportType format.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     * @see Pageable
     * @see OutputStream
     */
    void export(DataExportOptions options, Pageable pageable, OutputStream outputStream);

    /**
     * Retrieve the count of the CompositeO2mParents in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the CompositeO2mParent.
     */
    long count(String query);

    /**
     * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return Paginated data with included fields.
     *
     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
    Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);

    /*
     * Returns the associated compositeO2mChilds for given CompositeO2mParent id.
     *
     * @param id value of id; value cannot be null
     * @param column2 value of column2; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated CompositeO2mChild instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<CompositeO2mChild> findAssociatedCompositeO2mChilds(Integer id, String column2, Pageable pageable);

}