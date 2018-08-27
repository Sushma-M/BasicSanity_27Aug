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

import com.basicsanity.testingdb_sql.JoiningDetails;

/**
 * Service object for domain model class {@link JoiningDetails}.
 */
public interface JoiningDetailsService {

    /**
     * Creates a new JoiningDetails. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on JoiningDetails if any.
     *
     * @param joiningDetails Details of the JoiningDetails to be created; value cannot be null.
     * @return The newly created JoiningDetails.
     */
    JoiningDetails create(@Valid JoiningDetails joiningDetails);


	/**
     * Returns JoiningDetails by given id if exists.
     *
     * @param joiningdetailsId The id of the JoiningDetails to get; value cannot be null.
     * @return JoiningDetails associated with the given joiningdetailsId.
	 * @throws EntityNotFoundException If no JoiningDetails is found.
     */
    JoiningDetails getById(Integer joiningdetailsId);

    /**
     * Find and return the JoiningDetails by given id if exists, returns null otherwise.
     *
     * @param joiningdetailsId The id of the JoiningDetails to get; value cannot be null.
     * @return JoiningDetails associated with the given joiningdetailsId.
     */
    JoiningDetails findById(Integer joiningdetailsId);

	/**
     * Find and return the list of JoiningDetails by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param joiningdetailsIds The id's of the JoiningDetails to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return JoiningDetails associated with the given joiningdetailsIds.
     */
    List<JoiningDetails> findByMultipleIds(List<Integer> joiningdetailsIds, boolean orderedReturn);


    /**
     * Updates the details of an existing JoiningDetails. It replaces all fields of the existing JoiningDetails with the given joiningDetails.
     *
     * This method overrides the input field values using Server side or database managed properties defined on JoiningDetails if any.
     *
     * @param joiningDetails The details of the JoiningDetails to be updated; value cannot be null.
     * @return The updated JoiningDetails.
     * @throws EntityNotFoundException if no JoiningDetails is found with given input.
     */
    JoiningDetails update(@Valid JoiningDetails joiningDetails);

    /**
     * Deletes an existing JoiningDetails with the given id.
     *
     * @param joiningdetailsId The id of the JoiningDetails to be deleted; value cannot be null.
     * @return The deleted JoiningDetails.
     * @throws EntityNotFoundException if no JoiningDetails found with the given id.
     */
    JoiningDetails delete(Integer joiningdetailsId);

    /**
     * Deletes an existing JoiningDetails with the given object.
     *
     * @param joiningDetails The instance of the JoiningDetails to be deleted; value cannot be null.
     */
    void delete(JoiningDetails joiningDetails);

    /**
     * Find all JoiningDetails matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching JoiningDetails.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<JoiningDetails> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all JoiningDetails matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching JoiningDetails.
     *
     * @see Pageable
     * @see Page
     */
    Page<JoiningDetails> findAll(String query, Pageable pageable);

    /**
     * Exports all JoiningDetails matching the given input query to the given exportType format.
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
     * Exports all JoiningDetails matching the given input query to the given exportType format.
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
     * Retrieve the count of the JoiningDetails in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the JoiningDetails.
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