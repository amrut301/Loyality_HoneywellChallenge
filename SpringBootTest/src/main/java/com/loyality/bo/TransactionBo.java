package com.loyality.bo;

import java.util.Date;

import com.loyality.bo.constants.TransactionType;

public class TransactionBo extends BaseBo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer transactionId;
	
	private String transactionName; // probably the name/ date of the transaction!
	
	private TransactionType transactionType;
	
	private Integer points;
	
	private Boolean isRedeeming;
	
	private Date transactionDt;

	public Date getTransactionDt() {
		return transactionDt;
	}

	public void setTransactionDt(Date transactionDt) {
		this.transactionDt = transactionDt;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionName() {
		return transactionName;
	}

	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Boolean getIsRedeeming() {
		return isRedeeming;
	}

	public void setIsRedeeming(Boolean isRedeeming) {
		this.isRedeeming = isRedeeming;
	}
	
	

}
