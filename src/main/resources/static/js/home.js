let cliente = document.getElementById("nomeCliente");
let bemVindo = document.getElementById("bem-vindo");
let logar = document.getElementById("logar");

function mostrarLogado(){
    if(cliente){
        logar.style.display = "none"
    } else {
        bemVindo.style.display = "none"
        logar.style.display = "inline-block"
    }
}