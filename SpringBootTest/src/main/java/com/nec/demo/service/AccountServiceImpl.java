package com.nec.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loyality.bo.AccountBo;
import com.loyality.bo.exception.DaoException;
import com.loyality.bo.exception.ServiceException;
import com.loyality.dao.entities.Account;
import com.nec.demo.dao.AccountDao;

/**
 * @author amrmalaj
 *
 */
@Service("accountService")
public class AccountServiceImpl extends AbstractBaseService implements AccountService {
	@Autowired
	private AccountDao accountDao;

	@Override
	@Transactional
	public Account getAccountDetails(Integer id) throws ServiceException {
		try {
			return accountDao.getAccountDetails(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public Integer saveAccount(AccountBo accountBo) throws ServiceException {
		Account account =new Account();
		Integer accountId =null; 
		try {
//			beanUtil.copyProperties(accountBo, account);
			account.setAccountExpiry(accountBo.getAccountExpiry());
			account.setAccountNumber(accountBo.getAccountNumber());
			account.setAccountPassword(accountBo.getAccountPassword());
			account.setAccountShoppingCarts(null);
			account.setAccountUserName(accountBo.getAccountUserName());
			account.setCreatedBy("SYSTEM");
			account.setModifiedBy("SYSTEM");
			//add camel functionality to do some operations.
			accountDao.saveAccount(account);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
		return accountId;

	}

}
