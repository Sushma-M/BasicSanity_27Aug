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

import com.basicsanity.testingdb_sql.VirtualOnaToOnaChild;
import com.basicsanity.testingdb_sql.VirtualOnaToOnaChildId;

/**
 * Service object for domain model class {@link VirtualOnaToOnaChild}.
 */
public interface VirtualOnaToOnaChildService {

    /**
     * Creates a new VirtualOnaToOnaChild. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on VirtualOnaToOnaChild if any.
     *
     * @param virtualOnaToOnaChild Details of the VirtualOnaToOnaChild to be created; value cannot be null.
     * @return The newly created VirtualOnaToOnaChild.
     */
    VirtualOnaToOnaChild create(@Valid VirtualOnaToOnaChild virtualOnaToOnaChild);


	/**
     * Returns VirtualOnaToOnaChild by given id if exists.
     *
     * @param virtualonatoonachildId The id of the VirtualOnaToOnaChild to get; value cannot be null.
     * @return VirtualOnaToOnaChild associated with the given virtualonatoonachildId.
	 * @throws EntityNotFoundException If no VirtualOnaToOnaChild is found.
     */
    VirtualOnaToOnaChild getById(VirtualOnaToOnaChildId virtualonatoonachildId);

    /**
     * Find and return the VirtualOnaToOnaChild by given id if exists, returns null otherwise.
     *
     * @param virtualonatoonachildId The id of the VirtualOnaToOnaChild to get; value cannot be null.
     * @return VirtualOnaToOnaChild associated with the given virtualonatoonachildId.
     */
    VirtualOnaToOnaChild findById(VirtualOnaToOnaChildId virtualonatoonachildId);

	/**
     * Find and return the list of VirtualOnaToOnaChilds by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param virtualonatoonachildIds The id's of the VirtualOnaToOnaChild to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return VirtualOnaToOnaChilds associated with the given virtualonatoonachildIds.
     */
    List<VirtualOnaToOnaChild> findByMultipleIds(List<VirtualOnaToOnaChildId> virtualonatoonachildIds, boolean orderedReturn);


    /**
     * Updates the details of an existing VirtualOnaToOnaChild. It replaces all fields of the existing VirtualOnaToOnaChild with the given virtualOnaToOnaChild.
     *
     * This method overrides the input field values using Server side or database managed properties defined on VirtualOnaToOnaChild if any.
     *
     * @param virtualOnaToOnaChild The details of the VirtualOnaToOnaChild to be updated; value cannot be null.
     * @return The updated VirtualOnaToOnaChild.
     * @throws EntityNotFoundException if no VirtualOnaToOnaChild is found with given input.
     */
    VirtualOnaToOnaChild update(@Valid VirtualOnaToOnaChild virtualOnaToOnaChild);

    /**
     * Deletes an existing VirtualOnaToOnaChild with the given id.
     *
     * @param virtualonatoonachildId The id of the VirtualOnaToOnaChild to be deleted; value cannot be null.
     * @return The deleted VirtualOnaToOnaChild.
     * @throws EntityNotFoundException if no VirtualOnaToOnaChild found with the given id.
     */
    VirtualOnaToOnaChild delete(VirtualOnaToOnaChildId virtualonatoonachildId);

    /**
     * Deletes an existing VirtualOnaToOnaChild with the given object.
     *
     * @param virtualOnaToOnaChild The instance of the VirtualOnaToOnaChild to be deleted; value cannot be null.
     */
    void delete(VirtualOnaToOnaChild virtualOnaToOnaChild);

    /**
     * Find all VirtualOnaToOnaChilds matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching VirtualOnaToOnaChilds.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<VirtualOnaToOnaChild> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all VirtualOnaToOnaChilds matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching VirtualOnaToOnaChilds.
     *
     * @see Pageable
     * @see Page
     */
    Page<VirtualOnaToOnaChild> findAll(String query, Pageable pageable);

    /**
     * Exports all VirtualOnaToOnaChilds matching the given input query to the given exportType format.
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
     * Exports all VirtualOnaToOnaChilds matching the given input query to the given exportType format.
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
     * Retrieve the count of the VirtualOnaToOnaChilds in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the VirtualOnaToOnaChild.
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