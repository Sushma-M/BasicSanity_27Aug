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

import com.basicsanity.testingdb_sql.Table48;
import com.basicsanity.testingdb_sql.Table50Id;

/**
 * Service object for domain model class {@link Table48}.
 */
public interface Table48Service {

    /**
     * Creates a new Table48. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Table48 if any.
     *
     * @param table48 Details of the Table48 to be created; value cannot be null.
     * @return The newly created Table48.
     */
    Table48 create(@Valid Table48 table48);


	/**
     * Returns Table48 by given id if exists.
     *
     * @param table48Id The id of the Table48 to get; value cannot be null.
     * @return Table48 associated with the given table48Id.
	 * @throws EntityNotFoundException If no Table48 is found.
     */
    Table48 getById(Table50Id table48Id);

    /**
     * Find and return the Table48 by given id if exists, returns null otherwise.
     *
     * @param table48Id The id of the Table48 to get; value cannot be null.
     * @return Table48 associated with the given table48Id.
     */
    Table48 findById(Table50Id table48Id);

	/**
     * Find and return the list of Table48s by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param table48Ids The id's of the Table48 to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Table48s associated with the given table48Ids.
     */
    List<Table48> findByMultipleIds(List<Table50Id> table48Ids, boolean orderedReturn);


    /**
     * Updates the details of an existing Table48. It replaces all fields of the existing Table48 with the given table48.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Table48 if any.
     *
     * @param table48 The details of the Table48 to be updated; value cannot be null.
     * @return The updated Table48.
     * @throws EntityNotFoundException if no Table48 is found with given input.
     */
    Table48 update(@Valid Table48 table48);

    /**
     * Deletes an existing Table48 with the given id.
     *
     * @param table48Id The id of the Table48 to be deleted; value cannot be null.
     * @return The deleted Table48.
     * @throws EntityNotFoundException if no Table48 found with the given id.
     */
    Table48 delete(Table50Id table48Id);

    /**
     * Deletes an existing Table48 with the given object.
     *
     * @param table48 The instance of the Table48 to be deleted; value cannot be null.
     */
    void delete(Table48 table48);

    /**
     * Find all Table48s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table48s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Table48> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Table48s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table48s.
     *
     * @see Pageable
     * @see Page
     */
    Page<Table48> findAll(String query, Pageable pageable);

    /**
     * Exports all Table48s matching the given input query to the given exportType format.
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
     * Exports all Table48s matching the given input query to the given exportType format.
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
     * Retrieve the count of the Table48s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Table48.
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