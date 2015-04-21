package ch.business.quickline.domain;
// default package
// Generated 15.04.2015 23:50:36 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name = "Role", catalog = "Skillmanager")
public class Role implements java.io.Serializable {

	private Integer roleId;
	private String roleName;
	private Set<Benutzer> benutzers = new HashSet<Benutzer>(0);

	public Role() {
	}

	public Role(String roleName) {
		this.roleName = roleName;
	}

	public Role(String roleName, Set<Benutzer> benutzers) {
		this.roleName = roleName;
		this.benutzers = benutzers;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "RoleID", unique = true, nullable = false)
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "RoleName", nullable = false, length = 30)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "BenutzerRole", catalog = "Skillmanager", joinColumns = { @JoinColumn(name = "Role", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "Benutzer", nullable = false, updatable = false) })
	public Set<Benutzer> getBenutzers() {
		return this.benutzers;
	}

	public void setBenutzers(Set<Benutzer> benutzers) {
		this.benutzers = benutzers;
	}

}
