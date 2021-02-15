function calcString(){

    var inputString = document.getElementById("textArea").value;
    var reqIndex =  document.getElementById("reqIndex").value;
    var subString =  document.getElementById("subString").value;

    document.getElementById("firstOccurence1").value= inputString.indexOf(subString);
    document.getElementById("lastOccurence1").value = inputString.lastIndexOf(subString);

    document.getElementById("firstOccurence2").value= inputString.indexOf(subString,reqIndex);

    document.getElementById("lastOccurence2").value= inputString.lastIndexOf(subString,reqIndex);

    // document.writeln("<p>" + subString + "</p>");
}