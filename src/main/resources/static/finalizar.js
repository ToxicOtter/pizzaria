let divCarrinho = document.getElementById("carrinho");
let divInfoCliente = document.getElementById("info-cliente");
let divFormaPagamento = document.getElementById("forma-pagamento");

let pagamento = document.getElementById("pagamento").value;
let valor = document.getElementById("total").textContent;

function carrinhoVisivel(){
    divCarrinho.style.visibility = "visible";
    divInfoCliente.style.visibility = "hidden";
    divFormaPagamento.style.visibility = "hidden";
}

function infoClienteVisivel(){
    divCarrinho.style.visibility = "hidden";
    divInfoCliente.style.visibility = "visible";
    divFormaPagamento.style.visibility = "hidden";
}

function formaPagamentoVisivel(){
    divCarrinho.style.visibility = "hidden";
    divInfoCliente.style.visibility = "hidden";
    divFormaPagamento.style.visibility = "visible";
}

function deletar(){
    if(window.confirm("Realmente deseja cancelar o pedido?") == true){
        window.location.replace("/deletarPedido");
    }
}

function finalizar(){
    window.location.replace("/encerrar?pagamento="+pagamento+"&valor="+valor);
    console.log(pagamento);
    console.log(valor);
}