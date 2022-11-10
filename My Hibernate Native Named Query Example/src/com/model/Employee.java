package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQueries({
@NamedNativeQuery(query = "insert into employee(eid,ename,address) values(?,?,?)", name = "insert", resultClass = Employee.class),
@NamedNativeQuery(name = "AllData",query = "select *  from employee",resultClass = Employee.class),
@NamedNativeQuery(name = "updateData",query = "update employee set ename=?,address=? where eid=?"),
@NamedNativeQuery(name = "AllDataDesc",query = "select * from employee order by address desc,ename desc",resultClass = Employee.class)
})
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;

	private String ename;

	private String address;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", address=" + address + "]";
	}

}
