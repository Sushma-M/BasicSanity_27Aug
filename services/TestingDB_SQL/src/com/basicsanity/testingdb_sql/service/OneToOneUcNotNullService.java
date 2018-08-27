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

import com.basicsanity.testingdb_sql.OneToOneUcNotNull;

/**
 * Service object for domain model class {@link OneToOneUcNotNull}.
 */
public interface OneToOneUcNotNullService {

    /**
     * Creates a new OneToOneUcNotNull. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on OneToOneUcNotNull if any.
     *
     * @param oneToOneUcNotNull Details of the OneToOneUcNotNull to be created; value cannot be null.
     * @return The newly created OneToOneUcNotNull.
     */
    OneToOneUcNotNull create(@Valid OneToOneUcNotNull oneToOneUcNotNull);


	/**
     * Returns OneToOneUcNotNull by given id if exists.
     *
     * @param onetooneucnotnullId The id of the OneToOneUcNotNull to get; value cannot be null.
     * @return OneToOneUcNotNull associated with the given onetooneucnotnullId.
	 * @throws EntityNotFoundException If no OneToOneUcNotNull is found.
     */
    OneToOneUcNotNull getById(Integer onetooneucnotnullId);

    /**
     * Find and return the OneToOneUcNotNull by given id if exists, returns null otherwise.
     *
     * @param onetooneucnotnullId The id of the OneToOneUcNotNull to get; value cannot be null.
     * @return OneToOneUcNotNull associated with the given onetooneucnotnullId.
     */
    OneToOneUcNotNull findById(Integer onetooneucnotnullId);

	/**
     * Find and return the list of OneToOneUcNotNulls by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param onetooneucnotnullIds The id's of the OneToOneUcNotNull to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return OneToOneUcNotNulls associated with the given onetooneucnotnullIds.
     */
    List<OneToOneUcNotNull> findByMultipleIds(List<Integer> onetooneucnotnullIds, boolean orderedReturn);

    /**
     * Find and return the OneToOneUcNotNull for given column3  if exists.
     *
     * @param column3 value of column3; value cannot be null.
     * @return OneToOneUcNotNull associated with the given inputs.
     * @throws EntityNotFoundException if no matching OneToOneUcNotNull found.
     */
    OneToOneUcNotNull getByColumn3(int column3);

    /**
     * Updates the details of an existing OneToOneUcNotNull. It replaces all fields of the existing OneToOneUcNotNull with the given oneToOneUcNotNull.
     *
     * This method overrides the input field values using Server side or database managed properties defined on OneToOneUcNotNull if any.
     *
     * @param oneToOneUcNotNull The details of the OneToOneUcNotNull to be updated; value cannot be null.
     * @return The updated OneToOneUcNotNull.
     * @throws EntityNotFoundException if no OneToOneUcNotNull is found with given input.
     */
    OneToOneUcNotNull update(@Valid OneToOneUcNotNull oneToOneUcNotNull);

    /**
     * Deletes an existing OneToOneUcNotNull with the given id.
     *
     * @param onetooneucnotnullId The id of the OneToOneUcNotNull to be deleted; value cannot be null.
     * @return The deleted OneToOneUcNotNull.
     * @throws EntityNotFoundException if no OneToOneUcNotNull found with the given id.
     */
    OneToOneUcNotNull delete(Integer onetooneucnotnullId);

    /**
     * Deletes an existing OneToOneUcNotNull with the given object.
     *
     * @param oneToOneUcNotNull The instance of the OneToOneUcNotNull to be deleted; value cannot be null.
     */
    void delete(OneToOneUcNotNull oneToOneUcNotNull);

    /**
     * Find all OneToOneUcNotNulls matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching OneToOneUcNotNulls.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<OneToOneUcNotNull> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all OneToOneUcNotNulls matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching OneToOneUcNotNulls.
     *
     * @see Pageable
     * @see Page
     */
    Page<OneToOneUcNotNull> findAll(String query, Pageable pageable);

    /**
     * Exports all OneToOneUcNotNulls matching the given input query to the given exportType format.
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
     * Exports all OneToOneUcNotNulls matching the given input query to the given exportType format.
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
     * Retrieve the count of the OneToOneUcNotNulls in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the OneToOneUcNotNull.
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