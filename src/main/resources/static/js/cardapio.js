let item = document.getElementsByClassName("linhaPedido");

let cliente = document.getElementById("nomeCliente");
let bemVindo = document.getElementById("bem-vindo");
let logar = document.getElementById("logar");

function deletar(){
    console.log(item.length == 0);
    if(item.length != 0){
        if(window.confirm("Realmente deseja cancelar o pedido?") == true){
            window.location.replace("/deletarPedido");
        }
    } else {
        window.alert("O pedido está vazio")
    }
}

function finalizar(){
    window.location.replace("/finalizar");
}

function verificarVazio(){
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "/verificarLogin", false );
    xmlHttp.send( null );
    console.log(xmlHttp.responseText);

    if(item.length != 0){
        finalizar();
    } else {
        window.alert("Pedido vazio! Por favor, selecione um item para prosseguir.");
    }
}

function mostrarLogado(){
    if(cliente){
        logar.style.display = "none"
    } else {
        bemVindo.style.display = "none"
        logar.style.display = "inline-block"
    }
}