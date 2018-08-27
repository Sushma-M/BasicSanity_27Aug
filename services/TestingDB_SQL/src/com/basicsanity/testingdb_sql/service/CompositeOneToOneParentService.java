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

import com.basicsanity.testingdb_sql.CompositeOneToOneParent;
import com.basicsanity.testingdb_sql.CompositeOneToOneParentId;

/**
 * Service object for domain model class {@link CompositeOneToOneParent}.
 */
public interface CompositeOneToOneParentService {

    /**
     * Creates a new CompositeOneToOneParent. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on CompositeOneToOneParent if any.
     *
     * @param compositeOneToOneParent Details of the CompositeOneToOneParent to be created; value cannot be null.
     * @return The newly created CompositeOneToOneParent.
     */
    CompositeOneToOneParent create(@Valid CompositeOneToOneParent compositeOneToOneParent);


	/**
     * Returns CompositeOneToOneParent by given id if exists.
     *
     * @param compositeonetooneparentId The id of the CompositeOneToOneParent to get; value cannot be null.
     * @return CompositeOneToOneParent associated with the given compositeonetooneparentId.
	 * @throws EntityNotFoundException If no CompositeOneToOneParent is found.
     */
    CompositeOneToOneParent getById(CompositeOneToOneParentId compositeonetooneparentId);

    /**
     * Find and return the CompositeOneToOneParent by given id if exists, returns null otherwise.
     *
     * @param compositeonetooneparentId The id of the CompositeOneToOneParent to get; value cannot be null.
     * @return CompositeOneToOneParent associated with the given compositeonetooneparentId.
     */
    CompositeOneToOneParent findById(CompositeOneToOneParentId compositeonetooneparentId);

	/**
     * Find and return the list of CompositeOneToOneParents by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param compositeonetooneparentIds The id's of the CompositeOneToOneParent to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return CompositeOneToOneParents associated with the given compositeonetooneparentIds.
     */
    List<CompositeOneToOneParent> findByMultipleIds(List<CompositeOneToOneParentId> compositeonetooneparentIds, boolean orderedReturn);


    /**
     * Updates the details of an existing CompositeOneToOneParent. It replaces all fields of the existing CompositeOneToOneParent with the given compositeOneToOneParent.
     *
     * This method overrides the input field values using Server side or database managed properties defined on CompositeOneToOneParent if any.
     *
     * @param compositeOneToOneParent The details of the CompositeOneToOneParent to be updated; value cannot be null.
     * @return The updated CompositeOneToOneParent.
     * @throws EntityNotFoundException if no CompositeOneToOneParent is found with given input.
     */
    CompositeOneToOneParent update(@Valid CompositeOneToOneParent compositeOneToOneParent);

    /**
     * Deletes an existing CompositeOneToOneParent with the given id.
     *
     * @param compositeonetooneparentId The id of the CompositeOneToOneParent to be deleted; value cannot be null.
     * @return The deleted CompositeOneToOneParent.
     * @throws EntityNotFoundException if no CompositeOneToOneParent found with the given id.
     */
    CompositeOneToOneParent delete(CompositeOneToOneParentId compositeonetooneparentId);

    /**
     * Deletes an existing CompositeOneToOneParent with the given object.
     *
     * @param compositeOneToOneParent The instance of the CompositeOneToOneParent to be deleted; value cannot be null.
     */
    void delete(CompositeOneToOneParent compositeOneToOneParent);

    /**
     * Find all CompositeOneToOneParents matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching CompositeOneToOneParents.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<CompositeOneToOneParent> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all CompositeOneToOneParents matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching CompositeOneToOneParents.
     *
     * @see Pageable
     * @see Page
     */
    Page<CompositeOneToOneParent> findAll(String query, Pageable pageable);

    /**
     * Exports all CompositeOneToOneParents matching the given input query to the given exportType format.
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
     * Exports all CompositeOneToOneParents matching the given input query to the given exportType format.
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
     * Retrieve the count of the CompositeOneToOneParents in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the CompositeOneToOneParent.
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


}