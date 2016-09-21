package ie.com.fexco.eircode.api.to;

public class AddressTO {

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

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public String getPremise() {
		return premise;
	}

	public void setPremise(String premise) {
		this.premise = premise;
	}

	public String getDependentstreet() {
		return dependentstreet;
	}

	public void setDependentstreet(String dependentstreet) {
		this.dependentstreet = dependentstreet;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDoubledependentlocality() {
		return doubledependentlocality;
	}

	public void setDoubledependentlocality(String doubledependentlocality) {
		this.doubledependentlocality = doubledependentlocality;
	}

	public String getDependentlocality() {
		return dependentlocality;
	}

	public void setDependentlocality(String dependentlocality) {
		this.dependentlocality = dependentlocality;
	}

	public String getPosttown() {
		return posttown;
	}

	public void setPosttown(String posttown) {
		this.posttown = posttown;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getSummaryline() {
		return summaryline;
	}

	public void setSummaryline(String summaryline) {
		this.summaryline = summaryline;
	}

	@Override
	public String toString() {
		return "AddressTO [organisation=" + organisation + ", premise=" + premise + ", dependentstreet="
				+ dependentstreet + ", street=" + street + ", doubledependentlocality=" + doubledependentlocality
				+ ", dependentlocality=" + dependentlocality + ", posttown=" + posttown + ", county=" + county
				+ ", postcode=" + postcode + ", summaryline=" + summaryline + "]";
	}

}
