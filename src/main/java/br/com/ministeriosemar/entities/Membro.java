package br.com.ministeriosemar.entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_membro")
@Data
public class Membro {
	
	@Id
	@Column(name = "idusuario")
	private UUID idUsuario;
	
	@Column(name = "nome", length = 150, nullable = false)
	private String nome;
	
	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(name = "senha", length = 40, nullable = false)
	private String senha;
	
	@Column(name = "endereco", length = 300, nullable = false)
	private String endereco;
	
	@Column(name = "datanascimento", nullable = false)
	private Date dataNascimento;
	
	@Column(name = "cargo", length = 50, nullable = true)
	private String cargo;
	
	@Column(name = "databatismo", nullable = true)
	private Date dataBatismo;

	@ManyToOne //muitos membros para 1 ministério
	@JoinColumn(name = "miniterio_id_fk", nullable = true) //alterar depois para o campo de ministérios do banco
	private Ministerio ministerio;
	
	@Column(name = "membrodesde", nullable = true)
	private Date membroDesde;
	
	@Column(name = "sexo", length = 15, nullable = false)
	private String sexo;
	
	@Column(name = "estadocivil", length = 15, nullable = false)
	private String estadoCivil;
	
	@Column(name = "datacasamento", nullable = true)
	private Date dataCasamento;
	
	@Column(name = "celular", length = 15, nullable = true)
	private String celular;
	
	@Column(name = "telefone", length = 15, nullable = true)
	private String telefone;
	
	@Column(name = "batizado", nullable = false)
	private boolean batizado;
	
	@Column(name = "naturalidade", length = 15, nullable = false)
	private String naturalidade;
	
	@Column(name = "profissao", length = 25, nullable = true)
	private String profissao;
	
	@Column(name = "escolaridade", length = 40, nullable = true)
	private String escolaridade;
	
	@Column(name = "gps", length = 50, nullable = true)
	private String gps;
}
