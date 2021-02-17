package one.digitalinnovation.apiPessoa.repository;

import org.springframework.data.repository.CrudRepository;

import one.digitalinnovation.apiPessoa.entities.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}
