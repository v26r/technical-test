Feature: Testing Daily Song Playlist API

 @wip
 Scenario: Delete playlist by id
 
    When the client requests to delete playlist by id - "59731d7b54c5f300115de8a7" 
    Then the response code should be 204
	And the response should be "N/A"
  
 @wip 
  Scenario: Get list of playlists 
  
    When the client requests list of all playlists
    Then the response code should be 200
    And  list returns the following videos:
    |_id| desc   |  title  | date_created  | __v|
    |* | My First playlist |  My List | 2017-07-23T00:00:00.000Z |0|
	|* | Top 40 playlist. |  Top 40 | 2017-07-23T00:00:00.000Z |0|  
 
	
 @wip
 Scenario: Create a playlist
 
    When the client creates playlist following attributes:
    | desc   |  title  | 
	| My First playlist |  My List |  
    Then the response code should be 201
	And added plalist should have the following attributes:
    |_id| desc   |  title  |  __v|videos|
    |* | My First playlist |  My List | 0||
	|* | Top 40 playlist. |  Top 40 |0| |
  	
   
  @wip 
 Scenario: Get playlist by Id
 
    When the client requests video by "59731d7b54c5f300115d65865"
    Then the response code should be 200
	And video has the following attributes and values:
     |_id| desc   |  title  | date_created  | __v| Videos|
    |* | My First playlist |  My List | 2017-07-23T00:00:00.000Z |0||
	|* | Top 40 playlist. |  Top 40 | 2017-07-23T00:00:00.000Z |0||
	
 @wip
 Scenario: Patch Video Song with given attributes
 
    When the client requests for patch to video by id - "59731d7b54c5f300115de8a7" and attribute:
      | publishDate | 
	  | 2017-08-01T00:00:00.000Z |
    Then the response code should be 501
	And the response should be "Not implemented."