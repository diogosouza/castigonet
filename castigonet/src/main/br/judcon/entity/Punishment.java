package br.judcon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import br.judcon.enums.PunishmentType;

@Entity
@Audited
@AuditTable("TB_PUN_AUD")
public class Punishment {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String punido;

	@Column
	private String comentario;

	@Column(name = "punishType")
	@Enumerated(EnumType.ORDINAL)
	private PunishmentType punishmentType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public PunishmentType getPunishmentType() {
		return punishmentType;
	}

	public void setPunishmentType(PunishmentType punishmentType) {
		this.punishmentType = punishmentType;
	}

	public String getPunido() {
		return punido;
	}

	public void setPunido(String punido) {
		this.punido = punido;
	}

}
