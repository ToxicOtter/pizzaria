let loginDiv = document.getElementById("login");
let signupDiv = document.getElementById("signup");
let formCad = document.getElementById("signupForm");
let cpf = document.getElementById("cpf");
let telefone = document.getElementById("telefone");

function mostrarLogado() {
    signupDiv.style.display = "none";
}

function trocar(area) {
    if (area == "cadastro") {
        signupDiv.style.display = "block";
        loginDiv.style.display = "none";
    } else {
        signupDiv.style.display = "none";
        loginDiv.style.display = "block";
    }
}

function mascaraCpf(i) {

    var v = i.value;

    if (isNaN(v[v.length - 1])) { // impede entrar outro caractere que não seja número
        i.value = v.substring(0, v.length - 1);
        return;
    }

    i.setAttribute("maxlength", "14");
    if (v.length == 3 || v.length == 7) i.value += ".";
    if (v.length == 11) i.value += "-";
}

const lidarTelefone = (event) => {
    let input = event.target
    input.value = mascaraTelefone(input.value)
}

const mascaraTelefone = (value) => {
    if (!value) return ""
    value = value.replace(/\D/g, '')
    value = value.replace(/(\d{2})(\d)/, "($1) $2")
    value = value.replace(/(\d)(\d{4})$/, "$1-$2")
    return value
}

function removeMascara() {
    cpf.value = cpf.value.replace(/[^a-zA-Z0-9 ]/g, '');
    telefone.value = telefone.value.replace(/[^a-zA-Z0-9 ]/g, '');
}