package com.dam2.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class InvestigadorArtefactoId {

	@Column(name = "investigador_id")
	private Long investigadorId;
	
	@Column(name = "artefacto_id")
	private Long artefactoId;

	public InvestigadorArtefactoId() {
		super();
	}

	public InvestigadorArtefactoId(Long investigadorId, Long artefactoId) {
		super();
		this.investigadorId = investigadorId;
		this.artefactoId = artefactoId;
	}

	public Long getInvestigadorId() {
		return investigadorId;
	}

	public void setInvestigadorId(Long investigadorId) {
		this.investigadorId = investigadorId;
	}

	public Long getArtefactoId() {
		return artefactoId;
	}

	public void setArtefactoId(Long artefactoId) {
		this.artefactoId = artefactoId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(artefactoId, investigadorId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvestigadorArtefactoId other = (InvestigadorArtefactoId) obj;
		return Objects.equals(artefactoId, other.artefactoId) && Objects.equals(investigadorId, other.investigadorId);
	}
	
	
}
