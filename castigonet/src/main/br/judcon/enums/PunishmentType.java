package br.judcon.enums;

public enum PunishmentType {
	NO_TV("Ficar sem TV"), CORNER("Ficar no canto da parede"), NO_ALLOWANCE("Ficar sem mesada"), Kneeling_ON_CORN(
			"Ficar ajoelhado No Milho"), CURRIES("Levar uma surra");

	private String descricao;

	private PunishmentType(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
