package com.dam2.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DirectorPeliculaID {
	
	@Column(name = "director_id")
	private Long directorId;
	
	@Column(name = "pelicula_id")
	private Long peliculaId;

	public DirectorPeliculaID() {
		super();
	}

	public DirectorPeliculaID(Long directorId, Long peliculaId) {
		super();
		this.directorId = directorId;
		this.peliculaId = peliculaId;
	}

	public Long getDirectorId() {
		return directorId;
	}

	public void setDirectorId(Long directorId) {
		this.directorId = directorId;
	}

	public Long getPeliculaId() {
		return peliculaId;
	}

	public void setPeliculaId(Long peliculaId) {
		this.peliculaId = peliculaId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(directorId, peliculaId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DirectorPeliculaID other = (DirectorPeliculaID) obj;
		return Objects.equals(directorId, other.directorId) && Objects.equals(peliculaId, other.peliculaId);
	}

	
}
