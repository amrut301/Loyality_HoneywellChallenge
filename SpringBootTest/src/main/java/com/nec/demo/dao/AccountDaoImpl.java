package com.nec.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.loyality.bo.exception.DaoException;
import com.loyality.dao.entities.Account;

/**
 * @author amrmalaj
 *
 */
@Repository("accountDao")
public class AccountDaoImpl extends AbstractBaseDao implements AccountDao {
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account getAccountDetails(Integer id) throws DaoException {
		try {
			return accountRepository.findById(id).get();
		} catch (Exception e) {
			System.out.println("Erro at Dao layer");
			throw new DaoException(e.getMessage());
		}
	}

	@Override
	public Integer saveAccount(Account account) throws DaoException {
		Integer accountId=null;
		try {
		accountId=accountRepository.save(account).getAccountId();
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		return accountId;

	}

}
