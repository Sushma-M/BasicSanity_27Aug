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

import com.basicsanity.testingdb_sql.OneToManyChild;
import com.basicsanity.testingdb_sql.OneToManyParent;

/**
 * Service object for domain model class {@link OneToManyParent}.
 */
public interface OneToManyParentService {

    /**
     * Creates a new OneToManyParent. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on OneToManyParent if any.
     *
     * @param oneToManyParent Details of the OneToManyParent to be created; value cannot be null.
     * @return The newly created OneToManyParent.
     */
    OneToManyParent create(@Valid OneToManyParent oneToManyParent);


	/**
     * Returns OneToManyParent by given id if exists.
     *
     * @param onetomanyparentId The id of the OneToManyParent to get; value cannot be null.
     * @return OneToManyParent associated with the given onetomanyparentId.
	 * @throws EntityNotFoundException If no OneToManyParent is found.
     */
    OneToManyParent getById(Integer onetomanyparentId);

    /**
     * Find and return the OneToManyParent by given id if exists, returns null otherwise.
     *
     * @param onetomanyparentId The id of the OneToManyParent to get; value cannot be null.
     * @return OneToManyParent associated with the given onetomanyparentId.
     */
    OneToManyParent findById(Integer onetomanyparentId);

	/**
     * Find and return the list of OneToManyParents by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param onetomanyparentIds The id's of the OneToManyParent to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return OneToManyParents associated with the given onetomanyparentIds.
     */
    List<OneToManyParent> findByMultipleIds(List<Integer> onetomanyparentIds, boolean orderedReturn);


    /**
     * Updates the details of an existing OneToManyParent. It replaces all fields of the existing OneToManyParent with the given oneToManyParent.
     *
     * This method overrides the input field values using Server side or database managed properties defined on OneToManyParent if any.
     *
     * @param oneToManyParent The details of the OneToManyParent to be updated; value cannot be null.
     * @return The updated OneToManyParent.
     * @throws EntityNotFoundException if no OneToManyParent is found with given input.
     */
    OneToManyParent update(@Valid OneToManyParent oneToManyParent);

    /**
     * Deletes an existing OneToManyParent with the given id.
     *
     * @param onetomanyparentId The id of the OneToManyParent to be deleted; value cannot be null.
     * @return The deleted OneToManyParent.
     * @throws EntityNotFoundException if no OneToManyParent found with the given id.
     */
    OneToManyParent delete(Integer onetomanyparentId);

    /**
     * Deletes an existing OneToManyParent with the given object.
     *
     * @param oneToManyParent The instance of the OneToManyParent to be deleted; value cannot be null.
     */
    void delete(OneToManyParent oneToManyParent);

    /**
     * Find all OneToManyParents matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching OneToManyParents.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<OneToManyParent> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all OneToManyParents matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching OneToManyParents.
     *
     * @see Pageable
     * @see Page
     */
    Page<OneToManyParent> findAll(String query, Pageable pageable);

    /**
     * Exports all OneToManyParents matching the given input query to the given exportType format.
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
     * Exports all OneToManyParents matching the given input query to the given exportType format.
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
     * Retrieve the count of the OneToManyParents in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the OneToManyParent.
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
     * Returns the associated oneToManyChilds for given OneToManyParent id.
     *
     * @param pkColumn value of pkColumn; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated OneToManyChild instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<OneToManyChild> findAssociatedOneToManyChilds(Integer pkColumn, Pageable pageable);

}