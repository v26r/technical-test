/**
 * 
 */
package httpclient;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;

public class HttpApiClient {
	
	private static String baseUrl = "http://turing.niallbunting.com:3006";
						
	public static HttpApiResponse Get(String resource) throws IOException{
		HttpResponse response = null;
								
		try {
			response =  Request.Get(baseUrl+resource).
					   addHeader("Content-Type", "application/json").
					   execute().returnResponse();
			
			String responseContent = EntityUtils.toString(response.getEntity());
						
			return new HttpApiResponse(response.getStatusLine().getStatusCode(), responseContent);
			
		} catch (Exception e) {
			if(e instanceof HttpResponseException)
				return new HttpApiResponse(response.getStatusLine().getStatusCode(), e.getMessage());
			throw new RuntimeException(e.getMessage(), e.getCause());
		}
	}
		
	public static HttpApiResponse Post(String resource,String data ) throws IOException{
		HttpResponse response = null;
		try {
			response = (HttpResponse) Request.Post(baseUrl+resource).
					   addHeader("Content-Type", "application/json").
					   bodyString(data, ContentType.create("application/json")).
					   execute().returnResponse();
			
			String responseContent = EntityUtils.toString(response.getEntity());
			
			return new HttpApiResponse(response.getStatusLine().getStatusCode(), responseContent);
		} catch (Exception e) {
			if(e instanceof HttpResponseException)
				return new HttpApiResponse(response.getStatusLine().getStatusCode(), e.getMessage());
			throw new RuntimeException(e.getMessage(), e.getCause());
		}
	}
		
	public static HttpApiResponse Patch(String resource,String data) throws IOException{
		HttpResponse response = null;
		try {
			response = (HttpResponse) Request.Patch(baseUrl+resource).
					   addHeader("Content-Type", "application/json").
					   bodyString(data, ContentType.create("application/json")).
					   execute().returnResponse();
			
			String responseContent = EntityUtils.toString(response.getEntity());
			
			return new HttpApiResponse(response.getStatusLine().getStatusCode(), responseContent);
		} catch (Exception e) {
			if(e instanceof HttpResponseException)
				return new HttpApiResponse(response.getStatusLine().getStatusCode(), e.getMessage());
			throw new RuntimeException(e.getMessage(), e.getCause());
		}
	}
	
	public static HttpApiResponse Delete(String resource) throws IOException{
		HttpResponse response = null;
		try {
			response = (HttpResponse) Request.Delete(baseUrl+resource).
					   addHeader("Content-Type", "application/json").
					   execute().returnResponse();
			
			String responseContent = EntityUtils.toString(response.getEntity());
			
			return new HttpApiResponse(response.getStatusLine().getStatusCode(), responseContent);
		} catch (Exception e) {
			if(e instanceof HttpResponseException)
				return new HttpApiResponse(response.getStatusLine().getStatusCode(), e.getMessage());
			throw new RuntimeException(e.getMessage(), e.getCause());
		}
	}
		
}
