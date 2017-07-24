package httpclient;

public class HttpApiResponse {

	  int statusCode;
	    
	    String responceContent;
		
		public int getStatusCode() {
			return statusCode;
		}

		public String getResponceContent() {
			return responceContent;
		}
		
		public HttpApiResponse(int statusCode,String responceContent) {
			this.statusCode = statusCode;
			this.responceContent = responceContent;
		}	
	
}
