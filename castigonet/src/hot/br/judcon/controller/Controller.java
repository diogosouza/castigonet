package br.judcon.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import br.judcon.bean.PunishBean;
import br.judcon.entity.Punishment;
import br.judcon.enums.PunishmentType;

@Name("controller")
@Scope(ScopeType.CONVERSATION)
public class Controller {

	@In
	private EntityManager entityManager;
	
	private Integer rev;
	
	private List<PunishBean> list;
	
	private Punishment punishment = new Punishment();
	
	public PunishmentType[] getPunish() {
		return PunishmentType.values();
	}

	public String addPunishment() {
		Punishment punishment = entityManager.find(Punishment.class, 1);
		if (punishment == null) {
			entityManager.persist(this.punishment);
		} else {
			this.punishment.setId(1);
			this.punishment = entityManager.merge(this.punishment);
		}
		return "added";
	}
	
	public void searchPunishments() {
		AuditReader auditReader = AuditReaderFactory.get(entityManager);
		List<Number> revisions = auditReader.getRevisions(Punishment.class, 1);
		list = new ArrayList<PunishBean>();
		
		for (Number n : revisions) {
			PunishBean bean = new PunishBean();
			Punishment puni = auditReader.find(Punishment.class, 1, n);
			bean.setPunishment(puni);
			bean.setRev(n.intValue());
			list.add(bean);
		}
	}

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

	public List<PunishBean> getList() {
		return list;
	}

	public void setList(List<PunishBean> list) {
		this.list = list;
	}
	
}
