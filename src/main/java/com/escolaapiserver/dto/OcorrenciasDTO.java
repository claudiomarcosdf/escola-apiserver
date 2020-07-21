package com.escolaapiserver.dto;

import java.util.List;

import com.escolaapiserver.document.Aluno;
import com.escolaapiserver.document.Ocorrencia;

public class OcorrenciasDTO {
	
	private String IdAluno;
	private List<Ocorrencia> ocorrencias;
	
	public OcorrenciasDTO(Aluno aluno) {
		this.IdAluno = aluno.getId();
        this.ocorrencias = aluno.getOcorrencias();
	}

	public String getIdAluno() {
		return IdAluno;
	}

	public void setIdAluno(String idAluno) {
		IdAluno = idAluno;
	}

	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}
	

}
