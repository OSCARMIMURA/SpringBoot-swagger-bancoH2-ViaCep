package dio.desafio.repository;

import org.springframework.data.repository.CrudRepository;

import dio.desafio.model.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, String> {

}
