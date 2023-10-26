let divCarrinho = document.getElementById("carrinho");
let divInfoCliente = document.getElementById("info-cliente");
let divFormaPagamento = document.getElementById("forma-pagamento");
let divEnderecoAlternativo = document.getElementById("endereco-alternativo");

let pagamento = document.getElementById("pagamento");
let pagamentoSelecionado = 'Dinheiro';
let endereco = document.getElementById("enderecoCliente").textContent;
let enderecoNovo = document.getElementById("novoEndereco");
let valor = document.getElementById("total").textContent;

let cliente = document.getElementById("nomeCliente");
let bemVindo = document.getElementById("bem-vindo");
let logar = document.getElementById("logar");

let btnMostrarEnd = document.getElementById("botao-mostrar-end");
let enderecoCadastro = true;
let enderecoNovoValor;

function obterPagamento(){
    pagamentoSelecionado = pagamento.value;
}

function carrinhoVisivel(){
    divCarrinho.style.display = "flex";
    divInfoCliente.style.display = "none";
    divFormaPagamento.style.display = "none";
}

function infoClienteVisivel(){
    divCarrinho.style.display = "none";
    divInfoCliente.style.display = "block";
    divFormaPagamento.style.display = "none";
}

function formaPagamentoVisivel(){
    divCarrinho.style.display = "none";
    divInfoCliente.style.display = "none";
    divFormaPagamento.style.display = "flex";
}

function trocarEndereco(trocar){
    if(trocar){
        enderecoCadastro = trocar;
        divEnderecoAlternativo.style.display = "none";
        btnMostrarEnd.style.display = "inline-block";
    } else {
        enderecoCadastro = trocar;
        divEnderecoAlternativo.style.display = "block";
        btnMostrarEnd.style.display = "none";
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

function mostrarLogado(){
    carrinhoVisivel();
    divEnderecoAlternativo.style.display = "none";
    if(cliente){
        logar.style.display = "none"
    } else {
        bemVindo.style.display = "none"
        logar.style.display = "inline-block"
    }
}