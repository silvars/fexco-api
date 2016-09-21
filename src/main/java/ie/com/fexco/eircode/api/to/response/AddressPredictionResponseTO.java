package ie.com.fexco.eircode.api.to.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import ie.com.fexco.eircode.api.base.to.BaseResponseTO;

@JsonInclude(Include.NON_NULL)
public class AddressPredictionResponseTO extends BaseResponseTO
{

	private static final long serialVersionUID = 7366265431155938319L;
	private String prediction;
	private String refs;
	private boolean complete;

	public String getPrediction()
	{
		return prediction;
	}

	public void setPrediction(String prediction)
	{
		this.prediction = prediction;
	}

	public String getRefs()
	{
		return refs;
	}

	public void setRefs(String refs)
	{
		this.refs = refs;
	}

	public boolean isComplete()
	{
		return complete;
	}

	public void setComplete(boolean complete)
	{
		this.complete = complete;
	}

}
