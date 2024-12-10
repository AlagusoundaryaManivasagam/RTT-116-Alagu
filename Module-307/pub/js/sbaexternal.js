$("#signup").on("click",function(event){
    event.preventDefault();
    let usn= $("#username").val();
    if(usn==""){
        $("#username").css("border-color","red");
        $("#ue").text("User name cannot be empty");
    }
    let password= $("#password").val();
    if(password == ""){
        $("#password").css("border-color", "red");
        $("#pe").text("Password cannot be empty");
    }
    let email= $("#email").val();
    if(email ==""){
        $("#email").css("border-color", "red");
        $("#ee").text("Email cannot be empty");
    }else if(!(/@/.test(email))){
        $("#email").css("border-color", "red");
        $("#ee").text("Email should contain '@'");
    }
    let cpassword = $("#cpassword").val();
    if(cpassword == ""){
        $("#cpassword").css("border-color","red");
        $("#cpe").text("This field cannot be empty");
    }else if(cpassword != password){
        $("#cpassword").css("border-color","red");
        $("#cpe").text("Entry doesn't match the entered password");
    }else if(cpassword==password){
        $("#cpe").text("Entry matches the entered password").css("color","black");
    }
    
})