var tipoEnderecoGlobal = "Rua";

function habilitaMenu() {
    inputStatus = document.getElementById("bt_menu");
    if (inputStatus.checked) {
        document.getElementById("Menu").style.display = "block";
    } else {
        document.getElementById("Menu").style.display = "none";
    }
    return;
}
window.addEventListener('resize', function () {
    //var altura = window.innerHeight;
    var largura = window.innerWidth;

    if (largura > 768) {
        document.getElementById("Menu").style.display = "block";
    } else {
        document.getElementById("Menu").style.display = "none";
    }
});

function choppinValidaFrm() {
    if (document.getElementById("checkResEntrega").checked) {
        atribuiResEntrega();
    }
    if (validaCPF() && validaDataNasc() 
    && validaEmail() && validaRuaRes()
    && validaBairroRes() && validaCidadeRes()) {
        document.getElementById("bt-salvar").disabled = false;
        alert("Formulário Válido !!");
        dadosJSON();
        return true;
    } else {
        alert("Formulário com Erro !!");
        return false;
    }
}

function atribuiResEntrega(){
    document.getElementById('CEPEntrega').value = document.getElementById('CEPRes').value;
    document.getElementById('ruaEntrega').value = document.getElementById('ruaRes').value;
    document.getElementById('numRuaEntrega').value = document.getElementById('numRuaRes').value;
    document.getElementById('complementoEntrega').value = document.getElementById('complementoRes').value;
    document.getElementById('bairroEntrega').value = document.getElementById('bairroRes').value;
    document.getElementById('cidadeEntrega').value = document.getElementById('cidadeRes').value;
    document.getElementById('estadoEntrega').value = document.getElementById('estadoRes').value;
    return true;
}
function validaRuaRes(){
    if (document.getElementById("ruaRes").value == ''){
        alert("Logradouro residencial é obrigatório !!");
        return false;
    } else {
        return true;
    }
}

function validaBairroRes(){
    if (document.getElementById("bairroRes").value == ''){
        alert("Bairro residencial é obrigatório !!");
        return false;
    } else {
        return true;
    }
}
function validaCidadeRes(){
    if (document.getElementById("cidadeRes").value == ''){
        alert("Cidade residencial é obrigatório !!");
        return false;
    } else {
        return true;
    }
}

function validaCPF() {
    strCPF = document.getElementById("inputCPF").value;
    var strCPF = strCPF.replace("-", "").replace(".", "").replace(".", "");
    var Soma = 0;
    var Resto;

    if ((strCPF == "00000000000") || (strCPF == "")) {
        alert("CPF inválido !!");
        return false;
    }

    for (i = 1; i <= 9; i++) Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);
    Resto = (Soma * 10) % 11;

    if ((Resto == 10) || (Resto == 11)) Resto = 0;
    if (Resto != parseInt(strCPF.substring(9, 10))) {
        alert("CPF inválido !!");
        return false;
    }

    Soma = 0;
    for (i = 1; i <= 10; i++) Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);
    Resto = (Soma * 10) % 11;

    if ((Resto == 10) || (Resto == 11)) Resto = 0;
    if (Resto != parseInt(strCPF.substring(10, 11))) {
        alert("CPF inválido !!");
        return false;
    } else {
        return true;
    }
}

function validaDataNasc() {
    var strDataNasc = document.getElementById("dataNasc").value;
    var dataNasc = new Date(strDataNasc.split('/').reverse().join('/'));
    var dataAtual = new Date();
    
    if (strDataNasc == ''){
        alert("Data de Nascimento é obrigatória");
        return false;
    } else {
        if (dataNasc > dataAtual) {
            alert("Data de Nascimento Inválida");
            return false;
        } else {
            return true;
        }
    }
}

function mensagemCadastrado(){
    alert("Cadastro realizado com sucesso !");
    return true;
}
function validaEmail() {
    // Valida E-mail através REGEX
    let emailValue = document.getElementById("inputEmail4").value;
    let emailRegex = /^[a-z0-9.]+@[a-z0-9]+\.[a-z]+(\.[a-z]+)?$/i;
    if (!emailRegex.test(emailValue)) {
        // campo inválido, retorna false para o formulário não ser submetido
        alert('Email Inválido !');
        return false;
    } else {
        return true;
    }
}

/* Pesquisa Endereço através do CEP */
function limpa_formulário_cep(tipoEndereco) {
    //Limpa valores do formulário de cep.
    if (tipoEndereco == 'Res') {
        document.getElementById('CEPRes').value = ("");
        document.getElementById('ruaRes').value = ("");
        document.getElementById('bairroRes').value = ("");
        document.getElementById('cidadeRes').value = ("");
        document.getElementById('estadoRes').value = ("SP");
    } else {
        document.getElementById('CEPEntrega').value = ("");
        document.getElementById('ruaEntrega').value = ("");
        document.getElementById('bairroEntrega').value = ("");
        document.getElementById('cidadeEntrega').value = ("");
        document.getElementById('estadoEntrega').value = ("SP");
    }
}

