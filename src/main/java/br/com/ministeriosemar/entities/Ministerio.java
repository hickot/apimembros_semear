package br.com.ministeriosemar.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_ministerio")
@Data
public class Ministerio {
	
	@Id
	@Column(name = "idministerio")
	private UUID idMinisterio;
	
	@Column(name = "nome", length = 50, nullable = false, unique = true)
	private String nome;
	
	@Column(name = "lideranca", length = 50, nullable = false)
	private String lideranca;
	
	//1 ministério para muitos membros
	@OneToMany(mappedBy = "ministerio")
	private List<Membro> membros;
}
