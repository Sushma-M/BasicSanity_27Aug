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

import com.basicsanity.testingdb_sql.Table68;
import com.basicsanity.testingdb_sql.Table68Id;
import com.basicsanity.testingdb_sql.service.Table68Service;


/**
 * Controller object for domain model class Table68.
 * @see Table68
 */
@RestController("TestingDB_SQL.Table68Controller")
@Api(value = "Table68Controller", description = "Exposes APIs to work with Table68 resource.")
@RequestMapping("/TestingDB_SQL/Table68")
public class Table68Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table68Controller.class);

    @Autowired
	@Qualifier("TestingDB_SQL.Table68Service")
	private Table68Service table68Service;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new Table68 instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Table68 createTable68(@RequestBody Table68 table68) {
		LOGGER.debug("Create Table68 with information: {}" , table68);

		table68 = table68Service.create(table68);
		LOGGER.debug("Created Table68 with information: {}" , table68);

	    return table68;
	}

    @ApiOperation(value = "Returns the Table68 instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Table68 getTable68(@RequestParam("column2") String column2, @RequestParam("column3") String column3, @RequestParam("column4") Integer column4) {

        Table68Id table68Id = new Table68Id();
        table68Id.setColumn2(column2);
        table68Id.setColumn3(column3);
        table68Id.setColumn4(column4);

        LOGGER.debug("Getting Table68 with id: {}" , table68Id);
        Table68 table68 = table68Service.getById(table68Id);
        LOGGER.debug("Table68 details with id: {}" , table68);

        return table68;
    }



    @ApiOperation(value = "Updates the Table68 instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Table68 editTable68(@RequestParam("column2") String column2, @RequestParam("column3") String column3, @RequestParam("column4") Integer column4, @RequestBody Table68 table68) {

        table68.setColumn2(column2);
        table68.setColumn3(column3);
        table68.setColumn4(column4);

        LOGGER.debug("Table68 details with id is updated with: {}" , table68);

        return table68Service.update(table68);
    }


    @ApiOperation(value = "Deletes the Table68 instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTable68(@RequestParam("column2") String column2, @RequestParam("column3") String column3, @RequestParam("column4") Integer column4) {

        Table68Id table68Id = new Table68Id();
        table68Id.setColumn2(column2);
        table68Id.setColumn3(column3);
        table68Id.setColumn4(column4);

        LOGGER.debug("Deleting Table68 with id: {}" , table68Id);
        Table68 table68 = table68Service.delete(table68Id);

        return table68 != null;
    }


    /**
     * @deprecated Use {@link #findTable68s(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Table68 instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table68> searchTable68sByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Table68s list by query filter:{}", (Object) queryFilters);
        return table68Service.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Table68 instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table68> findTable68s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table68s list by filter:", query);
        return table68Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Table68 instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table68> filterTable68s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table68s list by filter", query);
        return table68Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTable68s(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return table68Service.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportTable68sAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = Table68.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> table68Service.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of Table68 instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countTable68s( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Table68s");
		return table68Service.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getTable68AggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return table68Service.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Table68Service instance
	 */
	protected void setTable68Service(Table68Service service) {
		this.table68Service = service;
	}

}