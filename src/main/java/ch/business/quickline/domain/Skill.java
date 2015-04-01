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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Skill", catalog = "Skillmanager")
public class Skill implements java.io.Serializable {

	private Integer skillId;
	private Gruppe gruppe;
	private String skillName;
	private String skillBeschreibung;
	private Set<Task> tasks = new HashSet<Task>(0);
	private Set<Mitarbeiter> mitarbeiters = new HashSet<Mitarbeiter>(0);
	private Set<MitarbeiterSkill> mitarbeiterSkills = new HashSet<MitarbeiterSkill>(
			0);

	public Skill() {
	}

	public Skill(Gruppe gruppe, String skillName, String skillBeschreibung) {
		this.gruppe = gruppe;
		this.skillName = skillName;
		this.skillBeschreibung = skillBeschreibung;
	}

	public Skill(Gruppe gruppe, String skillName, String skillBeschreibung,
			Set<Task> tasks, Set<Mitarbeiter> mitarbeiters,
			Set<MitarbeiterSkill> mitarbeiterSkills) {
		this.gruppe = gruppe;
		this.skillName = skillName;
		this.skillBeschreibung = skillBeschreibung;
		this.tasks = tasks;
		this.mitarbeiters = mitarbeiters;
		this.mitarbeiterSkills = mitarbeiterSkills;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SkillID", unique = true, nullable = false)
	public Integer getSkillId() {
		return this.skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Gruppe", nullable = false)
	public Gruppe getGruppe() {
		return this.gruppe;
	}

	public void setGruppe(Gruppe gruppe) {
		this.gruppe = gruppe;
	}

	@Column(name = "SkillName", nullable = false, length = 30)
	public String getSkillName() {
		return this.skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	@Column(name = "SkillBeschreibung", nullable = false, length = 500)
	public String getSkillBeschreibung() {
		return this.skillBeschreibung;
	}

	public void setSkillBeschreibung(String skillBeschreibung) {
		this.skillBeschreibung = skillBeschreibung;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SkillTask", catalog = "Skillmanager", joinColumns = { @JoinColumn(name = "Skill", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "Task", nullable = false, updatable = false) })
	public Set<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SkillMaster", catalog = "Skillmanager", joinColumns = { @JoinColumn(name = "Skill", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "Mitarbeiter", nullable = false, updatable = false) })
	public Set<Mitarbeiter> getMitarbeiters() {
		return this.mitarbeiters;
	}

	public void setMitarbeiters(Set<Mitarbeiter> mitarbeiters) {
		this.mitarbeiters = mitarbeiters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "skill")
	public Set<MitarbeiterSkill> getMitarbeiterSkills() {
		return this.mitarbeiterSkills;
	}

	public void setMitarbeiterSkills(Set<MitarbeiterSkill> mitarbeiterSkills) {
		this.mitarbeiterSkills = mitarbeiterSkills;
	}

}
