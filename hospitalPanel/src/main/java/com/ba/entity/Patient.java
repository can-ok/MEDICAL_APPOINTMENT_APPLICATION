package com.ba.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PATIENT_TBL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String surname;
	
	@Column(name="IDENTITYNUMBER")
	private String identityNumber;
	
    @Column(name="BIRTHDATE")
	private Date birthDate;

	private String password;
	
	private String mail;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;
}
