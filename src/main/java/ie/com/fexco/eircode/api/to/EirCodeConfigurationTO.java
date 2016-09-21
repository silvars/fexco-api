package ie.com.fexco.eircode.api.to;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "eircode.properties")
public class EirCodeConfigurationTO
{

	@Value("${eircode.baseUrl}")
	private String baseURL;

	@Value("${eircode.searchKey}")
	private String searchKey;

	public String getSearchKey()
	{
		return searchKey;
	}

	public void setSearchKey(String searchKey)
	{
		this.searchKey = searchKey;
	}

	public String getBaseURL()
	{
		return baseURL;
	}

	public void setBaseURL(String baseURL)
	{
		this.baseURL = baseURL;
	}

}
