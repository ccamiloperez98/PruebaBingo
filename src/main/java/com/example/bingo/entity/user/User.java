package com.example.bingo.entity.user;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author Cristian Pérez
 * Clase entidad User
 */
@Entity
@Table(name = "bingo_users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "user_id", nullable = false)
	private Integer idUser;
	
	@Column(name = "names", nullable = false, length = 256)
	private String names;
	
	@Column(name = "last_names", nullable = false, length = 256)
	private String lastnames;
	
	@NotNull(message = "Nombre es requerido")
	@Column(name = "username", nullable = false, length = 512)
	private String username;
	
	@Column(name = "img_url", nullable = true, length = 2048)
	private String imgUrl;
	
	@NotNull(message = "Contraseña es requerida")
	@Column(name = "password", nullable = false, length = 512)
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "rol_id", foreignKey = @ForeignKey(name = "rol_id__fk"))
	private Rol rol;
	
	@Column(name = "status", nullable = false, length = 1)
	private String status;
	
	@Column(name = "expired", nullable = true)
	private boolean expired;
	
	@Column(name = "locked", nullable = true)
	private boolean locked;
	
	@Column(name = "credrencials_expired", nullable = true)
	private boolean credrencialsExpired;
	
	@Column(name = "phone", nullable = true, length = 255)
	private String phone;
	
	@Column(name = "position", nullable = true, length = 128)
	private String position;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "created_at", nullable = false)
	private LocalDate createdAt;
	
	@Column(name = "created_by", nullable = false, length = 36)
	private String createdBy;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "last_updated_at", nullable = true)
	private LocalDate lastUpdatedAt;
	
	@Column(name = "last_updated_by", nullable = true, length = 36)
	private String lastUpdatedBy;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "deleted_at", nullable = true)
	private LocalDate deletedAt;
	
	@Column(name = "deleted_by", nullable = true, length = 36)
	private String deletedBy;
	
	@Column(name = "cedula", nullable = true, length = 100)
	private String cedula;
	
	@Column(name = "customer_id", nullable = true)
	private Integer customerId;
	
	@Column(name = "preregister", nullable = true)
	private boolean preregister;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "nacimiento", nullable = true)
	private LocalDate nacimiento;
	
	@Column(name = "maxrecharge", nullable = true)
	private Integer maxrecharge;

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer id) {
		this.idUser = id;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLastnames() {
		return lastnames;
	}

	public void setLastnames(String lastnames) {
		this.lastnames = lastnames;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public boolean isCredrencialsExpired() {
		return credrencialsExpired;
	}

	public void setCredrencialsExpired(boolean credrencialsExpired) {
		this.credrencialsExpired = credrencialsExpired;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public boolean isPreregister() {
		return preregister;
	}

	public void setPreregister(boolean preregister) {
		this.preregister = preregister;
	}

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}

	public Integer getMaxrecharge() {
		return maxrecharge;
	}

	public void setMaxrecharge(Integer maxrecharge) {
		this.maxrecharge = maxrecharge;
	}
}
