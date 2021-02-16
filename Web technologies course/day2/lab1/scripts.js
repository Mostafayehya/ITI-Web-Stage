var userName = "mostafa yehya"
var userInput;

function sayHello() {

    prompt("This is an alert box" + "\n" + " this is a new line ")
}

function printIncreasingFont() {
    for (let index = 0; index <= 7; index++) {

        document.writeln("<font size=" + index + " > Javascript using font size " + index + "ex</font><br>");
    }
}

function displayLists() {
    var listType = prompt("select a list style " + "\n" + "1(bullet) , 2(numbered),3(lettered) ");
    switch (listType) {
        case "1":
            document.writeln("<font size= 7   > Bullit list </font><br>");
            document.writeln("<ul> <li>first Item</li> <li>second Item</li> <li>third Item</li> </ul>");

            break;
        case "2":
            document.writeln("<font size=" + 7 + " > Ordered list </font><br>");
            document.writeln("<ol> <li>first Item</li> <li>second Item</li> <li>third Item</li> </ol>");
            break;

        case "3":
            document.writeln("<font size=" + 7 + " > Ordered list (Letters) </font><br>");
            document.writeln("<ol type=a> <li>first Item</li> <li>second Item</li> <li>third Item</li> </ol>");
            break;
        default:
            confirm("Invalide input please try again");
            displayLists();

    }

    document.writeln("Reload to run the script again");

}

function minMax() {
    var firstNumber = prompt("Enter first number: ");

    var secondNumber = prompt("Enter Second number: ");

    var thirdNumber = prompt("Enter Third number:  ");

    document.writeln("first number :" + firstNumber);
    document.writeln("<br>Second Number" + secondNumber);
    document.writeln("<br>Third Number" + thirdNumber);

    var max = Math.max(firstNumber, secondNumber, thirdNumber);
    var min = Math.min(firstNumber, secondNumber, thirdNumber);

    document.writeln("<br>Max number" + max);
    document.writeln("<br>Min number" + min);

    document.writeln("<br><font size =20>Reload to run the script again</font><br>");


}

function firstTenFactorials() {

    document.writeln("<h1>Factorials of 1 to 10</h1>");

    document.writeln("<input type=button value=\"Factorial for\" onClick=findFactorial();>" );

    document.writeln( "<table border=2 width=100%>");
    for (var i = 0; i <= 10; i++){
        document.writeln("<tr><td>" + i + "!</td><td>" + factorial(i) + "</td><tr>");
    }
    document.writeln("</table>");

}

function factorial(n) {
    if (n<=1)
        return 1; 
    else 
        return n * factorial(n-1);
}

function findFactorial(){
    var number = prompt("Enter Number " , "0");
    number= parseInt(number);
    number = factorial(number); 
    alert(number);
}
