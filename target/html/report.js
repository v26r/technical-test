$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/video.feature");
formatter.feature({
  "line": 1,
  "name": "Testing Daily Song Video API",
  "description": "",
  "id": "testing-daily-song-video-api",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Get Video Songs by Id",
  "description": "",
  "id": "testing-daily-song-video-api;get-video-songs-by-id",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@test"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "the client requests video by \"5975b6c754c5f300115de8ad\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "the response code should be 200",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "video has the following attributes and values:",
  "rows": [
    {
      "cells": [
        "_id",
        "artist",
        "song",
        "publishDate",
        "date_created",
        "__v"
      ],
      "line": 9
    },
    {
      "cells": [
        "5975b6c754c5f300115de8ad",
        "Lady Gaga",
        "Poker Face",
        "2017-09-01T00:00:00.000Z",
        "2017-07-24T08:58:47.797Z",
        "0"
      ],
      "line": 10
    }
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "5975b6c754c5f300115de8ad",
      "offset": 30
    }
  ],
  "location": "VideoSteps.client_request_video_by_id(String)"
});
formatter.result({
  "duration": 802638118,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 28
    }
  ],
  "location": "VideoSteps.response_code_should_be(int)"
});
formatter.result({
  "duration": 2613048,
  "status": "passed"
});
formatter.match({
  "location": "VideoSteps.video_is_(Video\u003e)"
});
formatter.result({
  "duration": 48142533,
  "status": "passed"
});
});