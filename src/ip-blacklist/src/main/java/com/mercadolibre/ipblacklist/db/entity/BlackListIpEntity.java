package com.mercadolibre.ipblacklist.db.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "blacklist_ip")
public class BlackListIpEntity {

	@Id
	@Column(name = "ip_number", nullable = false, unique = true)
	private String ipNumber;

	@Column(name = "register_date", nullable = false)
	private Timestamp registerDate;

	public BlackListIpEntity() {
	}

	public BlackListIpEntity(String ipNumber, Timestamp registerDate) {
		super();
		this.ipNumber = ipNumber;
		this.registerDate = registerDate;
	}

	public String getIpNumber() {
		return ipNumber;
	}

	public void setIpNumber(String ipNumber) {
		this.ipNumber = ipNumber;
	}

	public Timestamp getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

}