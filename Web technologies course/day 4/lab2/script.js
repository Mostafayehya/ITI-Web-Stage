function splitString() {

    document.getElementById("resultText").value="";
    var sentence = document.getElementById("sentence").value;

    var delimiter = document.getElementById("delimiter").value;

    var stringAsArr =
        sentence.split(delimiter);

    for (var i = 0; i < stringAsArr.length; i++) {
        document.getElementById("resultText").value += stringAsArr[i] + "\n";
    }

    document.getElementById("firstTen").value = 
    sentence.substring(0,10);




}