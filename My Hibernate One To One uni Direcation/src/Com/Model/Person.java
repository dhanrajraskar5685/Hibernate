package Com.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;

	private String pname;

	private String Address;

	@OneToOne(cascade = CascadeType.ALL)
	private Aadharcard aadharcard;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Aadharcard getAadharcard() {
		return aadharcard;
	}

	public void setAadharcard(Aadharcard aadharcard) {
		this.aadharcard = aadharcard;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", Address=" + Address + ", aadharcard=" + aadharcard + "]";
	}

}
