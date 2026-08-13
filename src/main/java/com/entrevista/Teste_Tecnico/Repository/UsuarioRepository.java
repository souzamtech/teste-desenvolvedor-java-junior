package com.entrevista.Teste_Tecnico.Repository;

import com.entrevista.Teste_Tecnico.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
}