package ch.business.quickline.domain;
// default package
// Generated 21.05.2015 20:36:25 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Mitarbeiter generated by hbm2java
 */
@Entity
@Table(name = "Mitarbeiter", catalog = "Skillmanager")
public class Mitarbeiter implements java.io.Serializable {

	private Integer mitarbeiterId;
	private Abteilung abteilung;
	private String mitarbeiterVorname;
	private String mitarbeiterNachname;
	private String mitarbeiterRolle;
	private Date mitarbeiterGeburtsDatum;
	private Date mitarbeiterAnstellungsDatum;
	private String mitarbeiterAdresse;
	private int mitarbeiterHausNummer;
	private int mitarbeiterPlz;
	private String mitarbeiterWohnort;
	private BigDecimal mitarbeiterMasterBewertungDurchschnitt;
	private BigDecimal mitarbeiterSelbstBewertungDurchschnitt;
	private Set<Benutzer> benutzers = new HashSet<Benutzer>(0);
	private Set<MitarbeiterSkill> mitarbeiterSkills = new HashSet<MitarbeiterSkill>(
			0);
	private Set<SkillMaster> skillMasters = new HashSet<SkillMaster>(0);
	private Set<MitarbeiterTask> mitarbeiterTasks = new HashSet<MitarbeiterTask>(
			0);
	private Set<MitarbeiterQualifikation> mitarbeiterQualifikations = new HashSet<MitarbeiterQualifikation>(
			0);

	public Mitarbeiter() {
	}

	public Mitarbeiter(Abteilung abteilung, String mitarbeiterVorname,
			String mitarbeiterNachname, String mitarbeiterRolle,
			Date mitarbeiterGeburtsDatum, Date mitarbeiterAnstellungsDatum,
			String mitarbeiterAdresse, int mitarbeiterHausNummer,
			int mitarbeiterPlz, String mitarbeiterWohnort) {
		this.abteilung = abteilung;
		this.mitarbeiterVorname = mitarbeiterVorname;
		this.mitarbeiterNachname = mitarbeiterNachname;
		this.mitarbeiterRolle = mitarbeiterRolle;
		this.mitarbeiterGeburtsDatum = mitarbeiterGeburtsDatum;
		this.mitarbeiterAnstellungsDatum = mitarbeiterAnstellungsDatum;
		this.mitarbeiterAdresse = mitarbeiterAdresse;
		this.mitarbeiterHausNummer = mitarbeiterHausNummer;
		this.mitarbeiterPlz = mitarbeiterPlz;
		this.mitarbeiterWohnort = mitarbeiterWohnort;
	}

	public Mitarbeiter(Abteilung abteilung, String mitarbeiterVorname,
			String mitarbeiterNachname, String mitarbeiterRolle,
			Date mitarbeiterGeburtsDatum, Date mitarbeiterAnstellungsDatum,
			String mitarbeiterAdresse, int mitarbeiterHausNummer,
			int mitarbeiterPlz, String mitarbeiterWohnort,
			BigDecimal mitarbeiterMasterBewertungDurchschnitt,
			BigDecimal mitarbeiterSelbstBewertungDurchschnitt,
			Set<Benutzer> benutzers, Set<MitarbeiterSkill> mitarbeiterSkills,
			Set<SkillMaster> skillMasters,
			Set<MitarbeiterTask> mitarbeiterTasks,
			Set<MitarbeiterQualifikation> mitarbeiterQualifikations) {
		this.abteilung = abteilung;
		this.mitarbeiterVorname = mitarbeiterVorname;
		this.mitarbeiterNachname = mitarbeiterNachname;
		this.mitarbeiterRolle = mitarbeiterRolle;
		this.mitarbeiterGeburtsDatum = mitarbeiterGeburtsDatum;
		this.mitarbeiterAnstellungsDatum = mitarbeiterAnstellungsDatum;
		this.mitarbeiterAdresse = mitarbeiterAdresse;
		this.mitarbeiterHausNummer = mitarbeiterHausNummer;
		this.mitarbeiterPlz = mitarbeiterPlz;
		this.mitarbeiterWohnort = mitarbeiterWohnort;
		this.mitarbeiterMasterBewertungDurchschnitt = mitarbeiterMasterBewertungDurchschnitt;
		this.mitarbeiterSelbstBewertungDurchschnitt = mitarbeiterSelbstBewertungDurchschnitt;
		this.benutzers = benutzers;
		this.mitarbeiterSkills = mitarbeiterSkills;
		this.skillMasters = skillMasters;
		this.mitarbeiterTasks = mitarbeiterTasks;
		this.mitarbeiterQualifikations = mitarbeiterQualifikations;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY) 
	@Column(name = "MitarbeiterID", unique = true, nullable = false)
	public Integer getMitarbeiterId() {
		return this.mitarbeiterId;
	}

