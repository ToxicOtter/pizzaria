let item = document.getElementById("itemDiv");

function deletar(){
    if(item){
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
    xmlHttp.open( "GET", "/verificarLogin", false ); // false for synchronous request
    xmlHttp.send( null );
    console.log(xmlHttp.responseText);

    if(item){
        finalizar();
    } else {
        window.alert("Pedido vazio! Por favor, selecione um item para prosseguir.");
    }
}