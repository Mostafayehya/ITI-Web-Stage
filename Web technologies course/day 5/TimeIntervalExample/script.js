var c = 0;
var t;

function timedCount() {

    document.getElementById("text").value = c;
    c = c + 1;
}

function startInt() {
    t = setInterval("timedCount()",1000);
}

function stopCount() {
    clearInterval(t);
}