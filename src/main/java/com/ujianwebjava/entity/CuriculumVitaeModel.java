package com.ujianwebjava.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  
@AllArgsConstructor 
@NoArgsConstructor  


@Entity
@Table(name="curiculumvitae")
public class CuriculumVitaeModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fullname;
	private String email;
	private String favouriteplatform;
	private String curiculumvitae;
}
