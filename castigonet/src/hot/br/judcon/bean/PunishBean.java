package br.judcon.bean;
import br.judcon.entity.Punishment;

public class PunishBean {

	private Punishment punishment;

	private Integer rev;

	public Punishment getPunishment() {
		return punishment;
	}

	public void setPunishment(Punishment punishment) {
		this.punishment = punishment;
	}

	public Integer getRev() {
		return rev;
	}

	public void setRev(Integer rev) {
		this.rev = rev;
	}

}
