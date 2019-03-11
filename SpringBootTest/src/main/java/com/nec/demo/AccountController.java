package com.nec.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loyality.bo.AccountBo;
import com.loyality.bo.constants.UrlConstants;
import com.loyality.bo.exception.ServiceException;
import com.nec.demo.service.AccountService;

/**
 * @author amrmalaj
 *
 */
@RestController

@RequestMapping(UrlConstants.BASE_API)
public class AccountController {
	@Autowired
	private AccountService accountSerivce;

	/*
	 * @ApiOperation(value = "Creates new project or updates existing one", notes =
	 * "", produces = MediaType.APPLICATION_JSON_VALUE)
	 * 
	 * @ApiResponses(value = { @ApiResponse(code = 200, message =
	 * "account details"),
	 * 
	 * @ApiResponse(code = 404, message = "In valid parameter for account id"),
	 * 
	 * @ApiResponse(code = 406, message = "bad request") })
	 */
	@GetMapping(value = UrlConstants.ACCOUNT_BASE + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> getAccountDetail(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity<>(accountSerivce.getAccountDetails(id), HttpStatus.OK);
		} catch (ServiceException e) {
			System.out.println("Exception in controller");
		}
		return null;
	}

	@PostMapping(value = UrlConstants.ACCOUNT_BASE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> saveAccountDetail(@RequestBody AccountBo account) {
		try {
			return new ResponseEntity<>(accountSerivce.saveAccount(account), HttpStatus.OK);
		} catch (ServiceException e) {
			System.out.println("Exception in controller");
		}
		return null;
	}

}
