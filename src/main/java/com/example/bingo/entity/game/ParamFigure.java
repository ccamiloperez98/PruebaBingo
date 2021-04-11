package com.example.bingo.entity.game;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vladmihalcea.hibernate.type.array.ListArrayType;

/**
 * 
 * @author Cristian Pérez
 * Clase Entidad ParamFigure
 */
@Entity
@Table(name = "bingo_param_figure")
@TypeDef(name = "list-array", typeClass = ListArrayType.class)
public class ParamFigure {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "figure_id", nullable = false)
	private Integer idFigure;
	
	@Column(name = "group_figure_id", nullable = false)
	private Integer groupFigureId;
	
	@Column(name = "figure_name", nullable = false, length = 100)
	private String figureName;
	
	@Type(type = "list-array")
	@Column(name = "positions_winner", columnDefinition = "boolean[]")
	private List<Boolean> positionsWinner;
	
	@Column(name = "status", nullable = false, length = 1)
	private String status;
	
	@Column(name = "created_by", nullable = false)
	private Integer createdBy;	
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Column(name = "last_updated_at", nullable = true)
	private LocalDateTime lastUpdatedAt;
	
	@Column(name = "last_updated_by", nullable = true)
	private Integer lastUpdatedBy;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Column(name = "deleted_at", nullable = true)
	private LocalDateTime deletedAt;
	
	@Column(name = "deleted_by", nullable = true)
	private Integer deletedBy;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;
	
	@Column(name = "used", nullable = false)
	private boolean used;

	public Integer getIdFigure() {
		return idFigure;
	}

	public void setIdFigure(Integer idFigure) {
		this.idFigure = idFigure;
	}

	public Integer getGroupFigureId() {
		return groupFigureId;
	}

	public void setGroupFigureId(Integer groupFigureId) {
		this.groupFigureId = groupFigureId;
	}

	public String getFigureName() {
		return figureName;
	}

	public void setFigureName(String figureName) {
		this.figureName = figureName;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public List<Boolean> getPositionsWinner() {
		return positionsWinner;
	}

	public void setPositionsWinner(List<Boolean> positionsWinner) {
		this.positionsWinner = positionsWinner;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getLastUpdatedAt() {
		return lastUpdatedAt;
	}

	public void setLastUpdatedAt(LocalDateTime lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}

	public Integer getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Integer lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}

	public Integer getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(Integer deletedBy) {
		this.deletedBy = deletedBy;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
}
