package ie.com.fexco.eircode.api.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ie.com.fexco.eircode.api.base.to.BaseTO;
import ie.com.fexco.eircode.api.enums.StatusEnum;

/**
 * @author Rodrigo M. Silva
 * 
 *         Represents a cache table. Has the request informations (Requested
 *         URL, Status {0 = Active or 1 = Inactive (to control cache), hits
 *         (incremented on each request) and requested date. }
 * 
 *
 */
@Entity
@Table(name = "ADD_LKP")
public class AddressLookup extends BaseTO
{

	private static final long serialVersionUID = 1578198988410008467L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addresslookupid;

	private StatusEnum status;
	private String requestedURL;
	private Date requestedData;
	private Integer hits;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "JOIN_TABLE", joinColumns =
	{ @JoinColumn(name = "addresslookupaddressid", referencedColumnName = "addresslookupid") }, inverseJoinColumns =
	{ @JoinColumn(name = "addresslookupid", referencedColumnName = "addresslookupaddressid") })
	private Set<AddressLookupAddress> addresses;

	public AddressLookup()
	{
		super();
	}

	public AddressLookup(Date requestedData, String requestedURL, StatusEnum status, Integer hits, Set<AddressLookupAddress> addresses)
	{
		this.addresses = addresses;

		this.requestedURL = requestedURL;
		this.status = status;
		this.requestedData = requestedData;
		this.hits = hits;

	}

	@NotNull
	public Date getRequestedData()
	{
		return this.requestedData;
	}

	public void setRequestedData(Date requestedData)
	{
		this.requestedData = requestedData;
	}

	@NotNull
	@Column(unique = true)
	public String getRequestedURL()
	{
		return this.requestedURL;
	}

	public void setRequestedURL(String requestedURL)
	{
		this.requestedURL = requestedURL;
	}

	@NotNull
	@Enumerated(EnumType.ORDINAL)
	public StatusEnum getStatus()
	{
		return this.status;
	}

	public void setStatus(StatusEnum status)
	{
		this.status = status;
	}

	public Set<AddressLookupAddress> getAddresses()
	{
		return addresses;
	}

	public void setAddresses(Set<AddressLookupAddress> addresses)
	{
		this.addresses = addresses;
	}

	@NotNull
	public Integer getHits()
	{
		return hits;
	}

	public void setHits(Integer hits)
	{
		this.hits = hits;
	}

	public Long getAddresslookupid()
	{
		return addresslookupid;
	}

	public void setAddresslookupid(Long addresslookupid)
	{
		this.addresslookupid = addresslookupid;
	}
}
