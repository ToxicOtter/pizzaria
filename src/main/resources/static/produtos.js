const inputQtd = document.getElementById("qtd");
const valorUnitario = parseFloat(document.getElementById("valorUnitario").textContent);
const valorUnitarioTotalEl = document.getElementById("valorTotalUnitario");

let qtd = 1;
let tamanho = 8;
let valorTotalUnitario = valorUnitario;

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
    if(tamanho == "8"){
        valorTotalUnitario = (valorUnitario + 10) * qtd;
        valorUnitarioTotalEl.value = valorTotalUnitario;
    } else {
        valorTotalUnitario = (valorUnitario + 5) * qtd;
        valorUnitarioTotalEl.value = valorTotalUnitario;
    }
}
