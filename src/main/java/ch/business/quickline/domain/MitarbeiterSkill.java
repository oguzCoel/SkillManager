package ch.business.quickline.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "MitarbeiterSkill", catalog = "Skillmanager")
public class MitarbeiterSkill implements java.io.Serializable {

	private int mitarbeiterSkillId;
	private Mitarbeiter mitarbeiter;
	private Skill skill;
	private Integer masterBewertung;
	private Integer selbstBewertung;

	public MitarbeiterSkill() {
	}

	public MitarbeiterSkill(int mitarbeiterSkillId, Mitarbeiter mitarbeiter,
			Skill skill) {
		this.mitarbeiterSkillId = mitarbeiterSkillId;
		this.mitarbeiter = mitarbeiter;
		this.skill = skill;
	}

	public MitarbeiterSkill(int mitarbeiterSkillId, Mitarbeiter mitarbeiter,
			Skill skill, Integer masterBewertung, Integer selbstBewertung) {
		this.mitarbeiterSkillId = mitarbeiterSkillId;
		this.mitarbeiter = mitarbeiter;
		this.skill = skill;
		this.masterBewertung = masterBewertung;
		this.selbstBewertung = selbstBewertung;
	}

	@Id
	@Column(name = "MitarbeiterSkillID", unique = true, nullable = false)
	public int getMitarbeiterSkillId() {
		return this.mitarbeiterSkillId;
	}

	public void setMitarbeiterSkillId(int mitarbeiterSkillId) {
		this.mitarbeiterSkillId = mitarbeiterSkillId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Mitarbeiter", nullable = false)
	public Mitarbeiter getMitarbeiter() {
		return this.mitarbeiter;
	}

	public void setMitarbeiter(Mitarbeiter mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Skill", nullable = false)
	public Skill getSkill() {
		return this.skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	@Column(name = "MasterBewertung")
	public Integer getMasterBewertung() {
		return this.masterBewertung;
	}

	public void setMasterBewertung(Integer masterBewertung) {
		this.masterBewertung = masterBewertung;
	}

	@Column(name = "SelbstBewertung")
	public Integer getSelbstBewertung() {
		return this.selbstBewertung;
	}

	public void setSelbstBewertung(Integer selbstBewertung) {
		this.selbstBewertung = selbstBewertung;
	}

}
