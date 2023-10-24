function deletar(){
    if(window.confirm("Realmente deseja cancelar o pedido?") == true){
        window.location.replace("/deletarPedido");
    }
}