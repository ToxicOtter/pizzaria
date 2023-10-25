let item = document.getElementById("itemDiv");

function deletar(){
    if(window.confirm("Realmente deseja cancelar o pedido?") == true){
        window.location.replace("/deletarPedido");
    }
}

function finalizar(){
    window.location.replace("/finalizar");
}

function verificarVazio(){
    if(item){
        finalizar();
    } else {
        window.alert("Pedido vazio! Por favor, selecione um item para prosseguir ou cancele o pedido.");
    }
}