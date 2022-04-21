function getTemperatures(){

    table = document.getElementById("myTable")
    request = getTemps();
    for(var i=0; i<request.length;i++){
        addRow(request[i].temperatureSensorId,request[i].temperature)
    }

}

function getTemps(){
    return sendRequest("getTemperature");
}

function addRow(sensorId, temperature){
// Find a <table> element with id="myTable":
    var table = document.getElementById("myTable");

// Create an empty <tr> element and add it to the 1st position of the table:
    var row = table.insertRow(-1);

// Insert new cells (<td> elements) at the 1st and 2nd position of the "new" <tr> element:
    var cell1 = row.insertCell(-1);
    var cell2 = row.insertCell(-1);

// Add some text to the new cells:
    cell1.innerHTML = sensorId;
    cell2.innerHTML = temperature;
}



function staticsSide(){
    document.getElementById("average").innerHTML= sendRequest("averageTemp");
    document.getElementById("distance").innerHTML= sendRequest("tempDistance");
    document.getElementById("lowest").innerHTML = sendRequest("lowestTemp");
    document.getElementById("highest").innerHTML = sendRequest("highestTemp");

}



function sendRequest(endpoint){
    var responseText;
    var xhr = new XMLHttpRequest();
    var url = "http://localhost:8080/"+endpoint;
    xhr.open("GET",url,false);
    xhr.setRequestHeader("Content-Type","application/json");
    xhr.onreadystatechange = function () {
        if(xhr.readyState===4){
            if(xhr.status===200){
                var json = JSON.parse(xhr.responseText);
                responseText=json;
            }else{
                console.log("ErrorMessage:"+JSON.parse(xhr.response).message);
            }
        }
    };
    xhr.send();
    return responseText;

}