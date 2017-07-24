  Feature: Testing Daily Song Video API
 
@important 
 Scenario: Get Video Songs by Id
 
    When the client requests video by "5975b6c754c5f300115de8ad"
    Then the response code should be 200
	And video has the following attributes and values:
    |_id| artist   |  song  | publishDate | date_created  | __v|
	|5975b6c754c5f300115de8ad| Lady Gaga   | Poker Face  | 2017-09-01T00:00:00.000Z |2017-07-24T08:58:47.797Z |0|

@important
 Scenario: Post Video Songs by providing artist, song and publishDate
 
    When the client adds video with following attributes:
    | artist   |  song  | publishDate | 
	| Michael Jackson |  Disco Dancer | 2017-09-01 |   
    Then the response code should be 201
	And added video should have the following attributes:
    |_id| artist   |  song  | publishDate |__v|
	|*  | Michael Jackson |  Disco Dancer | 2017-09-01 |0|	

@important
 Scenario: Patch Video Song with given attributes
 
    When the client requests for patch to video by id - "5975b6c754c5f300115de8ad" and attribute:
      | publishDate | 
	  | 2017-08-01T00:00:00.000Z |
    Then the response code should be 501
	And the response should be "Not implemented."

@important
 Scenario: Delete Video Song By id
 
    When the client requests to delete video by id - "5975dd2f0a5db0002f181337" 
    Then the response code should be 501
	And the response should be "N/A"	
    	
	
  @wip 
  Scenario: Get list of Video Songs 
  
    When the client requests list of all videos
    Then the response code should be 200
    And  list returns the following videos:
    |_id| artist   |  song  | publishDate | date_created  | __v|
    |59731d7b54c5f300115de8a7| Ed Sheeran   |  Galway Girl | 2017-09-01T00:00:00.000Z |2017-07-22T09:40:11.501Z |0|
  