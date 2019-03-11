package com.nec.demo.dao;

import com.loyality.bo.exception.DaoException;
import com.loyality.dao.entities.Account;

/**
 * @author amrmalaj
 *
 */
public interface AccountDao {

	Account getAccountDetails(Integer id) throws DaoException;

	Integer saveAccount(Account account)throws DaoException;

	
}
