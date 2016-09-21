package ie.com.fexco.eircode.api.to.request;

import org.apache.commons.lang3.StringUtils;

import ie.com.fexco.eircode.api.base.to.BaseRequestTO;

public class AddressLookupRequestTO extends BaseRequestTO
{

	private static final long serialVersionUID = 1578198988410008467L;

	private String postCodeAddressFragment;
	private String distance;
	private String latitude;
	private String longitude;

	public String getPostCodeAddressFragment()
	{
		return postCodeAddressFragment;
	}

	public void setPostCodeAddressFragment(String postCodeAddressFragment)
	{
		this.postCodeAddressFragment = postCodeAddressFragment;
	}

	public Integer getLines()
	{
		return lines;
	}

	public void setLines(Integer lines)
	{
		this.lines = lines;
	}

	public String getInclude()
	{
		return include;
	}

	public void setInclude(String include)
	{
		this.include = include;
	}

	public String getExclude()
	{
		return exclude;
	}

	public void setExclude(String exclude)
	{
		this.exclude = exclude;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getFormat()
	{
		return format;
	}

	public void setFormat(String format)
	{
		this.format = format;
	}

	public String getAddTags()
	{
		return addTags;
	}

	public void setAddTags(String addTags)
	{
		this.addTags = addTags;
	}

	public String getIdentifier()
	{
		return identifier;
	}

	public void setIdentifier(String identifier)
	{
		this.identifier = identifier;
	}

	public String getCallback()
	{
		return callback;
	}

	public void setCallback(String callback)
	{
		this.callback = callback;
	}

	public String getPage()
	{
		return page;
	}

	public void setPage(String page)
	{
		this.page = page;
	}

	public String getPostCodeOnly()
	{
		return postCodeOnly;
	}

	public void setPostCodeOnly(String postCodeOnly)
	{
		this.postCodeOnly = postCodeOnly;
	}

	public String getParameters()
	{

		StringBuffer sb = new StringBuffer("");

		if (format != null)
		{
			sb.append("format=").append(format).append("&");
		}

		if (lines != null)
		{
			sb.append("lines=").append(lines).append("&");
		}

		if (StringUtils.isNotEmpty(include))
		{
			sb.append("include=").append(include).append("&");
		}

		if (StringUtils.isNotEmpty(exclude))
		{
			sb.append("exclude=").append(exclude).append("&");
		}

		if (StringUtils.isNotEmpty(addTags))
		{
			sb.append("addTags=").append(addTags).append("&");
		}

		if (StringUtils.isNotEmpty(identifier))
		{
			sb.append("identifier=").append(identifier).append("&");
		}

		if (StringUtils.isNotEmpty(callback))
		{
			sb.append("callback=").append(callback).append("&");
		}

		if (StringUtils.isNotEmpty(page))
		{
			sb.append("page=").append(page).append("&");
		}

		if (StringUtils.isNotEmpty(postCodeOnly))
		{
			sb.append("postCodeOnly=").append(postCodeOnly).append("&");
		}

		if (StringUtils.isNotEmpty(distance))
		{
			sb.append("distance=").append(distance).append("&");
		}

		String temp = postCodeAddressFragment != null ? postCodeAddressFragment.trim().replaceAll(" ", "%20") : "";
		return new StringBuffer(temp.trim()).append("?").append(sb.toString()).toString();

	}

	@Override
	public String toString()
	{
		return "AddressLookupRequestTO [postCodeAddressFragment=" + postCodeAddressFragment + ", lines=" + lines + ", include=" + include + ", exclude=" + exclude + ", addTags=" + addTags + ", identifier=" + identifier + ", callback=" + callback + ", page=" + page + ", postCodeOnly=" + postCodeOnly + ", format=" + format + "]";
	}

	public String getDistance()
	{
		return distance;
	}

	public void setDistance(String distance)
	{
		this.distance = distance;
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

}
