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

import com.vladmihalcea.hibernate.type.array.ListArrayType;

/**
 * @author Cristian Pérez
 * Clase Entidad ParamBoard
 */
@Entity
@Table(name = "bingo_param_board")
@TypeDef(name = "list-array", typeClass = ListArrayType.class)
public class ParamBoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "board_id", nullable = false)
	private Integer idBoard;
	
	@Type(type = "list-array")
	@Column(name = "board_numbers", nullable = false, columnDefinition = "integer[]")
	private List<Integer> boardNumbers;
	
	@Column(name = "status", nullable = false, columnDefinition = "character varying default 'A' ")
	private char status;
	
	@Column(name = "created_by", nullable = true)
	private Integer createdBy;	
	
	@Column(name = "last_updated_at", nullable = true)
	private LocalDateTime lastUpdatedAt;
	
	@Column(name = "last_updated_by", nullable = true)
	private Integer lastUpdatedBy;
	
	@Column(name = "deleted_at", nullable = true)
	private LocalDateTime deletedAt;
	
	@Column(name = "deleted_by", nullable = true)
	private Integer deletedBy;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "created_at", nullable = true)
	private LocalDateTime createdAt;
	
	@Type(type = "list-array")
	@Column(name = "sensor_values", nullable = true, columnDefinition = "integer[]")
	private List<Integer>  sensorValues;

	public Integer getIdBoard() {
		return idBoard;
	}

	public void setIdBoard(Integer idBoard) {
		this.idBoard = idBoard;
	}

	public List<Integer> getBoardNumbers() {
		return boardNumbers;
	}

	public void setBoardNumbers(List<Integer> boardNumbers) {
		this.boardNumbers = boardNumbers;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Integer getCreatedBy() {
		return createdBy;
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

	public List<Integer> getSensorValues() {
		return sensorValues;
	}

	public void setSensorValues(List<Integer> sensorValues) {
		this.sensorValues = sensorValues;
	}

}