function meu_callback(conteudo) {
    if (!("erro" in conteudo)) {
        //Atualiza os campos com os valores.
        if (tipoEnderecoGlobal == 'Res') {
            document.getElementById('ruaRes').value = (conteudo.logradouro);
            document.getElementById('bairroRes').value = (conteudo.bairro);
            document.getElementById('cidadeRes').value = (conteudo.localidade);
            document.getElementById('estadoRes').value = (conteudo.uf);
        } else {
            document.getElementById('ruaEntrega').value = (conteudo.logradouro);
            document.getElementById('bairroEntrega').value = (conteudo.bairro);
            document.getElementById('cidadeEntrega').value = (conteudo.localidade);
            document.getElementById('estadoEntrega').value = (conteudo.uf);

        }
    } //end if.
    else {
        //CEP não Encontrado.
        limpa_formulário_cep(tipoEnderecoGlobal);
        alert("CEP não encontrado.");
    }
}

function pesquisaCEP(valor, tipoEndereco) {
    tipoEnderecoGlobal = tipoEndereco;
    //Nova variável "cep" somente com dígitos.
    var cep = valor.replace(/\D/g, '');

    //Verifica se campo cep possui valor informado.
    if (cep != "") {

        //Expressão regular para validar o CEP.
        var validacep = /^[0-9]{8}$/;

        //Valida o formato do CEP.
        if (validacep.test(cep)) {

            //Preenche os campos com "..." enquanto consulta webservice.
            if (tipoEndereco == 'Res') {
                document.getElementById('ruaRes').value = "...";
                document.getElementById('bairroRes').value = "...";
                document.getElementById('cidadeRes').value = "...";
                document.getElementById('estadoRes').value = "...";
            } else {
                document.getElementById('ruaEntrega').value = "...";
                document.getElementById('bairroEntrega').value = "...";
                document.getElementById('cidadeEntrega').value = "...";
                document.getElementById('estadoEntrega').value = "...";
            }
            //Cria um elemento javascript.
            var script = document.createElement('script');

            //Sincroniza com o callback.
            script.src = 'https://viacep.com.br/ws/' + cep + '/json/?callback=meu_callback';

            //Insere script no documento e carrega o conteúdo.
            document.body.appendChild(script);

        } //end if.
        else {
            //cep é inválido.
            limpa_formulário_cep(tipoEnderecoGlobal);
            alert("Formato de CEP inválido.");
        }
    } //end if.
    else {
        //cep sem valor, limpa formulário.
        limpa_formulário_cep(tipoEnderecoGlobal);
    }
};


function dadosJSON(){
    var jnome = document.getElementById("inputNome");
    var jdataNasc = document.getElementById("dataNasc");
    var jcpf = document.getElementById("inputCPF");
    var jrg = document.getElementById("inputRG");
    var jemail = document.getElementById("inputEmail4");
    var jsexo = "";
    var jCEPRes = document.getElementById("CEPRes");
    var jruaRes = document.getElementById("ruaRes");
    var jnumRuaRes = document.getElementById("numRuaRes");
    var jcomplementoRes = document.getElementById("complementoRes");
    var jbairroRes = document.getElementById("bairroRes");
    var jcidadeRes = document.getElementById("cidadeRes");
    var jestadoRes = document.getElementById("estadoRes");
    var jCEPEntrega = document.getElementById("CEPEntrega");
    var jruaEntrega = document.getElementById("ruaEntrega");
    var jnumRuaEntrega = document.getElementById("numRuaEntrega");
    var jcomplementoEntrega = document.getElementById("complementoEntrega");
    var jbairroEntrega = document.getElementById("bairroEntrega");
    var jcidadeEntrega = document.getElementById("cidadeEntrega");
    var jestadoEntrega = document.getElementById("estadoEntrega");

    var dataJSON = {
        jnome: jnome.value,
        jdataNasc: jdataNasc.value,
        jcpf: jcpf.value,
        jrg: jrg.value,
        jemail: jemail.value,
        jsexo: "",
        jCEPRes: jCEPRes.value,
        jruaRes: jruaRes.value,
        jnumRuaRes: jnumRuaRes.value,
        jcomplementoRes: jcomplementoRes.value,
        jbairroRes: jbairroRes.value,
        jcidadeRes: jcidadeRes.value,
        jestadoRes: jestadoRes.value,
        jCEPEntrega: jCEPEntrega.value,
        jruaEntrega: jruaEntrega.value,
        jnumRuaEntrega: jnumRuaEntrega.value,
        jcomplementoEntrega : jcomplementoEntrega.value,
        jbairroEntrega: jbairroEntrega.value,
        jcidadeEntrega: jcidadeEntrega.value,
        jestadoEntrega: jestadoEntrega.value,
    }

    let sexoML = document.getElementById("sexoMasculino").checked;
    if (sexoML){
        dataJSON.jsexo = "M";
    } else {
       dataJSON.jsexo = "F";
    }

    var strJSON = JSON.stringify(dataJSON);
    console.log(strJSON);
    document.getElementById("taStrJSON").innerHTML = strJSON;
    return
}