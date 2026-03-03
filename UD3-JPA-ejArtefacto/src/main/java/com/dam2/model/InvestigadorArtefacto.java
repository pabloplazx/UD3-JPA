package com.dam2.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "investigadorartefacto")
public class InvestigadorArtefacto{
	
	@EmbeddedId
	private InvestigadorArtefactoId investigadorArtefactoId;
	
	@ManyToOne
	@MapsId("investigadorId")
	@JoinColumn(name = "investigador_id")
	private Investigador investigador;
	
	@ManyToOne
	@MapsId("artefactoId")
	@JoinColumn(name = "artefacto_id")
	private Artefacto artefacto;
	
	// Atributos extra
	@Column(name = "fecha_asignacion")
	private LocalDate fechaAsignacion;
	private String rol;
	@Column(name = "horas_semana")
	private Integer horasSemana;
	@Column(name = "acceso_seguridad")
	private String accesoSeuridad;
	@Column(name = "informe_final")
	private String informeFinal;
	private String estado;
	public InvestigadorArtefacto() {
		super();
	}
	public InvestigadorArtefacto(InvestigadorArtefactoId investigadorArtefactoId, Investigador investigador,
			Artefacto artefacto, LocalDate fechaAsignacion, String rol, Integer horasSemana, String accesoSeuridad,
			String informeFinal, String estado) {
		super();
		this.investigadorArtefactoId = investigadorArtefactoId;
		this.investigador = investigador;
		this.artefacto = artefacto;
		this.fechaAsignacion = fechaAsignacion;
		this.rol = rol;
		this.horasSemana = horasSemana;
		this.accesoSeuridad = accesoSeuridad;
		this.informeFinal = informeFinal;
		this.estado = estado;
	}
	public InvestigadorArtefactoId getInvestigadorArtefactoId() {
		return investigadorArtefactoId;
	}
	public void setInvestigadorArtefactoId(InvestigadorArtefactoId investigadorArtefactoId) {
		this.investigadorArtefactoId = investigadorArtefactoId;
	}
	public Investigador getInvestigador() {
		return investigador;
	}
	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}
	public Artefacto getArtefacto() {
		return artefacto;
	}
	public void setArtefacto(Artefacto artefacto) {
		this.artefacto = artefacto;
	}
	public LocalDate getFechaAsignacion() {
		return fechaAsignacion;
	}
	public void setFechaAsignacion(LocalDate fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public Integer getHorasSemana() {
		return horasSemana;
	}
	public void setHorasSemana(Integer horasSemana) {
		this.horasSemana = horasSemana;
	}
	public String getAccesoSeuridad() {
		return accesoSeuridad;
	}
	public void setAccesoSeuridad(String accesoSeuridad) {
		this.accesoSeuridad = accesoSeuridad;
	}
	public String getInformeFinal() {
		return informeFinal;
	}
	public void setInformeFinal(String informeFinal) {
		this.informeFinal = informeFinal;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public int hashCode() {
		return Objects.hash(artefacto, investigador);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvestigadorArtefacto other = (InvestigadorArtefacto) obj;
		return Objects.equals(artefacto, other.artefacto) && Objects.equals(investigador, other.investigador);
	}

	
	
	

}
