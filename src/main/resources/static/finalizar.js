let divCarrinho = document.getElementById("carrinho");
let divInfoCliente = document.getElementById("info-cliente");
let divFormaPagamento = document.getElementById("forma-pagamento");

let pagamento = document.getElementById("pagamento");
let pagamentoSelecionado = pagamento.options[pagamento.selectedIndex].text;
let endereco = document.getElementById("enderecoCliente").value;
let valor = document.getElementById("total").textContent;

function checar(){
    console.log(pagamento.options[pagamento.selectedIndex].text);
    console.log(endereco);
}

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
    window.location.replace("/encerrar?pagamento="+pagamentoSelecionado+"&valor="+valor+"&endereco="+endereco);
    console.log(pagamento);
    console.log(valor);
}

function voltarParaItens(){
    window.location.replace("/selecionarItens");
}