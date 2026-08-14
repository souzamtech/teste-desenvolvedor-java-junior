package com.entrevista.Teste_Tecnico.Controller;


import com.entrevista.Teste_Tecnico.Model.UsuarioModel;
import com.entrevista.Teste_Tecnico.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Declara o controle da API Rest
@RequestMapping("/usuarios") //Mapeamento da API Rest- direcionamento
@CrossOrigin(origins = "*") // Permite requisições HTTP do FRONT-END

public class UsuarioController {

    @Autowired // Injecao de dependencia do repositorio para acesso ao banco
    private UsuarioRepository comandos;

    @PostMapping
    public UsuarioModel salvarUsuario(@RequestBody UsuarioModel usuario){
        return comandos.save(usuario);
    }

    @GetMapping
    public   List<UsuarioModel> listarUsuarios() {
        // Retornar todos os valores da tabela de usuarios_entity
        return comandos.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioModel BuscarUsuarios(@PathVariable Integer id) {
        return comandos.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public UsuarioModel atualizarUsuario(@PathVariable Integer id,@RequestBody UsuarioModel dadoAtualizado){

        UsuarioModel usuarioAtual = comandos.findById(id).orElseThrow();
        usuarioAtual.setNome(dadoAtualizado.getNome());
        usuarioAtual.setEmail(dadoAtualizado.getEmail());
        usuarioAtual.setPassword(dadoAtualizado.getPassword());
        usuarioAtual.setIdade(dadoAtualizado.getIdade());
        usuarioAtual.setEndereco(dadoAtualizado.getEndereco());
        return comandos.save(usuarioAtual);
    }

    @DeleteMapping("/{id}")
    public  String deletarUsuario(@PathVariable Integer id){

        // Pesquisa usuario na tabela (Banco de dados)
        UsuarioModel pessoa = comandos.findById(id).orElseThrow();
        String nome = pessoa.getNome();

        comandos.deleteById(id);
        return "Usuário " +nome+ " Foi deletado com sucesso";
    }
}
