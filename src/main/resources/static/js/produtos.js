const inputQtd = document.getElementById("qtd");
const valorUnitario = parseFloat(document.getElementById("valorUnitario").textContent);
const valorUnitarioTotalEl = document.getElementById("valorTotalUnitario");
const tipoProduto = document.getElementById("tipoProduto");
const tamanhoEl = document.getElementById("tamanho");

let cliente = document.getElementById("nomeCliente");
let bemVindo = document.getElementById("bem-vindo");
let logar = document.getElementById("logar");

let qtd = 1;
let tamanho;
let valorTotalUnitario = valorUnitario;
let incluiuOptions = false;
let tamanhoAoIniciar = false;

inputQtd.addEventListener("input", updateValueQtd);

function updateValueQtd(e) {
  qtd = parseInt(e.target.value);
  calcularValor();
}

function listQ(){
    tamanho = this.value;
    calcularValor();
}
document.getElementById("tamanho").onchange = listQ;

function calcularValor(){
    if(!tamanhoAoIniciar){
        if(tipoProduto.textContent == "Pizza"){
            tamanho = "8";
            tamanhoAoIniciar = true;
        } else {
            tamanho = "2L";
            tamanhoAoIniciar = true;
        }
    }

    if(tamanho == "8"){
        valorTotalUnitario = (valorUnitario + 10) * qtd;
        valorUnitarioTotalEl.value = valorTotalUnitario;
    } else if(tamanho == "6")  {
        valorTotalUnitario = (valorUnitario + 5) * qtd;
        valorUnitarioTotalEl.value = valorTotalUnitario;
    } else if(tamanho == "2L"){
        valorTotalUnitario = (valorUnitario + 5) * qtd;
        valorUnitarioTotalEl.value = valorTotalUnitario;
    } else {
        valorTotalUnitario = (valorUnitario + 2) * qtd;
        valorUnitarioTotalEl.value = valorTotalUnitario;
    }

    if(cliente){
        logar.style.display = "none"
    } else {
        bemVindo.style.display = "none"
        logar.style.display = "inline-block"
    }

    if(!incluiuOptions){
        if(tipoProduto.textContent == "Pizza"){
            let opt1 = document.createElement('option');
            opt1.value = "8";
            opt1.innerHTML = "8 pedaços (+10 reais)";
    
            let opt2 = document.createElement('option');
            opt2.value = "6";
            opt2.innerHTML = "6 pedaços (+5 reais)";
    
            tamanhoEl.appendChild(opt1);
            tamanhoEl.appendChild(opt2);
            incluiuOptions = true;
        } else {
            let opt1 = document.createElement('option');
            opt1.value = "2L";
            opt1.innerHTML = "2L (+5 reais)";
    
            let opt2 = document.createElement('option');
            opt2.value = "Lata";
            opt2.innerHTML = "Lata (+2 reais)";
    
    
            tamanhoEl.appendChild(opt1);
            tamanhoEl.appendChild(opt2);
            incluiuOptions = true;
        }
    }
}
