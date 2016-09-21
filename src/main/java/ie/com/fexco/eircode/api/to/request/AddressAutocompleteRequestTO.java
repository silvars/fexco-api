package ie.com.fexco.eircode.api.to.request;

import org.apache.commons.lang3.StringUtils;

import ie.com.fexco.eircode.api.base.to.BaseRequestTO;

public class AddressAutocompleteRequestTO extends BaseRequestTO
{

	private static final long serialVersionUID = 254979586193324203L;

	private String autocompletesearchterm;
	private String udprn;

	public String getAutocompletesearchterm()
	{
		return autocompletesearchterm;
	}

	public void setAutocompletesearchterm(String autocompletesearchterm)
	{
		this.autocompletesearchterm = autocompletesearchterm;
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

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getExclude()
	{
		return exclude;
	}

	public void setExclude(String exclude)
	{
		this.exclude = exclude;
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

		if (StringUtils.isNotEmpty(udprn))
		{
			sb.append("udprn=").append(udprn).append("&");
		}

		if (StringUtils.isNotEmpty(postCodeOnly))
		{
			sb.append("postCodeOnly=").append(postCodeOnly).append("&");
		}
		String temp = autocompletesearchterm != null ? autocompletesearchterm.trim().replaceAll(" ", "%20") : "";
		return new StringBuffer(temp).append("?").append(sb.toString()).toString();
	}

	public String getUdprn()
	{
		return udprn;
	}

	public void setUdprn(String udprn)
	{
		this.udprn = udprn;
	}

	@Override
	public String toString()
	{
		return "AddressAutocompleteRequestTO [autocompletesearchterm=" + autocompletesearchterm + ", udprn=" + udprn + ", format=" + format + ", lines=" + lines + ", include=" + include + ", exclude=" + exclude + ", addTags=" + addTags + ", identifier=" + identifier + ", callback=" + callback + ", page=" + page + ", postCodeOnly=" + postCodeOnly
				+ "]";
	}

}
