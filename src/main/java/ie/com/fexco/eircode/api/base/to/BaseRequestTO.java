package ie.com.fexco.eircode.api.base.to;

import ie.com.fexco.eircode.api.base.interfaces.AdditionalParameters;
import ie.com.fexco.eircode.api.util.EirCodeUtil;

/**
 * @author Rodrigo M. Silva
 * 
 * An abstract class that represents commons attributes.
 *
 */
public abstract class BaseRequestTO extends BaseTO implements AdditionalParameters {

	private static final long serialVersionUID = -6823786827472184308L;

	protected String format = EirCodeUtil.JSON;
	protected String country; 
	protected Integer lines;
	protected String include;
	protected String exclude;
	protected String addTags;
	protected String identifier;
	protected String callback;
	protected String page;
	protected String postCodeOnly;

}
