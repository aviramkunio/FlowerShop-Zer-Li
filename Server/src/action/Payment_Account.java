package action;

import java.io.Serializable;

public class Payment_Account implements Serializable {

	private String ID, CreditCard, Subscription, Status;
	
	public Payment_Account(String id,String creditcard, String subscription, String status)
	{
		this.ID = id;
		this.CreditCard = creditcard;
		this.Subscription = subscription;
		this.Status = status;
	}
	
	public String getID()
	{
		return this.ID;
	}
	
	public void setID(String id)
	{
		this.ID = id;
	}
	
	public String getCreditCard()
	{
		return this.CreditCard;
	}
	
	public void setCreditCard(String creditcard)
	{
		this.CreditCard = creditcard;
	}
	
	public String getSubscription()
	{
		return this.Subscription;
	}
	
	public void setSubscription(String subscription)
	{
		this.Subscription = subscription;
	}
	
	public String getStatus()
	{
		return this.Status;
	}
	
	public void setStatus(String status)
	{
		this.Status = status;
	}
}