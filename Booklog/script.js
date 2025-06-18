var popupoverlay = document.querySelector(".popup-overlay")
var popupbox = document.querySelector(".popup-box")
var addbutton = document.querySelector(".add-button")

addbutton.addEventListener("click",function(){
    popupbox.style.display = "block"
    popupoverlay.style.display = "block"

});

var deletebutton = document.querySelector("#book-delete")
deletebutton.addEventListener('click',function(event){
    popupbox.style.display = "none"
    popupoverlay.style.display = "none"

});

var container = document.querySelector(".container")
var addbook = document.getElementById("book-add")
var booktitle = document.getElementById("book-title-input")
var author = document.getElementById("book-author-input")
var description = document.getElementById("book-description-input")

addbook.addEventListener("click",function(event){
    
    event.preventDefault()
    var div = document.createElement("div")
    div.setAttribute("class", "bookcontainer")
    div.innerHTML = `<h2>${booktitle.value}</h2>
                    <h5>${author.vale}</h5>
                    <p>${description.value}</p>
                    <button onclick="deletebookcontainer(event)>Delete</button>`
    container.append(div)
    popupbox.style.display = "none"
    popupoverlay.style.display = "none"

});

function deletebookcontainer(event){
    event.target.parentElement.remove()
}