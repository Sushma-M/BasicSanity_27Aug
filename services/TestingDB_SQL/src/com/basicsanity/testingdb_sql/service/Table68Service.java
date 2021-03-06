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

import com.basicsanity.testingdb_sql.Table68;
import com.basicsanity.testingdb_sql.Table68Id;

/**
 * Service object for domain model class {@link Table68}.
 */
public interface Table68Service {

    /**
     * Creates a new Table68. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Table68 if any.
     *
     * @param table68 Details of the Table68 to be created; value cannot be null.
     * @return The newly created Table68.
     */
    Table68 create(@Valid Table68 table68);


	/**
     * Returns Table68 by given id if exists.
     *
     * @param table68Id The id of the Table68 to get; value cannot be null.
     * @return Table68 associated with the given table68Id.
	 * @throws EntityNotFoundException If no Table68 is found.
     */
    Table68 getById(Table68Id table68Id);

    /**
     * Find and return the Table68 by given id if exists, returns null otherwise.
     *
     * @param table68Id The id of the Table68 to get; value cannot be null.
     * @return Table68 associated with the given table68Id.
     */
    Table68 findById(Table68Id table68Id);

	/**
     * Find and return the list of Table68s by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param table68Ids The id's of the Table68 to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Table68s associated with the given table68Ids.
     */
    List<Table68> findByMultipleIds(List<Table68Id> table68Ids, boolean orderedReturn);


    /**
     * Updates the details of an existing Table68. It replaces all fields of the existing Table68 with the given table68.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Table68 if any.
     *
     * @param table68 The details of the Table68 to be updated; value cannot be null.
     * @return The updated Table68.
     * @throws EntityNotFoundException if no Table68 is found with given input.
     */
    Table68 update(@Valid Table68 table68);

    /**
     * Deletes an existing Table68 with the given id.
     *
     * @param table68Id The id of the Table68 to be deleted; value cannot be null.
     * @return The deleted Table68.
     * @throws EntityNotFoundException if no Table68 found with the given id.
     */
    Table68 delete(Table68Id table68Id);

    /**
     * Deletes an existing Table68 with the given object.
     *
     * @param table68 The instance of the Table68 to be deleted; value cannot be null.
     */
    void delete(Table68 table68);

    /**
     * Find all Table68s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table68s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Table68> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Table68s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table68s.
     *
     * @see Pageable
     * @see Page
     */
    Page<Table68> findAll(String query, Pageable pageable);

    /**
     * Exports all Table68s matching the given input query to the given exportType format.
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
     * Exports all Table68s matching the given input query to the given exportType format.
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
     * Retrieve the count of the Table68s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Table68.
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