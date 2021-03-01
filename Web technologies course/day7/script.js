function addNote(){

    var noteContent = document.getElementById("note-input").value;

    var noteColor = document.getElementById("note-color").value;

    var date = new Date();

    var noteDate = date.getTime();

    var noteId = noteDate; 

    
    var  noteDiv =createNote(noteId,noteContent,noteColor);

    var noteList = document.getElementById("notes-list");


    noteList.appendChild(noteDiv);
    


}

function createNote(id,content,color){

    var contentP = document.createElement("p");
    contentP.textContent = content; 

    var dateP = document.createElement("p");
    dateP.textContent = id;

    var deleteAnchor = document.createElement("p");
    deleteAnchor.textContent = "Delete";
    deleteAnchor.style.textDecoration="underline";
    deleteAnchor.style.color="blue"


    var note = document.createElement("div");
    note.style.backgroundColor=color;

    note.style.marginLeft="5px";
    note.style.marginRight="5px";

    note.appendChild(contentP);
    note.appendChild(dateP);
    note.appendChild(deleteAnchor);

    return note;


    
}