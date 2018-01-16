<%--
  Created by IntelliJ IDEA.
  User: milko.mitropolitsky
  Date: 11/29/17
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<h1>Stars</h1>



<form action="http://localhost:8080/api/stars/upload" method="post" enctype="multipart/form-data">

  <p>
    Select a file : <input type="file" name="file" size="45" />
  </p>

  <input type="submit" value="Upload CSV" />
</form>


<form action="http://localhost:8080/api/stars/download" method="get">

  <input type="submit" value="Download CSV" />
</form>

<form action="http://localhost:8080/api/stars" method="get">

  <input type="submit" value="All stars" />
</form>


<h1> Search </h1>

id: <input type = "text" id="id"><br><br>
name: <input type="text" id="name"><br><br>
mass: <input type="text" id="mass"><br><br>
evolutionaryStage: <input type="password" id="evolutionaryStage"><br><br>
volume: <input type="password" id="volume"><br><br>
escapeVelocity: <input type="text" id="escapeVelocity"><br><br>
age: <input type="text" id="age"><br><br>
distanceFromEarth: <input type="text" id="distanceFromEarth"><br><br>
spectralType: <input type="password" id="spectralType"><br><br>
temperature: <input type="password" id="temperature"><br><br>
equatorialRadius: <input type="text" id="equatorialRadius"><br><br>

<button type="submit" onclick="searchStars()" value="Search" id="searchButton">Search</button>


<table>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Mass</th>
    <th>EvolutionaryStage</th>
    <th>Volume</th>
    <th>EscapeVelocity</th>
    <th>Age</th>
    <th>DistanceFromEarth</th>
    <th>SpectralType</th>
    <th>Temperature</th>
    <th>EquatorialRadius</th>
  </tr>

</table>

<script>
    // $("#searchButton").click(function(){
    //     $.get("http://localhost:8080/api/stars", function(data, status){
    //         alert("Status: " + status);
    //         $('#data').val(data);
    //     });
    // });


    function searchStars() {
        console.log("vliza");
        $.ajax({
            type: 'GET',
            url: '/api/stars',
            // data: {
            //     id : $("#id").value(),
            //     name : $("#name").value()
            // },
            dataType: 'json',
            success: function (data) {
                $.each(data, function (index, element) {
                    $('table').append($('<tr>'));
                    $('table').append($('<td>', {text: element.id},'</td>'));
                    $('table').append($('<td>', {text: element.name},'</td>'));
                    $('table').append($('<td>', {text: element.mass},'</td>'));
                    $('table').append($('<td>', {text: element.evolutionaryStage},'</td>'));
                    $('table').append($('<td>', {text: element.volume},'</td>'));
                    $('table').append($('<td>', {text: element.escapeVelocity},'</td>'));
                    $('table').append($('<td>', {text: element.age}),'</td>');
                    $('table').append($('<td>', {text: element.distanceFromEarth},'</td>'));
                    $('table').append($('<td>', {text: element.spectralType},'</td>'));
                    $('table').append($('<td>', {text: element.temperature},'</td>'));
                    $('table').append($('<td>', {text: element.equatorialRadius},'</td>'));
                });
            }
        })
    }


</script>>


</body>
</html>
