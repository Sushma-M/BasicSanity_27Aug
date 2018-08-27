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

import com.basicsanity.testingdb_sql.JoiningDetails;
import com.basicsanity.testingdb_sql.SalaryDetails;
import com.basicsanity.testingdb_sql.service.SalaryDetailsService;


/**
 * Controller object for domain model class SalaryDetails.
 * @see SalaryDetails
 */
@RestController("TestingDB_SQL.SalaryDetailsController")
@Api(value = "SalaryDetailsController", description = "Exposes APIs to work with SalaryDetails resource.")
@RequestMapping("/TestingDB_SQL/SalaryDetails")
public class SalaryDetailsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SalaryDetailsController.class);

    @Autowired
	@Qualifier("TestingDB_SQL.SalaryDetailsService")
	private SalaryDetailsService salaryDetailsService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new SalaryDetails instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SalaryDetails createSalaryDetails(@RequestBody SalaryDetails salaryDetails) {
		LOGGER.debug("Create SalaryDetails with information: {}" , salaryDetails);

		salaryDetails = salaryDetailsService.create(salaryDetails);
		LOGGER.debug("Created SalaryDetails with information: {}" , salaryDetails);

	    return salaryDetails;
	}

    @ApiOperation(value = "Returns the SalaryDetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SalaryDetails getSalaryDetails(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting SalaryDetails with id: {}" , id);

        SalaryDetails foundSalaryDetails = salaryDetailsService.getById(id);
        LOGGER.debug("SalaryDetails details with id: {}" , foundSalaryDetails);

        return foundSalaryDetails;
    }

    @ApiOperation(value = "Updates the SalaryDetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SalaryDetails editSalaryDetails(@PathVariable("id") Integer id, @RequestBody SalaryDetails salaryDetails) {
        LOGGER.debug("Editing SalaryDetails with id: {}" , salaryDetails.getAccountId());

        salaryDetails.setAccountId(id);
        salaryDetails = salaryDetailsService.update(salaryDetails);
        LOGGER.debug("SalaryDetails details with id: {}" , salaryDetails);

        return salaryDetails;
    }

    @ApiOperation(value = "Deletes the SalaryDetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteSalaryDetails(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting SalaryDetails with id: {}" , id);

        SalaryDetails deletedSalaryDetails = salaryDetailsService.delete(id);

        return deletedSalaryDetails != null;
    }

    /**
     * @deprecated Use {@link #findSalaryDetails(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of SalaryDetails instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SalaryDetails> searchSalaryDetailsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering SalaryDetails list by query filter:{}", (Object) queryFilters);
        return salaryDetailsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SalaryDetails instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SalaryDetails> findSalaryDetails(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SalaryDetails list by filter:", query);
        return salaryDetailsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SalaryDetails instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SalaryDetails> filterSalaryDetails(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SalaryDetails list by filter", query);
        return salaryDetailsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSalaryDetails(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return salaryDetailsService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportSalaryDetailsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = SalaryDetails.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> salaryDetailsService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of SalaryDetails instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countSalaryDetails( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting SalaryDetails");
		return salaryDetailsService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getSalaryDetailsAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return salaryDetailsService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/joiningDetailses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the joiningDetailses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<JoiningDetails> findAssociatedJoiningDetailses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated joiningDetailses");
        return salaryDetailsService.findAssociatedJoiningDetailses(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SalaryDetailsService instance
	 */
	protected void setSalaryDetailsService(SalaryDetailsService service) {
		this.salaryDetailsService = service;
	}

}