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

import com.basicsanity.testingdb_sql.CompositeOneToManyChild;
import com.basicsanity.testingdb_sql.CompositeOneToManyParent;
import com.basicsanity.testingdb_sql.CompositeOneToManyParentId;
import com.basicsanity.testingdb_sql.service.CompositeOneToManyParentService;


/**
 * Controller object for domain model class CompositeOneToManyParent.
 * @see CompositeOneToManyParent
 */
@RestController("TestingDB_SQL.CompositeOneToManyParentController")
@Api(value = "CompositeOneToManyParentController", description = "Exposes APIs to work with CompositeOneToManyParent resource.")
@RequestMapping("/TestingDB_SQL/CompositeOneToManyParent")
public class CompositeOneToManyParentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompositeOneToManyParentController.class);

    @Autowired
	@Qualifier("TestingDB_SQL.CompositeOneToManyParentService")
	private CompositeOneToManyParentService compositeOneToManyParentService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new CompositeOneToManyParent instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CompositeOneToManyParent createCompositeOneToManyParent(@RequestBody CompositeOneToManyParent compositeOneToManyParent) {
		LOGGER.debug("Create CompositeOneToManyParent with information: {}" , compositeOneToManyParent);

		compositeOneToManyParent = compositeOneToManyParentService.create(compositeOneToManyParent);
		LOGGER.debug("Created CompositeOneToManyParent with information: {}" , compositeOneToManyParent);

	    return compositeOneToManyParent;
	}

    @ApiOperation(value = "Returns the CompositeOneToManyParent instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CompositeOneToManyParent getCompositeOneToManyParent(@RequestParam("compId") Integer compId, @RequestParam("compName") String compName) {

        CompositeOneToManyParentId compositeonetomanyparentId = new CompositeOneToManyParentId();
        compositeonetomanyparentId.setCompId(compId);
        compositeonetomanyparentId.setCompName(compName);

        LOGGER.debug("Getting CompositeOneToManyParent with id: {}" , compositeonetomanyparentId);
        CompositeOneToManyParent compositeOneToManyParent = compositeOneToManyParentService.getById(compositeonetomanyparentId);
        LOGGER.debug("CompositeOneToManyParent details with id: {}" , compositeOneToManyParent);

        return compositeOneToManyParent;
    }



    @ApiOperation(value = "Updates the CompositeOneToManyParent instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CompositeOneToManyParent editCompositeOneToManyParent(@RequestParam("compId") Integer compId, @RequestParam("compName") String compName, @RequestBody CompositeOneToManyParent compositeOneToManyParent) {

        compositeOneToManyParent.setCompId(compId);
        compositeOneToManyParent.setCompName(compName);

        LOGGER.debug("CompositeOneToManyParent details with id is updated with: {}" , compositeOneToManyParent);

        return compositeOneToManyParentService.update(compositeOneToManyParent);
    }


    @ApiOperation(value = "Deletes the CompositeOneToManyParent instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteCompositeOneToManyParent(@RequestParam("compId") Integer compId, @RequestParam("compName") String compName) {

        CompositeOneToManyParentId compositeonetomanyparentId = new CompositeOneToManyParentId();
        compositeonetomanyparentId.setCompId(compId);
        compositeonetomanyparentId.setCompName(compName);

        LOGGER.debug("Deleting CompositeOneToManyParent with id: {}" , compositeonetomanyparentId);
        CompositeOneToManyParent compositeOneToManyParent = compositeOneToManyParentService.delete(compositeonetomanyparentId);

        return compositeOneToManyParent != null;
    }


    /**
     * @deprecated Use {@link #findCompositeOneToManyParents(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of CompositeOneToManyParent instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CompositeOneToManyParent> searchCompositeOneToManyParentsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering CompositeOneToManyParents list by query filter:{}", (Object) queryFilters);
        return compositeOneToManyParentService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of CompositeOneToManyParent instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CompositeOneToManyParent> findCompositeOneToManyParents(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering CompositeOneToManyParents list by filter:", query);
        return compositeOneToManyParentService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of CompositeOneToManyParent instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CompositeOneToManyParent> filterCompositeOneToManyParents(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering CompositeOneToManyParents list by filter", query);
        return compositeOneToManyParentService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportCompositeOneToManyParents(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return compositeOneToManyParentService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportCompositeOneToManyParentsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = CompositeOneToManyParent.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> compositeOneToManyParentService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of CompositeOneToManyParent instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countCompositeOneToManyParents( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting CompositeOneToManyParents");
		return compositeOneToManyParentService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getCompositeOneToManyParentAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return compositeOneToManyParentService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/composite-id/compositeOneToManyChilds", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the compositeOneToManyChilds instance associated with the given composite-id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CompositeOneToManyChild> findAssociatedCompositeOneToManyChilds(@RequestParam("compId") Integer compId, @RequestParam("compName") String compName, Pageable pageable) {

        LOGGER.debug("Fetching all associated compositeOneToManyChilds");
        return compositeOneToManyParentService.findAssociatedCompositeOneToManyChilds(compId, compName, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service CompositeOneToManyParentService instance
	 */
	protected void setCompositeOneToManyParentService(CompositeOneToManyParentService service) {
		this.compositeOneToManyParentService = service;
	}

}