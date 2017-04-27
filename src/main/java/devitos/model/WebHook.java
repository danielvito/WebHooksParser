package devitos.model;

/**
 * Webhook model.
 * 
 * @author daniel.silveira
 */
public class WebHook {

	public String level;
	public String responseBody;
	public String requestTo;
	public String responseHeaders;
	public String responseStatus;

	@Override
	public String toString() {
		return "[level:" + level + ", responseBody:" + responseBody + ", requestTo:" + requestTo + ", responseHeaders:"
				+ responseHeaders + ", responseStatus:" + responseStatus + "]";
	}

}
