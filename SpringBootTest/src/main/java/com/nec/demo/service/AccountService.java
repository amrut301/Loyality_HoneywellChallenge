package com.nec.demo.service;

import com.loyality.bo.AccountBo;
import com.loyality.bo.exception.ServiceException;
import com.loyality.dao.entities.Account;

/**
 * @author amrmalaj
 *
 */
public interface AccountService {

	Account getAccountDetails(Integer id) throws ServiceException;

	Integer saveAccount(AccountBo account) throws ServiceException;

}
