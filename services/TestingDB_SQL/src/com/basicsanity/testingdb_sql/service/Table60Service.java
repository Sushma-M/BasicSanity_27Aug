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

import com.basicsanity.testingdb_sql.Table60;
import com.basicsanity.testingdb_sql.Table60Id;

/**
 * Service object for domain model class {@link Table60}.
 */
public interface Table60Service {

    /**
     * Creates a new Table60. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Table60 if any.
     *
     * @param table60 Details of the Table60 to be created; value cannot be null.
     * @return The newly created Table60.
     */
    Table60 create(@Valid Table60 table60);


	/**
     * Returns Table60 by given id if exists.
     *
     * @param table60Id The id of the Table60 to get; value cannot be null.
     * @return Table60 associated with the given table60Id.
	 * @throws EntityNotFoundException If no Table60 is found.
     */
    Table60 getById(Table60Id table60Id);

    /**
     * Find and return the Table60 by given id if exists, returns null otherwise.
     *
     * @param table60Id The id of the Table60 to get; value cannot be null.
     * @return Table60 associated with the given table60Id.
     */
    Table60 findById(Table60Id table60Id);

	/**
     * Find and return the list of Table60s by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param table60Ids The id's of the Table60 to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Table60s associated with the given table60Ids.
     */
    List<Table60> findByMultipleIds(List<Table60Id> table60Ids, boolean orderedReturn);


    /**
     * Updates the details of an existing Table60. It replaces all fields of the existing Table60 with the given table60.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Table60 if any.
     *
     * @param table60 The details of the Table60 to be updated; value cannot be null.
     * @return The updated Table60.
     * @throws EntityNotFoundException if no Table60 is found with given input.
     */
    Table60 update(@Valid Table60 table60);

    /**
     * Deletes an existing Table60 with the given id.
     *
     * @param table60Id The id of the Table60 to be deleted; value cannot be null.
     * @return The deleted Table60.
     * @throws EntityNotFoundException if no Table60 found with the given id.
     */
    Table60 delete(Table60Id table60Id);

    /**
     * Deletes an existing Table60 with the given object.
     *
     * @param table60 The instance of the Table60 to be deleted; value cannot be null.
     */
    void delete(Table60 table60);

    /**
     * Find all Table60s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table60s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Table60> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Table60s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table60s.
     *
     * @see Pageable
     * @see Page
     */
    Page<Table60> findAll(String query, Pageable pageable);

    /**
     * Exports all Table60s matching the given input query to the given exportType format.
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
     * Exports all Table60s matching the given input query to the given exportType format.
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
     * Retrieve the count of the Table60s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Table60.
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