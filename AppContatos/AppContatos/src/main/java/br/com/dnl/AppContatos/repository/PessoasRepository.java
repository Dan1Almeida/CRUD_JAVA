package br.com.dnl.AppContatos.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dnl.AppContatos.model.Pessoas;

@Repository
public interface PessoasRepository extends JpaRepository<Pessoas, Long> {
	
	
	// ----- BUSCAR EXISTÊNCIA DE CPF -----
	boolean existsByCpf(String cpf);

	
}
