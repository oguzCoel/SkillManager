package ch.business.quickline.domain;
// default package
// Generated 21.05.2015 20:36:25 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * BenutzerRole generated by hbm2java
 */
@Entity
@Table(name = "BenutzerRole", catalog = "Skillmanager", uniqueConstraints = @UniqueConstraint(columnNames = {
		"Benutzer", "Role" }))
public class BenutzerRole implements java.io.Serializable {

	private Integer benutzerRoleId;
	private Benutzer benutzer;
	private Role role;

	public BenutzerRole() {
	}

	public BenutzerRole(Benutzer benutzer, Role role) {
		this.benutzer = benutzer;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BenutzerRoleId", unique = true, nullable = false)
	public Integer getBenutzerRoleId() {
		return this.benutzerRoleId;
	}

	public void setBenutzerRoleId(Integer benutzerRoleId) {
		this.benutzerRoleId = benutzerRoleId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Benutzer", nullable = false)
	public Benutzer getBenutzer() {
		return this.benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Role", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
