package ie.com.fexco.eircode.api.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ie.com.fexco.eircode.api.base.to.BaseTO;

@Entity
@Table(name="ADD_LKP_ADD")
public class AddressLookupAddress extends BaseTO
{

	private static final long serialVersionUID = 1578198988410008467L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addresslookupaddressid;

	@ManyToOne(cascade =
	{ CascadeType.ALL })
	@JoinColumn(name = "addresslookupid")
	private AddressLookup addressLookup;

	private String organisation;
	private String premise;
	private String dependentstreet;
	private String street;
	private String doubledependentlocality;
	private String dependentlocality;
	private String posttown;
	private String county;
	private String postcode;
	private String summaryline;
	private String buildingname;
	private String addressline1;
	private String addressline2;
	private String latitude;
	private String longitude;
	private String what3words;
	private String pobox;
	private String departmentname;
	private String subbuildingname;
	private String number;
	private String recodes;
	private AddressLookup morevalues;

	public AddressLookup getAddressLookup()
	{
		return addressLookup;
	}

	public void setAddressLookup(AddressLookup addressLookup)
	{
		this.addressLookup = addressLookup;
	}

	public String getOrganisation()
	{
		return organisation;
	}

	public void setOrganisation(String organisation)
	{
		this.organisation = organisation;
	}

	public String getPremise()
	{
		return premise;
	}

	public void setPremise(String premise)
	{
		this.premise = premise;
	}

	public String getDependentstreet()
	{
		return dependentstreet;
	}

	public void setDependentstreet(String dependentstreet)
	{
		this.dependentstreet = dependentstreet;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public String getDoubledependentlocality()
	{
		return doubledependentlocality;
	}

	public void setDoubledependentlocality(String doubledependentlocality)
	{
		this.doubledependentlocality = doubledependentlocality;
	}

	public String getDependentlocality()
	{
		return dependentlocality;
	}

	public void setDependentlocality(String dependentlocality)
	{
		this.dependentlocality = dependentlocality;
	}

	public String getPosttown()
	{
		return posttown;
	}

	public void setPosttown(String posttown)
	{
		this.posttown = posttown;
	}

	public String getCounty()
	{
		return county;
	}

	public void setCounty(String county)
	{
		this.county = county;
	}

	public String getPostcode()
	{
		return postcode;
	}

	public void setPostcode(String postcode)
	{
		this.postcode = postcode;
	}

	public String getSummaryline()
	{
		return summaryline;
	}

	public void setSummaryline(String summaryline)
	{
		this.summaryline = summaryline;
	}

	public Long getAddresslookupaddressid()
	{
		return addresslookupaddressid;
	}

	public void setAddresslookupaddressid(Long addresslookupaddressid)
	{
		this.addresslookupaddressid = addresslookupaddressid;
	}

	public String getBuildingname()
	{
		return buildingname;
	}

	public void setBuildingname(String buildingname)
	{
		this.buildingname = buildingname;
	}

	public String getAddressline1()
	{
		return addressline1;
	}

	public void setAddressline1(String addressline1)
	{
		this.addressline1 = addressline1;
	}

	public String getAddressline2()
	{
		return addressline2;
	}

	public void setAddressline2(String addressline2)
	{
		this.addressline2 = addressline2;
	}

	public String getLatitude()
	{
		return latitude;
	}

	public void setLatitude(String latitude)
	{
		this.latitude = latitude;
	}

	public String getLongitude()
	{
		return longitude;
	}

	public void setLongitude(String longitude)
	{
		this.longitude = longitude;
	}

	public String getWhat3words()
	{
		return what3words;
	}

	public void setWhat3words(String what3words)
	{
		this.what3words = what3words;
	}

	public String getPobox()
	{
		return pobox;
	}

	public void setPobox(String pobox)
	{
		this.pobox = pobox;
	}

	public String getDepartmentname()
	{
		return departmentname;
	}

	public void setDepartmentname(String departmentname)
	{
		this.departmentname = departmentname;
	}

	public String getSubbuildingname()
	{
		return subbuildingname;
	}

	public void setSubbuildingname(String subbuildingname)
	{
		this.subbuildingname = subbuildingname;
	}

	public String getNumber()
	{
		return number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public String getRecodes()
	{
		return recodes;
	}

	public void setRecodes(String recodes)
	{
		this.recodes = recodes;
	}

	public AddressLookup isMorevalues()
	{
		return morevalues;
	}

	public void setMorevalues(AddressLookup morevalues)
	{
		this.morevalues = morevalues;
	}

}
