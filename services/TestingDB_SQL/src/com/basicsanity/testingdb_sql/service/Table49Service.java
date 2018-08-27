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

import com.basicsanity.testingdb_sql.Table49;

/**
 * Service object for domain model class {@link Table49}.
 */
public interface Table49Service {

    /**
     * Creates a new Table49. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Table49 if any.
     *
     * @param table49 Details of the Table49 to be created; value cannot be null.
     * @return The newly created Table49.
     */
    Table49 create(@Valid Table49 table49);


	/**
     * Returns Table49 by given id if exists.
     *
     * @param table49Id The id of the Table49 to get; value cannot be null.
     * @return Table49 associated with the given table49Id.
	 * @throws EntityNotFoundException If no Table49 is found.
     */
    Table49 getById(Integer table49Id);

    /**
     * Find and return the Table49 by given id if exists, returns null otherwise.
     *
     * @param table49Id The id of the Table49 to get; value cannot be null.
     * @return Table49 associated with the given table49Id.
     */
    Table49 findById(Integer table49Id);

	/**
     * Find and return the list of Table49s by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param table49Ids The id's of the Table49 to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Table49s associated with the given table49Ids.
     */
    List<Table49> findByMultipleIds(List<Integer> table49Ids, boolean orderedReturn);


    /**
     * Updates the details of an existing Table49. It replaces all fields of the existing Table49 with the given table49.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Table49 if any.
     *
     * @param table49 The details of the Table49 to be updated; value cannot be null.
     * @return The updated Table49.
     * @throws EntityNotFoundException if no Table49 is found with given input.
     */
    Table49 update(@Valid Table49 table49);

    /**
     * Deletes an existing Table49 with the given id.
     *
     * @param table49Id The id of the Table49 to be deleted; value cannot be null.
     * @return The deleted Table49.
     * @throws EntityNotFoundException if no Table49 found with the given id.
     */
    Table49 delete(Integer table49Id);

    /**
     * Deletes an existing Table49 with the given object.
     *
     * @param table49 The instance of the Table49 to be deleted; value cannot be null.
     */
    void delete(Table49 table49);

    /**
     * Find all Table49s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table49s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Table49> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Table49s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table49s.
     *
     * @see Pageable
     * @see Page
     */
    Page<Table49> findAll(String query, Pageable pageable);

    /**
     * Exports all Table49s matching the given input query to the given exportType format.
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
     * Exports all Table49s matching the given input query to the given exportType format.
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
     * Retrieve the count of the Table49s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Table49.
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