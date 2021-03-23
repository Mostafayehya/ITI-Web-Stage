$(document).ready(function (){
    $("#sendButton").click(function(){
        var name = $("#name").val();
        var message = $("#message").val();
        var jsonData ={"name":name, "message":message};
        $.get("ChatServlet",jsonData);
    });
});

