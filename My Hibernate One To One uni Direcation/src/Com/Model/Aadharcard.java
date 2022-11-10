package Com.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aadharcard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;

	private long ano;

	private String nameofOfficer;

	public String getNameofOfficer() {
		return nameofOfficer;
	}

	public void setNameofOfficer(String nameofOfficer) {
		this.nameofOfficer = nameofOfficer;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public long getAno() {
		return ano;
	}

	public void setAno(long ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "Aadharcard [aid=" + aid + ", ano=" + ano + ", nameofOfficer=" + nameofOfficer + "]";
	}

}
