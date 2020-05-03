package com.cresloga.inventory.household.householdinventory.controller;

import java.math.BigDecimal;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

import com.cresloga.inventory.household.householdinventory.api.GroceryV1Api;
import com.cresloga.inventory.household.householdinventory.models.dto.GetAllResponse;
import com.cresloga.inventory.household.householdinventory.models.dto.GetResponse;
import com.cresloga.inventory.household.householdinventory.models.dto.Item;
import com.cresloga.inventory.household.householdinventory.models.dto.Items;
import com.cresloga.inventory.household.householdinventory.models.dto.Status;
import com.cresloga.inventory.household.householdinventory.service.GroceryService;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-02T11:32:34.017Z[GMT]")
@Controller
public class GroceryV1ApiController implements GroceryV1Api {

	private static final Logger log = LoggerFactory.getLogger(GroceryV1ApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private final GroceryService service;

	@Autowired
	public GroceryV1ApiController(ObjectMapper objectMapper, HttpServletRequest request, GroceryService service) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.service = service;
	}

	public ResponseEntity<Status> createV1(@ApiParam(value = "") @Valid @RequestBody Item body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				service.create(body);
				return new ResponseEntity<Status>(HttpStatus.CREATED);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Status>(Status.build(e), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Status>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

	public ResponseEntity<Status> deleteByIdV1(@ApiParam(value = "", required = true) @PathVariable("id") Integer id) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				service.deleteById(id);
				return new ResponseEntity<Status>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Status>(Status.build(e), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Status>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

	public ResponseEntity<GetAllResponse> getAllV1() {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				Items items = service.getAll();
				return new ResponseEntity<GetAllResponse>(GetAllResponse.build(items), HttpStatus.OK);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<GetAllResponse>(GetAllResponse.build(e), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<GetAllResponse>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

	public ResponseEntity<GetResponse> getByIdV1(
			@ApiParam(value = "", required = true) @PathVariable("id") Integer id) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				Item item = service.getById(id);
				return new ResponseEntity<GetResponse>(GetResponse.build(item), HttpStatus.OK);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<GetResponse>(GetResponse.build(e), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<GetResponse>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

	public ResponseEntity<Status> replaceByIdV1(@ApiParam(value = "", required = true) @PathVariable("id") Integer id,
			@ApiParam(value = "") @Valid @RequestBody Item body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				service.replaceById(id, body);
				return new ResponseEntity<Status>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Status>(Status.build(e), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Status>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

	public ResponseEntity<Status> updateByIdV1(@ApiParam(value = "", required = true) @PathVariable("id") Integer id,
			@ApiParam(value = "", required = true) @PathVariable("quantity") BigDecimal quantity) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				service.updateById(id, quantity);
				return new ResponseEntity<Status>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Status>(Status.build(e), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Status>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}
}
