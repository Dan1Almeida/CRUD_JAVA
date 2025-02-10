package br.com.dnl.AppContatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dnl.AppContatos.model.Contatos;

@Repository
public interface ContatosRepository extends JpaRepository<Contatos, Long> {

}
