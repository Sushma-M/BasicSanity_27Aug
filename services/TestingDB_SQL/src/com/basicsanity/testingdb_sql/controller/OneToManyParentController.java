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

import com.basicsanity.testingdb_sql.OneToManyChild;
import com.basicsanity.testingdb_sql.OneToManyParent;
import com.basicsanity.testingdb_sql.service.OneToManyParentService;


/**
 * Controller object for domain model class OneToManyParent.
 * @see OneToManyParent
 */
@RestController("TestingDB_SQL.OneToManyParentController")
@Api(value = "OneToManyParentController", description = "Exposes APIs to work with OneToManyParent resource.")
@RequestMapping("/TestingDB_SQL/OneToManyParent")
public class OneToManyParentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OneToManyParentController.class);

    @Autowired
	@Qualifier("TestingDB_SQL.OneToManyParentService")
	private OneToManyParentService oneToManyParentService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new OneToManyParent instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public OneToManyParent createOneToManyParent(@RequestBody OneToManyParent oneToManyParent) {
		LOGGER.debug("Create OneToManyParent with information: {}" , oneToManyParent);

		oneToManyParent = oneToManyParentService.create(oneToManyParent);
		LOGGER.debug("Created OneToManyParent with information: {}" , oneToManyParent);

	    return oneToManyParent;
	}

    @ApiOperation(value = "Returns the OneToManyParent instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public OneToManyParent getOneToManyParent(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting OneToManyParent with id: {}" , id);

        OneToManyParent foundOneToManyParent = oneToManyParentService.getById(id);
        LOGGER.debug("OneToManyParent details with id: {}" , foundOneToManyParent);

        return foundOneToManyParent;
    }

    @ApiOperation(value = "Updates the OneToManyParent instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public OneToManyParent editOneToManyParent(@PathVariable("id") Integer id, @RequestBody OneToManyParent oneToManyParent) {
        LOGGER.debug("Editing OneToManyParent with id: {}" , oneToManyParent.getPkColumn());

        oneToManyParent.setPkColumn(id);
        oneToManyParent = oneToManyParentService.update(oneToManyParent);
        LOGGER.debug("OneToManyParent details with id: {}" , oneToManyParent);

        return oneToManyParent;
    }

    @ApiOperation(value = "Deletes the OneToManyParent instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteOneToManyParent(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting OneToManyParent with id: {}" , id);

        OneToManyParent deletedOneToManyParent = oneToManyParentService.delete(id);

        return deletedOneToManyParent != null;
    }

    /**
     * @deprecated Use {@link #findOneToManyParents(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of OneToManyParent instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<OneToManyParent> searchOneToManyParentsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering OneToManyParents list by query filter:{}", (Object) queryFilters);
        return oneToManyParentService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of OneToManyParent instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<OneToManyParent> findOneToManyParents(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering OneToManyParents list by filter:", query);
        return oneToManyParentService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of OneToManyParent instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<OneToManyParent> filterOneToManyParents(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering OneToManyParents list by filter", query);
        return oneToManyParentService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportOneToManyParents(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return oneToManyParentService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportOneToManyParentsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = OneToManyParent.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> oneToManyParentService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of OneToManyParent instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countOneToManyParents( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting OneToManyParents");
		return oneToManyParentService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getOneToManyParentAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return oneToManyParentService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/oneToManyChilds", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the oneToManyChilds instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<OneToManyChild> findAssociatedOneToManyChilds(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated oneToManyChilds");
        return oneToManyParentService.findAssociatedOneToManyChilds(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service OneToManyParentService instance
	 */
	protected void setOneToManyParentService(OneToManyParentService service) {
		this.oneToManyParentService = service;
	}

}