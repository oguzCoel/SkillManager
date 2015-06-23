package ch.business.quickline.domain;
// default package
// Generated 21.05.2015 20:36:25 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Benutzer generated by hbm2java
 */
@Entity
@Table(name = "Benutzer", catalog = "Skillmanager")
public class Benutzer implements java.io.Serializable {

	private Integer benutzerId;
	private Mitarbeiter mitarbeiter;
	private String benutzerName;
	private String benutzerPasswort;
	private String benutzerEmail;
	private Set<BenutzerRole> benutzerRoles = new HashSet<BenutzerRole>(0);

	public Benutzer() {
	}

	public Benutzer(Mitarbeiter mitarbeiter, String benutzerName,
			String benutzerPasswort, String benutzerEmail) {
		this.mitarbeiter = mitarbeiter;
		this.benutzerName = benutzerName;
		this.benutzerPasswort = benutzerPasswort;
		this.benutzerEmail = benutzerEmail;
	}

	public Benutzer(Mitarbeiter mitarbeiter, String benutzerName,
			String benutzerPasswort, String benutzerEmail,
			Set<BenutzerRole> benutzerRoles) {
		this.mitarbeiter = mitarbeiter;
		this.benutzerName = benutzerName;
		this.benutzerPasswort = benutzerPasswort;
		this.benutzerEmail = benutzerEmail;
		this.benutzerRoles = benutzerRoles;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BenutzerID", unique = true, nullable = false)
	public Integer getBenutzerId() {
		return this.benutzerId;
	}

	public void setBenutzerId(Integer benutzerId) {
		this.benutzerId = benutzerId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Mitarbeiter", nullable = false)
	public Mitarbeiter getMitarbeiter() {
		return this.mitarbeiter;
	}

	public void setMitarbeiter(Mitarbeiter mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}

	@Column(name = "BenutzerName", nullable = false, length = 30)
	public String getBenutzerName() {
		return this.benutzerName;
	}

	public void setBenutzerName(String benutzerName) {
		this.benutzerName = benutzerName;
	}

	@Column(name = "BenutzerPasswort", nullable = false, length = 30)
	public String getBenutzerPasswort() {
		return this.benutzerPasswort;
	}

	public void setBenutzerPasswort(String benutzerPasswort) {
		this.benutzerPasswort = benutzerPasswort;
	}

	@Column(name = "BenutzerEmail", nullable = false, length = 30)
	public String getBenutzerEmail() {
		return this.benutzerEmail;
	}

	public void setBenutzerEmail(String benutzerEmail) {
		this.benutzerEmail = benutzerEmail;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "benutzer")
	public Set<BenutzerRole> getBenutzerRoles() {
		return this.benutzerRoles;
	}

	public void setBenutzerRoles(Set<BenutzerRole> benutzerRoles) {
		this.benutzerRoles = benutzerRoles;
	}

}
