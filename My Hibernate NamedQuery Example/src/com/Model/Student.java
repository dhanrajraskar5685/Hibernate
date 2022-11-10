package com.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(query = "from Student", name = "all"),
		@NamedQuery(query = "from Student where sid=:id1", name = "singlestudent"),
		@NamedQuery(name = "updateEmp", query = "update from Student set name=:n,address=:ad where sid=:id")

})

public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int sid;

	private String name;

	private String address;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", address=" + address + "]";
	}

}
