package ch.business.quickline.domain;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Berechtigung", catalog = "Skillmanager")
public class Berechtigung implements java.io.Serializable {

	private int berechtigungId;
	private String berechtigungName;
	private Set<Role> roles = new HashSet<Role>(0);

	public Berechtigung() {
	}

	public Berechtigung(int berechtigungId, String berechtigungName) {
		this.berechtigungId = berechtigungId;
		this.berechtigungName = berechtigungName;
	}

	public Berechtigung(int berechtigungId, String berechtigungName,
			Set<Role> roles) {
		this.berechtigungId = berechtigungId;
		this.berechtigungName = berechtigungName;
		this.roles = roles;
	}

	@Id
	@Column(name = "BerechtigungID", unique = true, nullable = false)
	public int getBerechtigungId() {
		return this.berechtigungId;
	}

	public void setBerechtigungId(int berechtigungId) {
		this.berechtigungId = berechtigungId;
	}

	@Column(name = "BerechtigungName", nullable = false, length = 30)
	public String getBerechtigungName() {
		return this.berechtigungName;
	}

	public void setBerechtigungName(String berechtigungName) {
		this.berechtigungName = berechtigungName;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "RoleBerechtigung", catalog = "Skillmanager", joinColumns = { @JoinColumn(name = "Berechtigung", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "Role", nullable = false, updatable = false) })
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
