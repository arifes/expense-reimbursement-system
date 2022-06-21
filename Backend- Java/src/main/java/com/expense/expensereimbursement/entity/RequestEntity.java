package com.expense.expensereimbursement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="requests")
public class RequestEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="request_id") 
	private int requestId;
	
	@JoinColumn 
	@Column(name="request_userid")
	private int userId;
	
	@Column(name="request_amount")
	private double requestAmount;
	
	@Column(name="request_description")
	private String requestDescription;
	
	@Column(name="request_status")
	private String requestStatus;
	
	@Column(name="request_imageurl")
	private String requestImageURL;

	public RequestEntity() {
	
	}

	
	public RequestEntity(int userId, double requestAmount, String requestDescription, String requestStatus,
			String requestImageURL) {
		super();
		this.userId = userId;
		this.requestAmount = requestAmount;
		this.requestDescription = requestDescription;
		this.requestStatus = requestStatus;
		this.requestImageURL = requestImageURL;

	}


	

	public RequestEntity(int requestId, int userId, double requestAmount, String requestDescription,
			String requestStatus, String requestImageURL) {
		super();
		this.requestId = requestId;
		this.userId = userId;
		this.requestAmount = requestAmount;
		this.requestDescription = requestDescription;
		this.requestStatus = requestStatus;
		this.requestImageURL = requestImageURL;

	}


	public int getRequestId() {
		return requestId;
	}


	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public double getRequestAmount() {
		return requestAmount;
	}


	public void setRequestAmount(double requestAmount) {
		this.requestAmount = requestAmount;
	}


	public String getRequestDescription() {
		return requestDescription;
	}


	public void setRequestDescription(String requestDescription) {
		this.requestDescription = requestDescription;
	}


	public String getRequestStatus() {
		return requestStatus;
	}


	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}


	public String getRequestImageURL() {
		return requestImageURL;
	}


	public void setRequestImageURL(String requestImageURL) {
		this.requestImageURL = requestImageURL;
	}


	@Override
	public String toString() {
		return "RequestEntity [requestId=" + requestId + ", userId=" + userId + ", requestAmount=" + requestAmount
				+ ", requestDescription=" + requestDescription + ", requestStatus=" + requestStatus
				+ ", requestImageURL=" + requestImageURL + "]";
	}




	


	
}
