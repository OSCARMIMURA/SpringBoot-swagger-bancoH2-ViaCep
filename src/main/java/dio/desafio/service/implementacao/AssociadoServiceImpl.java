package dio.desafio.service.implementacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dio.desafio.model.Associado;
import dio.desafio.model.Endereco;
import dio.desafio.repository.AssociadoRepository;
import dio.desafio.repository.EnderecoRepository;
import dio.desafio.service.AssociadoService;
import dio.desafio.service.ViaCepService;

@Service
public class AssociadoServiceImpl implements AssociadoService{

	@Autowired
	private AssociadoRepository associadoRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ViaCepService viaCepService;
	
	@Override
	public Iterable<Associado> buscarTodos() {
		// TODO Auto-generated method stub
		return associadoRepository.findAll();
	}

	@Override
	public Associado buscarPorId(Long id) {
		// TODO Auto-genera ted method stub
		Optional<Associado> associado = associadoRepository.findById(id);
		return associado.get();
	}

	@Override
	public void inserir(Associado associado) {
		salvarAssociadoComCep(associado);
			
	}


	@Override
	public void atualizar(Long id, Associado associado) {
		// TODO Auto-generated method stub
		
		Optional <Associado> associadoBD =associadoRepository.findById(id);
		if (associadoBD.isPresent()) {
			salvarAssociadoComCep(associado);
		}
		
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		associadoRepository.deleteById(id);
	}
	

	private void salvarAssociadoComCep(Associado associado) {
		// TODO Auto-generated method stub
	String cep = associado.getEnderecoResdencial().getCep();
	String cep2 = associado.getEnderecoComercial().getCep();
	Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> 
	{
		Endereco novoEndereco = viaCepService.consultarCep(cep);
		
		enderecoRepository.save(novoEndereco);
		return novoEndereco;
	});
	
	Endereco endereco2 = enderecoRepository.findById(cep2).orElseGet(() -> 
	{
		Endereco novoEndereco = viaCepService.consultarCep(cep2);
		
		enderecoRepository.save(novoEndereco);
		return novoEndereco;
	});
	associado.setEnderecoResdencial(endereco);
	associado.setEnderecoComercial(endereco2);
	
	associadoRepository.save(associado);
	
	}
	


}
