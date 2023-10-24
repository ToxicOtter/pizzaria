function deletar(){
    if(window.confirm("Realmente deseja cancelar o pedido?") == true){
        window.location.replace("/deletarPedido");
    }
}

function finalizar(){
    window.location.replace("/finalizar");
}