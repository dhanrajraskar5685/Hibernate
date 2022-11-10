package Com.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String sname;

	private String saddress;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	
	private List<subject> slist = new ArrayList<subject>();

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public List<subject> getSlist() {
		return slist;
	}

	public void setSlist(List<subject> slist) {
		this.slist = slist;
	}

	@Override
	public String toString() {
		return "Student [pid=" + pid + ", sname=" + sname + ", saddress=" + saddress + ", slist=" + slist + "]";
	}

}
