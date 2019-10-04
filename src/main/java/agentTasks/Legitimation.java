package agentTasks;

public class Legitimation {
	private String fonoApiLink = "https://fonoapi.freshpixl.com/v1/getdevice";
	
	public boolean checkLink(String url) {
		if(url.equals(this.fonoApiLink)) {
			return true;	
		} 
		else {
			return false;
		}
	}
	
	public String getDataAgent(String url) {
		switch(url) {
		case "https://fonoapi.freshpixl.com/v1/getdevice":
			return "FONOAPI_AGENT";
		default:
			return "FONOAPI_AGENT";
		}
	}
}
