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

import com.basicsanity.testingdb_sql.ManyToOneChild;
import com.basicsanity.testingdb_sql.ManyToOneParent;
import com.basicsanity.testingdb_sql.service.ManyToOneParentService;


/**
 * Controller object for domain model class ManyToOneParent.
 * @see ManyToOneParent
 */
@RestController("TestingDB_SQL.ManyToOneParentController")
@Api(value = "ManyToOneParentController", description = "Exposes APIs to work with ManyToOneParent resource.")
@RequestMapping("/TestingDB_SQL/ManyToOneParent")
public class ManyToOneParentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManyToOneParentController.class);

    @Autowired
	@Qualifier("TestingDB_SQL.ManyToOneParentService")
	private ManyToOneParentService manyToOneParentService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new ManyToOneParent instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ManyToOneParent createManyToOneParent(@RequestBody ManyToOneParent manyToOneParent) {
		LOGGER.debug("Create ManyToOneParent with information: {}" , manyToOneParent);

		manyToOneParent = manyToOneParentService.create(manyToOneParent);
		LOGGER.debug("Created ManyToOneParent with information: {}" , manyToOneParent);

	    return manyToOneParent;
	}

    @ApiOperation(value = "Returns the ManyToOneParent instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ManyToOneParent getManyToOneParent(@PathVariable("id") String id) {
        LOGGER.debug("Getting ManyToOneParent with id: {}" , id);

        ManyToOneParent foundManyToOneParent = manyToOneParentService.getById(id);
        LOGGER.debug("ManyToOneParent details with id: {}" , foundManyToOneParent);

        return foundManyToOneParent;
    }

    @ApiOperation(value = "Updates the ManyToOneParent instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ManyToOneParent editManyToOneParent(@PathVariable("id") String id, @RequestBody ManyToOneParent manyToOneParent) {
        LOGGER.debug("Editing ManyToOneParent with id: {}" , manyToOneParent.getPkColumn());

        manyToOneParent.setPkColumn(id);
        manyToOneParent = manyToOneParentService.update(manyToOneParent);
        LOGGER.debug("ManyToOneParent details with id: {}" , manyToOneParent);

        return manyToOneParent;
    }

    @ApiOperation(value = "Deletes the ManyToOneParent instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteManyToOneParent(@PathVariable("id") String id) {
        LOGGER.debug("Deleting ManyToOneParent with id: {}" , id);

        ManyToOneParent deletedManyToOneParent = manyToOneParentService.delete(id);

        return deletedManyToOneParent != null;
    }

    /**
     * @deprecated Use {@link #findManyToOneParents(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of ManyToOneParent instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ManyToOneParent> searchManyToOneParentsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering ManyToOneParents list by query filter:{}", (Object) queryFilters);
        return manyToOneParentService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ManyToOneParent instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ManyToOneParent> findManyToOneParents(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ManyToOneParents list by filter:", query);
        return manyToOneParentService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ManyToOneParent instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ManyToOneParent> filterManyToOneParents(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ManyToOneParents list by filter", query);
        return manyToOneParentService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportManyToOneParents(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return manyToOneParentService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportManyToOneParentsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = ManyToOneParent.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> manyToOneParentService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of ManyToOneParent instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countManyToOneParents( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting ManyToOneParents");
		return manyToOneParentService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getManyToOneParentAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return manyToOneParentService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/manyToOneChilds", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the manyToOneChilds instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ManyToOneChild> findAssociatedManyToOneChilds(@PathVariable("id") String id, Pageable pageable) {

        LOGGER.debug("Fetching all associated manyToOneChilds");
        return manyToOneParentService.findAssociatedManyToOneChilds(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ManyToOneParentService instance
	 */
	protected void setManyToOneParentService(ManyToOneParentService service) {
		this.manyToOneParentService = service;
	}

}