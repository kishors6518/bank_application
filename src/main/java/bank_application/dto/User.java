package bank_application.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accNo;
	private String name;
	private double balance;
	@Column(unique = true)
	private long phone;
	private String address;
	@OneToOne
	private Bank b1;
	

}
