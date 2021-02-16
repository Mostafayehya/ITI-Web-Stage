function testTryCatch(){

    try{
        aler("HII");
    }catch(err){
            document.write("Error type " + err.name);
            document.write("<br/> Error description " + err.message);
            document.write("<br/> File Name " + err.fileName);
            document.write("<br/> Line Number " + err.lineNumber);
    }
}