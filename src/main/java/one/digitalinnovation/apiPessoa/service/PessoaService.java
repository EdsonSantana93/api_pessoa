package one.digitalinnovation.apiPessoa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.apiPessoa.dto.request.PessoaDTO;
import one.digitalinnovation.apiPessoa.entities.Pessoa;
import one.digitalinnovation.apiPessoa.exception.PessoaNotFoundException;
import one.digitalinnovation.apiPessoa.mapper.PessoaMapper;
import one.digitalinnovation.apiPessoa.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

	public Pessoa incluirPessoa(PessoaDTO pessoaDTO) {
		Pessoa pessoa = pessoaMapper.toModel(pessoaDTO);

		return repository.save(pessoa);
	}

	public List<PessoaDTO> buscarPessoas() {
		List<Pessoa> pessoas = (List<Pessoa>) repository.findAll();

		List<PessoaDTO> pessoasDTO = new ArrayList<>();

		for (Pessoa pessoa : pessoas) {
			pessoasDTO.add(pessoaMapper.toDto(pessoa));
		}
		return pessoasDTO;
	}

	public PessoaDTO buscarPorId(Long id) throws PessoaNotFoundException {
		Pessoa pessoa = repository.findById(id).orElseThrow(() -> new PessoaNotFoundException(id));

		return PessoaMapper.INSTANCE.toDto(pessoa);
	}

	public void excluirPessoa(Long id) throws PessoaNotFoundException {
		if (!repository.existsById(id))
			throw new PessoaNotFoundException(id);
			
		repository.deleteById(id);
	}

	public Pessoa AtualizarPessoa(Long id, PessoaDTO pessoaDTO) throws PessoaNotFoundException {
		if (!repository.existsById(id))
			throw new PessoaNotFoundException(id);

		Pessoa pessoa = pessoaMapper.toModel(pessoaDTO);
		return repository.save(pessoa);
	}
}
