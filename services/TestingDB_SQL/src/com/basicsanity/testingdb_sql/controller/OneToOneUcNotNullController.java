/*Copyright (c) 2018-2019 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.basicsanity.testingdb_sql.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.manager.ExportedFileManager;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.basicsanity.testingdb_sql.OneToOneUcNotNull;
import com.basicsanity.testingdb_sql.service.OneToOneUcNotNullService;


/**
 * Controller object for domain model class OneToOneUcNotNull.
 * @see OneToOneUcNotNull
 */
@RestController("TestingDB_SQL.OneToOneUcNotNullController")
@Api(value = "OneToOneUcNotNullController", description = "Exposes APIs to work with OneToOneUcNotNull resource.")
@RequestMapping("/TestingDB_SQL/OneToOneUcNotNull")
public class OneToOneUcNotNullController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OneToOneUcNotNullController.class);

    @Autowired
	@Qualifier("TestingDB_SQL.OneToOneUcNotNullService")
	private OneToOneUcNotNullService oneToOneUcNotNullService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new OneToOneUcNotNull instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public OneToOneUcNotNull createOneToOneUcNotNull(@RequestBody OneToOneUcNotNull oneToOneUcNotNull) {
		LOGGER.debug("Create OneToOneUcNotNull with information: {}" , oneToOneUcNotNull);

		oneToOneUcNotNull = oneToOneUcNotNullService.create(oneToOneUcNotNull);
		LOGGER.debug("Created OneToOneUcNotNull with information: {}" , oneToOneUcNotNull);

	    return oneToOneUcNotNull;
	}

    @ApiOperation(value = "Returns the OneToOneUcNotNull instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public OneToOneUcNotNull getOneToOneUcNotNull(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting OneToOneUcNotNull with id: {}" , id);

        OneToOneUcNotNull foundOneToOneUcNotNull = oneToOneUcNotNullService.getById(id);
        LOGGER.debug("OneToOneUcNotNull details with id: {}" , foundOneToOneUcNotNull);

        return foundOneToOneUcNotNull;
    }

    @ApiOperation(value = "Updates the OneToOneUcNotNull instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public OneToOneUcNotNull editOneToOneUcNotNull(@PathVariable("id") Integer id, @RequestBody OneToOneUcNotNull oneToOneUcNotNull) {
        LOGGER.debug("Editing OneToOneUcNotNull with id: {}" , oneToOneUcNotNull.getId());

        oneToOneUcNotNull.setId(id);
        oneToOneUcNotNull = oneToOneUcNotNullService.update(oneToOneUcNotNull);
        LOGGER.debug("OneToOneUcNotNull details with id: {}" , oneToOneUcNotNull);

        return oneToOneUcNotNull;
    }

    @ApiOperation(value = "Deletes the OneToOneUcNotNull instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteOneToOneUcNotNull(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting OneToOneUcNotNull with id: {}" , id);

        OneToOneUcNotNull deletedOneToOneUcNotNull = oneToOneUcNotNullService.delete(id);

        return deletedOneToOneUcNotNull != null;
    }

    @RequestMapping(value = "/column3/{column3}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching OneToOneUcNotNull with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public OneToOneUcNotNull getByColumn3(@PathVariable("column3") int column3) {
        LOGGER.debug("Getting OneToOneUcNotNull with uniques key Column3");
        return oneToOneUcNotNullService.getByColumn3(column3);
    }

    /**
     * @deprecated Use {@link #findOneToOneUcNotNulls(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of OneToOneUcNotNull instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<OneToOneUcNotNull> searchOneToOneUcNotNullsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering OneToOneUcNotNulls list by query filter:{}", (Object) queryFilters);
        return oneToOneUcNotNullService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of OneToOneUcNotNull instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<OneToOneUcNotNull> findOneToOneUcNotNulls(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering OneToOneUcNotNulls list by filter:", query);
        return oneToOneUcNotNullService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of OneToOneUcNotNull instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<OneToOneUcNotNull> filterOneToOneUcNotNulls(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering OneToOneUcNotNulls list by filter", query);
        return oneToOneUcNotNullService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportOneToOneUcNotNulls(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return oneToOneUcNotNullService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportOneToOneUcNotNullsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = OneToOneUcNotNull.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> oneToOneUcNotNullService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of OneToOneUcNotNull instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countOneToOneUcNotNulls( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting OneToOneUcNotNulls");
		return oneToOneUcNotNullService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getOneToOneUcNotNullAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return oneToOneUcNotNullService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service OneToOneUcNotNullService instance
	 */
	protected void setOneToOneUcNotNullService(OneToOneUcNotNullService service) {
		this.oneToOneUcNotNullService = service;
	}

}