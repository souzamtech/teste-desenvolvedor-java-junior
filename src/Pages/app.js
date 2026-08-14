const URL_API = "http://localhost:8080/usuarios";

// Função de apoio para imprimir o resultado na tela
function mostrarNaTela(dados) {
    const tela = document.getElementById("telaResposta");
    // Transforma o objeto JavaScript em texto formatado para exibir na tela
    tela.innerText = typeof dados === "object" ? JSON.stringify(dados, null, 4) : dados;
}


// ==========================================
// 1. GET - BUSCAR TODOS
// ==========================================
async function fazerGET() {
    const resposta = await fetch(URL_API);
    const dados = await resposta.json();
    
    mostrarNaTela(dados);
}


// ==========================================
// 2. GET POR ID - BUSCAR UM ÚNICO USUÁRIO
// ==========================================
async function fazerGETPorId() {
    const id = document.getElementById("inputId").value;

    const resposta = await fetch(URL_API + "/" + id);
    
    if (resposta.ok) {
        const dados = await resposta.json();
        mostrarNaTela(dados);
    } else {
        mostrarNaTela({ erro: "Usuário não encontrado para o ID: " + id });
    }
}


// ==========================================
// 3. POST - INSERIR
// ==========================================
async function fazerPOST() {
    // Monta o objeto com TODOS os campos mapeados na Model
    const usuarioNovo = {
        nome: document.getElementById("inputNome").value,
        email: document.getElementById("inputEmail").value,
        password: document.getElementById("inputPassword").value,
        idade: document.getElementById("inputIdade").value ? parseInt(document.getElementById("inputIdade").value) : null,
        endereco: document.getElementById("inputEndereco").value || null
    };

    const resposta = await fetch(URL_API, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(usuarioNovo)
    });

    const dados = await resposta.json();
    mostrarNaTela(dados);
}


// ==========================================
// 4. PUT - ATUALIZAR (Precisa do ID)
// ==========================================
async function fazerPUT() {
    const id = document.getElementById("inputId").value;
    
    const usuarioAtualizado = {
        nome: document.getElementById("inputNome").value,
        email: document.getElementById("inputEmail").value,
        password: document.getElementById("inputPassword").value,
        idade: document.getElementById("inputIdade").value ? parseInt(document.getElementById("inputIdade").value) : null,
        endereco: document.getElementById("inputEndereco").value || null
    };

    const resposta = await fetch(URL_API + "/" + id, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(usuarioAtualizado)
    });

    const dados = await resposta.json();
    mostrarNaTela(dados);
}


// ==========================================
// 5. DELETE - APAGAR (Precisa do ID)
// ==========================================
async function fazerDELETE() {
    const id = document.getElementById("inputId").value;

    const resposta = await fetch(URL_API + "/" + id, {
        method: "DELETE"
    });

    // Pega a mensagem de texto de retorno ("Usuário deletado com sucesso!")
    const textoMensagem = await resposta.text();
    
    mostrarNaTela(textoMensagem); 
}