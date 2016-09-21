package ie.com.fexco.eircode.api.to.response;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import ie.com.fexco.eircode.api.base.to.BaseResponseTO;
@JsonInclude(Include.NON_NULL)
public class AddressAutocompleteResponseTO extends BaseResponseTO {

	private static final long serialVersionUID = -5016125431392722561L;
	private String status;
	private Set<AddressPredictionResponseTO> predictions;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<AddressPredictionResponseTO> getPredictions() {
		return predictions;
	}

	public void setPredictions(Set<AddressPredictionResponseTO> predictions) {
		this.predictions = predictions;
	}

}