	public void setMitarbeiterId(Integer mitarbeiterId) {
		this.mitarbeiterId = mitarbeiterId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MitarbeiterAbteilung", nullable = false)
	public Abteilung getAbteilung() {
		return this.abteilung;
	}

	public void setAbteilung(Abteilung abteilung) {
		this.abteilung = abteilung;
	}

	@Column(name = "MitarbeiterVorname", nullable = false, length = 30)
	public String getMitarbeiterVorname() {
		return this.mitarbeiterVorname;
	}

	public void setMitarbeiterVorname(String mitarbeiterVorname) {
		this.mitarbeiterVorname = mitarbeiterVorname;
	}

	@Column(name = "MitarbeiterNachname", nullable = false, length = 30)
	public String getMitarbeiterNachname() {
		return this.mitarbeiterNachname;
	}

	public void setMitarbeiterNachname(String mitarbeiterNachname) {
		this.mitarbeiterNachname = mitarbeiterNachname;
	}

	@Column(name = "MitarbeiterRolle", nullable = false, length = 30)
	public String getMitarbeiterRolle() {
		return this.mitarbeiterRolle;
	}

	public void setMitarbeiterRolle(String mitarbeiterRolle) {
		this.mitarbeiterRolle = mitarbeiterRolle;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MitarbeiterGeburtsDatum", nullable = false, length = 10)
	public Date getMitarbeiterGeburtsDatum() {
		return this.mitarbeiterGeburtsDatum;
	}

	public void setMitarbeiterGeburtsDatum(Date mitarbeiterGeburtsDatum) {
		this.mitarbeiterGeburtsDatum = mitarbeiterGeburtsDatum;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MitarbeiterAnstellungsDatum", nullable = false, length = 10)
	public Date getMitarbeiterAnstellungsDatum() {
		return this.mitarbeiterAnstellungsDatum;
	}

	public void setMitarbeiterAnstellungsDatum(Date mitarbeiterAnstellungsDatum) {
		this.mitarbeiterAnstellungsDatum = mitarbeiterAnstellungsDatum;
	}

	@Column(name = "MitarbeiterAdresse", nullable = false, length = 30)
	public String getMitarbeiterAdresse() {
		return this.mitarbeiterAdresse;
	}

	public void setMitarbeiterAdresse(String mitarbeiterAdresse) {
		this.mitarbeiterAdresse = mitarbeiterAdresse;
	}

	@Column(name = "MitarbeiterHausNummer", nullable = false)
	public int getMitarbeiterHausNummer() {
		return this.mitarbeiterHausNummer;
	}

	public void setMitarbeiterHausNummer(int mitarbeiterHausNummer) {
		this.mitarbeiterHausNummer = mitarbeiterHausNummer;
	}

	@Column(name = "MitarbeiterPLZ", nullable = false)
	public int getMitarbeiterPlz() {
		return this.mitarbeiterPlz;
	}

	public void setMitarbeiterPlz(int mitarbeiterPlz) {
		this.mitarbeiterPlz = mitarbeiterPlz;
	}

	@Column(name = "MitarbeiterWohnort", nullable = false, length = 30)
	public String getMitarbeiterWohnort() {
		return this.mitarbeiterWohnort;
	}

	public void setMitarbeiterWohnort(String mitarbeiterWohnort) {
		this.mitarbeiterWohnort = mitarbeiterWohnort;
	}

	@Column(name = "MitarbeiterMasterBewertungDurchschnitt", precision = 10)
	public BigDecimal getMitarbeiterMasterBewertungDurchschnitt() {
		return this.mitarbeiterMasterBewertungDurchschnitt;
	}

	public void setMitarbeiterMasterBewertungDurchschnitt(
			BigDecimal mitarbeiterMasterBewertungDurchschnitt) {
		this.mitarbeiterMasterBewertungDurchschnitt = mitarbeiterMasterBewertungDurchschnitt;
	}

	@Column(name = "MitarbeiterSelbstBewertungDurchschnitt", precision = 10)
	public BigDecimal getMitarbeiterSelbstBewertungDurchschnitt() {
		return this.mitarbeiterSelbstBewertungDurchschnitt;
	}

	public void setMitarbeiterSelbstBewertungDurchschnitt(
			BigDecimal mitarbeiterSelbstBewertungDurchschnitt) {
		this.mitarbeiterSelbstBewertungDurchschnitt = mitarbeiterSelbstBewertungDurchschnitt;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mitarbeiter")
	public Set<Benutzer> getBenutzers() {
		return this.benutzers;
	}

	public void setBenutzers(Set<Benutzer> benutzers) {
		this.benutzers = benutzers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mitarbeiter")
	public Set<MitarbeiterSkill> getMitarbeiterSkills() {
		return this.mitarbeiterSkills;
	}

	public void setMitarbeiterSkills(Set<MitarbeiterSkill> mitarbeiterSkills) {
		this.mitarbeiterSkills = mitarbeiterSkills;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mitarbeiter")
	public Set<SkillMaster> getSkillMasters() {
		return this.skillMasters;
	}

	public void setSkillMasters(Set<SkillMaster> skillMasters) {
		this.skillMasters = skillMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mitarbeiter")
	public Set<MitarbeiterTask> getMitarbeiterTasks() {
		return this.mitarbeiterTasks;
	}

	public void setMitarbeiterTasks(Set<MitarbeiterTask> mitarbeiterTasks) {
		this.mitarbeiterTasks = mitarbeiterTasks;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "mitarbeiter")
	public Set<MitarbeiterQualifikation> getMitarbeiterQualifikations() {
		return this.mitarbeiterQualifikations;
	}

	public void setMitarbeiterQualifikations(
			Set<MitarbeiterQualifikation> mitarbeiterQualifikations) {
		this.mitarbeiterQualifikations = mitarbeiterQualifikations;
	}
	
	
	
	@Override
	public String toString(){
		return String.format("%s " + "%s", getMitarbeiterVorname(), getMitarbeiterNachname() );
	}

}
