package com.ba.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hospital {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="licanse_Plate")
	private Province province;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="TBL_HOSPITAL_POLICLINIC",joinColumns = @JoinColumn(name="hospital_id"),inverseJoinColumns = @JoinColumn(name="policlinic_id"))
    private Set<Policlinic> policlinics=new HashSet<>();
}
