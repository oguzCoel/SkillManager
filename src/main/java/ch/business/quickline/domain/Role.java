package ch.business.quickline.domain;


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


@Entity
@Table(name = "Role", catalog = "Skillmanager")
public class Role implements java.io.Serializable {

	private Integer roleId;
	private String roleName;
	private Set<Berechtigung> berechtigungs = new HashSet<Berechtigung>(0);
	private Set<Benutzer> benutzers = new HashSet<Benutzer>(0);

	public Role() {
	}

	public Role(String roleName) {
		this.roleName = roleName;
	}

	public Role(String roleName, Set<Berechtigung> berechtigungs,
			Set<Benutzer> benutzers) {
		this.roleName = roleName;
		this.berechtigungs = berechtigungs;
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
	@JoinTable(name = "RoleBerechtigung", catalog = "Skillmanager", joinColumns = { @JoinColumn(name = "Role", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "Berechtigung", nullable = false, updatable = false) })
	public Set<Berechtigung> getBerechtigungs() {
		return this.berechtigungs;
	}

	public void setBerechtigungs(Set<Berechtigung> berechtigungs) {
		this.berechtigungs = berechtigungs;
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
