package com.example.bingo.entity.user;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Cristian Pérez
 * Clase entidad Rol
 */
@Entity
@Table(name = "bingo_rol")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "rol_id", nullable = false)
	private Integer idRol;
	
	@Column(name = "name", nullable = false, length = 256)
	private String name;
	
	@Column(name = "status", nullable = false, length = 1)
	private String status;
	
	@Column(name = "created_at", nullable = true)
	private LocalDate createdAt;
	
	@Column(name = "created_by", nullable = true, length = 36)
	private String createdBy;
	
	@Column(name = "last_updated_at", nullable = true)
	private LocalDate lastUpdatedAt;
	
	@Column(name = "last_updated_by", nullable = true, length = 36)
	private String lastUpdatedBy;
	
	@Column(name = "deleted_at", nullable = true)
	private LocalDate deletedAt;
	
	@Column(name = "deleted_by", nullable = true, length = 36)
	private String deletedBy;

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getLastUpdatedAt() {
		return lastUpdatedAt;
	}

	public void setLastUpdatedAt(LocalDate lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public LocalDate getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDate deletedAt) {
		this.deletedAt = deletedAt;
	}

	public String getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}

}
