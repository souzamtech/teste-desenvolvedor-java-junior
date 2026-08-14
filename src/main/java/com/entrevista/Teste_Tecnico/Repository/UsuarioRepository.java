package com.entrevista.Teste_Tecnico.Repository;

import com.entrevista.Teste_Tecnico.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
}

// Diferença de uma Classe Abstrata para uma Interface

// 1ª- Apenas posso herdar uma classe, porém, posso implementar várias interfaces

//2ª - Numa classe abstrata,podemos ter métodos concretos e abstratos, e na interface todos os métodos são abstratos

//3ª - Utilizamos classes para definir (Usuários, pessoa, objetos em geral). Na interface, definimos o Objeto irá realizar

