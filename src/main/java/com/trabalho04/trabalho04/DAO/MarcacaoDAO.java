package com.trabalho04.trabalho04.DAO;

import com.trabalho04.trabalho04.model.Marcacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcacaoDAO extends JpaRepository<Marcacao, Integer> {
}
