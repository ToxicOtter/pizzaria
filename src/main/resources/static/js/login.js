let loginDiv = document.getElementById("login");
let signupDiv = document.getElementById("signup");

function mostrarLogado(){
    signupDiv.style.display = "none";
}

function trocar(area){
    if(area == "cadastro"){
        signupDiv.style.display = "block";
        loginDiv.style.display = "none";
    } else {
        signupDiv.style.display = "none";
        loginDiv.style.display = "block";
    }
}