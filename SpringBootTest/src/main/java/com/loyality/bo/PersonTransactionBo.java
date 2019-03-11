package com.loyality.bo;

import java.util.Set;

/**
 * @author amrut.malaji
 * One customer can have multiple Transaction;
 *
 */
public class PersonTransactionBo extends BaseBo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PersonBo person;
	
	private Set<TransactionBo> transactions;

	public PersonBo getPerson() {
		return person;
	}

	public void setPerson(PersonBo person) {
		this.person = person;
	}

	public Set<TransactionBo> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<TransactionBo> transactions) {
		this.transactions = transactions;
	}

}
