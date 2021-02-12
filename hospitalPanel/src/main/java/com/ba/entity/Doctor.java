package com.ba.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="REGISTRATIONNUMBER")
	private Integer registrationNumber;
	
	@Column(name="name")
	private String name;
	
	
	@Column(name="surname")
	private String surname;

	private String password;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="POLICLINICID")
	private Policlinic policlinic;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="HOSPITALID")
	private Hospital hospital;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;
}
