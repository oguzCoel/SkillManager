package ch.business.quickline.domain;


import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Qualifikation", catalog = "Skillmanager")
public class Qualifikation implements java.io.Serializable {

	private int qualifikationId;
	private String qualifikationName;
	private String qualifikationTyp;
	private String qualifikationStatus;
	private Date qualifikationBegin;
	private Date qualifikationEnde;
	private Set<Mitarbeiter> mitarbeiters = new HashSet<Mitarbeiter>(0);

	public Qualifikation() {
	}

	public Qualifikation(int qualifikationId, String qualifikationName,
			String qualifikationTyp) {
		this.qualifikationId = qualifikationId;
		this.qualifikationName = qualifikationName;
		this.qualifikationTyp = qualifikationTyp;
	}

	public Qualifikation(int qualifikationId, String qualifikationName,
			String qualifikationTyp, String qualifikationStatus,
			Date qualifikationBegin, Date qualifikationEnde,
			Set<Mitarbeiter> mitarbeiters) {
		this.qualifikationId = qualifikationId;
		this.qualifikationName = qualifikationName;
		this.qualifikationTyp = qualifikationTyp;
		this.qualifikationStatus = qualifikationStatus;
		this.qualifikationBegin = qualifikationBegin;
		this.qualifikationEnde = qualifikationEnde;
		this.mitarbeiters = mitarbeiters;
	}

	@Id
	@Column(name = "QualifikationID", unique = true, nullable = false)
	public int getQualifikationId() {
		return this.qualifikationId;
	}

	public void setQualifikationId(int qualifikationId) {
		this.qualifikationId = qualifikationId;
	}

	@Column(name = "QualifikationName", nullable = false, length = 30)
	public String getQualifikationName() {
		return this.qualifikationName;
	}

	public void setQualifikationName(String qualifikationName) {
		this.qualifikationName = qualifikationName;
	}

	@Column(name = "QualifikationTyp", nullable = false, length = 30)
	public String getQualifikationTyp() {
		return this.qualifikationTyp;
	}

	public void setQualifikationTyp(String qualifikationTyp) {
		this.qualifikationTyp = qualifikationTyp;
	}

	@Column(name = "QualifikationStatus", length = 30)
	public String getQualifikationStatus() {
		return this.qualifikationStatus;
	}

	public void setQualifikationStatus(String qualifikationStatus) {
		this.qualifikationStatus = qualifikationStatus;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "QualifikationBegin", length = 10)
	public Date getQualifikationBegin() {
		return this.qualifikationBegin;
	}

	public void setQualifikationBegin(Date qualifikationBegin) {
		this.qualifikationBegin = qualifikationBegin;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "QualifikationEnde", length = 10)
	public Date getQualifikationEnde() {
		return this.qualifikationEnde;
	}

	public void setQualifikationEnde(Date qualifikationEnde) {
		this.qualifikationEnde = qualifikationEnde;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "MitarbeiterQualifikation", catalog = "Skillmanager", joinColumns = { @JoinColumn(name = "Qualifikation", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "Mitarbeiter", nullable = false, updatable = false) })
	public Set<Mitarbeiter> getMitarbeiters() {
		return this.mitarbeiters;
	}

	public void setMitarbeiters(Set<Mitarbeiter> mitarbeiters) {
		this.mitarbeiters = mitarbeiters;
	}

}
