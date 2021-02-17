package one.digitalinnovation.apiPessoa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import one.digitalinnovation.apiPessoa.dto.request.PessoaDTO;
import one.digitalinnovation.apiPessoa.entities.Pessoa;

@Mapper
public interface PessoaMapper {
	PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);
	
	@Mapping(target = "dataNascimento", source = "dataNascimento", dateFormat = "dd/MM/yyyy")
	Pessoa toModel(PessoaDTO pessoaDTO);
	
	PessoaDTO toDto(Pessoa Pessoa);
}
