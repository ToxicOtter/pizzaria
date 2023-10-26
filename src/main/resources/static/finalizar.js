let divCarrinho = document.getElementById("carrinho");
let divInfoCliente = document.getElementById("info-cliente");
let divFormaPagamento = document.getElementById("forma-pagamento");
let divEnderecoAlternativo = document.getElementById("endereco-alternativo");

let pagamento = document.getElementById("pagamento");
let pagamentoSelecionado = pagamento.options[pagamento.selectedIndex].text;
let endereco = document.getElementById("enderecoCliente").textContent;
let enderecoNovo = document.getElementById("novoEndereco");
let valor = document.getElementById("total").textContent;

let enderecoCadastro = true;
let enderecoNovoValor;

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

function trocarEndereco(trocar){
    console.log(typeof trocar);
    if(trocar){
        enderecoCadastro = trocar;
        divEnderecoAlternativo.style.visibility = "hidden";
    } else {
        enderecoCadastro = trocar;
        divEnderecoAlternativo.style.visibility = "visible";
    }
}

function deletar(){
    if(window.confirm("Realmente deseja cancelar o pedido?") == true){
        window.location.replace("/deletarPedido");
    }
}

function finalizar(){
    if(enderecoCadastro){
        window.location.replace("/encerrar?pagamento="+pagamentoSelecionado+"&valor="+valor+"&endereco="+endereco);
    } else {
        window.location.replace("/encerrar?pagamento="+pagamentoSelecionado+"&valor="+valor+"&endereco="+enderecoNovoValor);
    }
}

function voltarParaItens(){
    window.location.replace("/selecionarItens");
}

const inputHandler = function(e){
    enderecoNovoValor = e.target.value;
}

enderecoNovo.addEventListener('input', inputHandler);