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
@Table(name = "tbl_grupogps")
@Data
public class GrupoGps {
	
	@Id
	@Column(name = "idgrupogps")
	private UUID idGrupoGps;
	
	@Column(name = "nome", length = 50, nullable = false, unique = true)
	private String nome;
	
	@Column(name = "lideranca", length = 50, nullable = false)
	private String lideranca;
	
	//1 gps para muitos membros
	@OneToMany(mappedBy = "gps")
	private List<Membro> membros;

}
