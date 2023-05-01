package dio.desafio.service;

import dio.desafio.model.Associado;

public interface AssociadoService {
	
	Iterable<Associado> buscarTodos();
	
	Associado buscarPorId(Long id );
	
	void inserir(Associado associado);
	
	void atualizar(Long id, Associado associado);
	
	void deletar (Long id );
	
}
