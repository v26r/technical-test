package TechincalTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import httpclient.HttpApiClient;
import httpclient.HttpApiResponse;
import model.Video;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;

import com.google.gson.Gson;

import org.junit.Assert;


public class VideoSteps {

	HttpApiResponse apiResponse = null;
	
	@When("^the client requests video by \"([^\"]*)\"$")
	public void client_request_video_by_id( String id ) throws Throwable {
		
		apiResponse = HttpApiClient.Get("/api/video/" +id);
		
    }
	
    @Then("^the response code should be (\\d+)$")
    public void response_code_should_be(int code) {
    	assertThat(apiResponse.getStatusCode(),is(code));    	
    }      
	
	@And("^video has the following attributes and values:$")	
	public void video_is_(List<Video> videos) throws JSONException {
		
		String output = apiResponse.getResponceContent();
				
		Gson gson = new Gson();			  	
		String input = gson.toJson(videos.get(0), Video.class);				
		
		JSONAssert.assertEquals(input,output, false);
		 	
    }
	
/*	@When("^the client requests list of all videos$")
	public void client_requests_list_of_all_videos( ) throws Throwable {
		apiResponse = null;
		apiResponse = HttpApiClient.Get("/api/video");		
    }
	
	@And("^list returns the following videos:$")	
	public void list_returns_the_following_videos_(List<Video> videos) throws JsonIOException, ParseException, JSONException {
		
		String output = apiResponse.getResponceContent();
		JSONArray jsonarray = new JSONArray(output);
				
		Gson gson = new Gson();
		
		for( Video video : videos ) {
						
			for (int i = 0; i < jsonarray.length();) {
			    JSONObject jsonobject = jsonarray.getJSONObject(i);			   
						 		      
		        String input = gson.toJson(video, Video.class);
				 
		        JSONAssert.assertEquals(input,jsonobject, false);
		        
			}
		}				 	
    }*/
	
	@When("^the client adds video with following attributes:$")
	public void client_adds_video( List<Video> videos ) throws Throwable {
		Gson gson = new Gson();	
		String payload = gson.toJson(videos.get(0), Video.class);	
		
		apiResponse = HttpApiClient.Post("/api/video/",payload);
		
    }
	
	@And("^added video should have the following attributes:$")	
	public void  added_video_should_have(List<Video> videos) throws JSONException {
		
		String output = apiResponse.getResponceContent();
								
		Assert.assertNotNull(output);				
		 	
    }
	
	@When("^the client requests for patch to video by id - \"([^\"]*)\" and attribute:$")
	public void client_requests_patch_video(String id, List<String> input ) throws Throwable{
		Gson gson = new Gson();	
		String payload = gson.toJson(input);	
		
		apiResponse = HttpApiClient.Patch("/api/video/"+id,payload);
		
	}
    
	@And("^the response should be \"([^\"]*)\"$")
	public void patch_response_should_be(String expResponse) throws Throwable{
		
		String output = apiResponse.getResponceContent();
		
		assertThat(output, is(expResponse));
	
	}
	
	@When("^the client requests to delete video by id - \"([^\"]*)\"$")
	public void client_requests_delete_video(String id ) throws Throwable{
			
		apiResponse = HttpApiClient.Delete("/api/video/"+id);
		
	}
    	
	
}
