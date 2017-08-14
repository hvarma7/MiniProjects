<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/1.11.8/semantic.min.css"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/1.11.8/semantic.min.js"></script>
<title>Map Directions</title>
</head>
<body>
	
	
<form class="ui form" method="post" action="RouteDirections">
  <div class="field">
    <label>Lattitude-1</label>
    <input type="text" name="lat1" >
  </div>
  <div class="field">
    <label>Longitude-1</label>
    <input type="text" name="long1">
  </div>
   <div class="field">
    <label>Lattitude-2</label>
    <input type="text" name="lat2" >
  </div>
  <div class="field">
    <label>Longitude-2</label>
    <input type="text" name="long2">
  </div>
  <button class="ui button" type="submit">Submit</button>
</form>	
	

</body>
</html>