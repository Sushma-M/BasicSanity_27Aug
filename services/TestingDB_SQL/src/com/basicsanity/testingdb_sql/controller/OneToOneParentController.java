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

import com.basicsanity.testingdb_sql.OneToOneParent;
import com.basicsanity.testingdb_sql.service.OneToOneParentService;


/**
 * Controller object for domain model class OneToOneParent.
 * @see OneToOneParent
 */
@RestController("TestingDB_SQL.OneToOneParentController")
@Api(value = "OneToOneParentController", description = "Exposes APIs to work with OneToOneParent resource.")
@RequestMapping("/TestingDB_SQL/OneToOneParent")
public class OneToOneParentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OneToOneParentController.class);

    @Autowired
	@Qualifier("TestingDB_SQL.OneToOneParentService")
	private OneToOneParentService oneToOneParentService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new OneToOneParent instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public OneToOneParent createOneToOneParent(@RequestBody OneToOneParent oneToOneParent) {
		LOGGER.debug("Create OneToOneParent with information: {}" , oneToOneParent);

		oneToOneParent = oneToOneParentService.create(oneToOneParent);
		LOGGER.debug("Created OneToOneParent with information: {}" , oneToOneParent);

	    return oneToOneParent;
	}

    @ApiOperation(value = "Returns the OneToOneParent instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public OneToOneParent getOneToOneParent(@PathVariable("id") String id) {
        LOGGER.debug("Getting OneToOneParent with id: {}" , id);

        OneToOneParent foundOneToOneParent = oneToOneParentService.getById(id);
        LOGGER.debug("OneToOneParent details with id: {}" , foundOneToOneParent);

        return foundOneToOneParent;
    }

    @ApiOperation(value = "Updates the OneToOneParent instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public OneToOneParent editOneToOneParent(@PathVariable("id") String id, @RequestBody OneToOneParent oneToOneParent) {
        LOGGER.debug("Editing OneToOneParent with id: {}" , oneToOneParent.getId());

        oneToOneParent.setId(id);
        oneToOneParent = oneToOneParentService.update(oneToOneParent);
        LOGGER.debug("OneToOneParent details with id: {}" , oneToOneParent);

        return oneToOneParent;
    }

    @ApiOperation(value = "Deletes the OneToOneParent instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteOneToOneParent(@PathVariable("id") String id) {
        LOGGER.debug("Deleting OneToOneParent with id: {}" , id);

        OneToOneParent deletedOneToOneParent = oneToOneParentService.delete(id);

        return deletedOneToOneParent != null;
    }

    @RequestMapping(value = "/id-column2", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching OneToOneParent with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public OneToOneParent getByIdAndColumn2(@RequestParam("id") String id, @RequestParam("column2") String column2) {
        LOGGER.debug("Getting OneToOneParent with uniques key IdAndColumn2");
        return oneToOneParentService.getByIdAndColumn2(id, column2);
    }

    /**
     * @deprecated Use {@link #findOneToOneParents(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of OneToOneParent instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<OneToOneParent> searchOneToOneParentsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering OneToOneParents list by query filter:{}", (Object) queryFilters);
        return oneToOneParentService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of OneToOneParent instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<OneToOneParent> findOneToOneParents(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering OneToOneParents list by filter:", query);
        return oneToOneParentService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of OneToOneParent instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<OneToOneParent> filterOneToOneParents(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering OneToOneParents list by filter", query);
        return oneToOneParentService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportOneToOneParents(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return oneToOneParentService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportOneToOneParentsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = OneToOneParent.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> oneToOneParentService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of OneToOneParent instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countOneToOneParents( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting OneToOneParents");
		return oneToOneParentService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getOneToOneParentAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return oneToOneParentService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service OneToOneParentService instance
	 */
	protected void setOneToOneParentService(OneToOneParentService service) {
		this.oneToOneParentService = service;
	}

}