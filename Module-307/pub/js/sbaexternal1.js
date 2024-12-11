
window.onload= function greetUser(){
    alert("Welcome to the website!");
    const budgetcategory = ["Food", "Medical", "Housing", "Miscellaneous"]
for(const budget of budgetcategory){
    var option = $('<option>').attr('value',budget).text(budget);
    $("#dropdown").append(option);
}
}
