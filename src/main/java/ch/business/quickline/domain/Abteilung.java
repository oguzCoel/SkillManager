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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Abteilung", catalog = "Skillmanager")
public class Abteilung implements java.io.Serializable {

	private Integer abteilungId;
	private String abteilungName;
	private Set<Projekt> projekts = new HashSet<Projekt>(0);
	private Set<Task> tasks = new HashSet<Task>(0);
	private Set<Mitarbeiter> mitarbeiters = new HashSet<Mitarbeiter>(0);

	public Abteilung() {
	}

	public Abteilung(String abteilungName) {
		this.abteilungName = abteilungName;
	}

	public Abteilung(String abteilungName, Set<Projekt> projekts,
			Set<Task> tasks, Set<Mitarbeiter> mitarbeiters) {
		this.abteilungName = abteilungName;
		this.projekts = projekts;
		this.tasks = tasks;
		this.mitarbeiters = mitarbeiters;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "AbteilungID", unique = true, nullable = false)
	public Integer getAbteilungId() {
		return this.abteilungId;
	}

	public void setAbteilungId(Integer abteilungId) {
		this.abteilungId = abteilungId;
	}

	@Column(name = "AbteilungName", nullable = false, length = 30)
	public String getAbteilungName() {
		return this.abteilungName;
	}

	public void setAbteilungName(String abteilungName) {
		this.abteilungName = abteilungName;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "AbteilungProjekt", catalog = "Skillmanager", joinColumns = { @JoinColumn(name = "Abteilung", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "Projekt", nullable = false, updatable = false) })
	public Set<Projekt> getProjekts() {
		return this.projekts;
	}

	public void setProjekts(Set<Projekt> projekts) {
		this.projekts = projekts;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "AbteilungTask", catalog = "Skillmanager", joinColumns = { @JoinColumn(name = "Abteilung", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "Task", nullable = false, updatable = false) })
	public Set<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "abteilung")
	public Set<Mitarbeiter> getMitarbeiters() {
		return this.mitarbeiters;
	}

	public void setMitarbeiters(Set<Mitarbeiter> mitarbeiters) {
		this.mitarbeiters = mitarbeiters;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((abteilungId == null) ? 0 : abteilungId.hashCode());
		result = prime * result
				+ ((abteilungName == null) ? 0 : abteilungName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Abteilung other = (Abteilung) obj;
		if (abteilungId == null) {
			if (other.abteilungId != null)
				return false;
		} else if (!abteilungId.equals(other.abteilungId))
			return false;
		if (abteilungName == null) {
			if (other.abteilungName != null)
				return false;
		} else if (!abteilungName.equals(other.abteilungName))
			return false;
		return true;
	}
	
	public String toString(){
		return String.format("%s", getAbteilungName());
	}
	
	

}
