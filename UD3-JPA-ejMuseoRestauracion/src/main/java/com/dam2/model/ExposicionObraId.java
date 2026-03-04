package com.dam2.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ExposicionObraId {
	
	@Column(name = "exposicion_id")
	private Long exposicionId;
	
	@Column(name = "obra_id")
	private Long obraId;

	public ExposicionObraId() {
		super();
	}

	public ExposicionObraId(Long exposicionId, Long obraId) {
		super();
		this.exposicionId = exposicionId;
		this.obraId = obraId;
	}

	public Long getExposicionId() {
		return exposicionId;
	}

	public void setExposicionId(Long exposicionId) {
		this.exposicionId = exposicionId;
	}

	public Long getObraId() {
		return obraId;
	}

	public void setObraId(Long obraId) {
		this.obraId = obraId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(exposicionId, obraId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExposicionObraId other = (ExposicionObraId) obj;
		return Objects.equals(exposicionId, other.exposicionId) && Objects.equals(obraId, other.obraId);
	}
	
	

}
