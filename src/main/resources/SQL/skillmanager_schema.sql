
CREATE DATABASE IF NOT EXISTS Skillmanager;

USE Skillmanager;

CREATE TABLE IF NOT EXISTS Abteilung (
AbteilungID INT NOT NULL AUTO_INCREMENT,
AbteilungName VARCHAR(30) NOT NULL,
PRIMARY KEY (AbteilungID))
ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS Mitarbeiter (
MitarbeiterID INT NOT NULL AUTO_INCREMENT,
MitarbeiterVorname VARCHAR(30) NOT NULL,
MitarbeiterNachname VARCHAR (30) NOT NULL,
MitarbeiterRolle Varchar (30) NOT NULL,
MitarbeiterAbteilung INT NOT NULL,
MitarbeiterGeburtsDatum DATE NOT NULL,
MitarbeiterAnstellungsDatum DATE NOT NULL,
MitarbeiterAdresse VARCHAR(30) NOT NULL,
MitarbeiterHausNummer INT NOT NULL,
MitarbeiterPLZ INT NOT NULL,
MitarbeiterWohnort VARCHAR(30) NOT NULL,
MitarbeiterMasterBewertungDurchschnitt DOUBLE NULL,
MitarbeiterSelbstBewertungDurchschnitt DOUBLE NULL,
PRIMARY KEY (MitarbeiterID),
Foreign KEY Fk_Abteilung (MitarbeiterAbteilung) References
Abteilung (AbteilungID) ON UPDATE CASCADE ON DELETE RESTRICT)
ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS Benutzer (
BenutzerID INT NOT NULL AUTO_INCREMENT,
Mitarbeiter INT NOT NULL,
BenutzerName VARCHAR (30) NOT NULL,
BenutzerPasswort VARCHAR (30) NOT NULL,
BenutzerEmail VARCHAR (30) NOT NULL,
PRIMARY KEY (BenutzerID),
Foreign KEY Fk_Mitarbeiter (Mitarbeiter) References
Mitarbeiter (MitarbeiterID) ON UPDATE CASCADE ON DELETE RESTRICT)
ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS Role (
RoleID INT NOT NULL AUTO_INCREMENT,
RoleName VARCHAR (30) NOT NULL,
PRIMARY KEY (RoleID))
ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS BenutzerRole (
BenutzerRoleId INT NOT NULL AUTO_INCREMENT,
Benutzer INT NOT NULL,
Role INT NOT NULL,
PRIMARY KEY (BenutzerRoleId),
UNIQUE KEY (Benutzer, Role),
Foreign KEY Fk_Benutzer (Benutzer) References
Benutzer (BenutzerID) ON UPDATE CASCADE ON DELETE RESTRICT,
Foreign KEY Fk_Role (Role) References
Role (RoleID) ON UPDATE CASCADE ON DELETE RESTRICT)
ENGINE=InnoDB;



CREATE TABLE IF NOT EXISTS Gruppe (
GruppeID INT NOT NULL AUTO_INCREMENT,
GruppeName VARCHAR(30) NOT NULL,
PRIMARY KEY (GruppeID))
ENGINE=InnoDB;



CREATE TABLE IF NOT EXISTS Skill (
SkillID INT NOT NULL AUTO_INCREMENT,
Gruppe INT NOT NULL,
SkillName VARCHAR (30) NOT NULL,
SkillBeschreibung VARCHAR (500) NULL,
SkillMasterBewertungDurchschnitt SKILL NULL,
SkillSelbstBewertungDurchschnitt SKILL NULL,
PRIMARY KEY (SkillID),
Foreign KEY Fk_SkillGruppe (Gruppe) References
Gruppe (GruppeID) ON UPDATE CASCADE ON DELETE RESTRICT)
ENGINE=InnoDB;



CREATE TABLE IF NOT EXISTS SkillMaster (
SkillMasterId INT NOT NULL AUTO_INCREMENT,
Mitarbeiter INT NOT NULL,
Skill INT NOT NULL,
PRIMARY KEY (SkillMasterID),
UNIQUE KEY (Mitarbeiter, Skill),
Foreign KEY Fk_Mitarbeiter (Mitarbeiter) References
Mitarbeiter (MitarbeiterID) ON UPDATE CASCADE ON DELETE RESTRICT,
Foreign KEY Fk_Skill (Skill) References
Skill (SkillID) ON UPDATE CASCADE ON DELETE RESTRICT)
ENGINE=InnoDB;




CREATE TABLE IF NOT EXISTS MitarbeiterSkill (
MitarbeiterSkillId INT NOT NULL AUTO_INCREMENT,
Mitarbeiter INT NOT NULL,
Skill INT NOT NULL,
MasterBewertung INT NULL,
SelbstBewertung INT NULL,
PRIMARY KEY (MitarbeiterSkillId),
UNIQUE KEY (Mitarbeiter, Skill),
Foreign KEY Fk_Mitarbeiter (Mitarbeiter) References
Mitarbeiter (MitarbeiterID) ON UPDATE CASCADE ON DELETE RESTRICT,
Foreign KEY Fk_Skill (Skill) References
Skill (SkillID) ON UPDATE CASCADE ON DELETE RESTRICT)
ENGINE=InnoDB;




CREATE TABLE IF NOT EXISTS Qualifikation (
QualifikationID INT NOT NULL AUTO_INCREMENT,
QualifikationName VARCHAR (60) NOT NULL,
QualifikationTyp VARCHAR (30) NOT NULL,
PRIMARY KEY (QualifikationID))
ENGINE=InnoDB;



CREATE TABLE IF NOT EXISTS MitarbeiterQualifikation (
MitarbeiterQualifikationId INT NOT NULL AUTO_INCREMENT,
Mitarbeiter INT NOT NULL,
Qualifikation INT NOT NULL,
PRIMARY KEY (MitarbeiterQualifikationId),
UNIQUE KEY (Mitarbeiter, Qualifikation),
Foreign KEY Fk_Mitarbeiter (Mitarbeiter) References
Mitarbeiter (MitarbeiterID) ON UPDATE CASCADE ON DELETE RESTRICT,
Foreign KEY Fk_Qualifikation (Qualifikation) References
Qualifikation (QualifikationID) ON UPDATE CASCADE ON DELETE RESTRICT)
ENGINE=InnoDB;



CREATE TABLE IF NOT EXISTS Task (
TaskID INT NOT NULL AUTO_INCREMENT,
TaskName VARCHAR (30) NOT NULL,
TaskBeschreibung VARCHAR (500) NOT NULL,
PRIMARY KEY (TaskID))
ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS Projekt (
ProjektID INT NOT NULL AUTO_INCREMENT,
ProjektName VARCHAR (30) NOT NULL,
ProjektBeschreibung VARCHAR (500) NOT NULL,
ProjektBeginn DATE,
ProjektEnde DATE,
PRIMARY KEY (ProjektID))
ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS AbteilungTask (
AbteilungTaskId INT NOT NULL AUTO_INCREMENT,
Abteilung INT NOT NULL,
Task INT NOT NULL,
PRIMARY KEY (AbteilungTaskId),
UNIQUE KEY (Abteilung, Task),
Foreign KEY Fk_Abteilung (Abteilung) References
Abteilung (AbteilungID) ON UPDATE CASCADE ON DELETE RESTRICT,
Foreign KEY Fk_Task (Task) References 
Task (TaskID) ON UPDATE CASCADE ON DELETE RESTRICT)
ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS SkillTask (
SkillTaskId INT NOT NULL AUTO_INCREMENT, 
Skill INT NOT NULL,
Task INT NOT NULL,
PRIMARY KEY (SkillTaskId),
UNIQUE KEY (Skill, Task),
Foreign KEY Fk_Skill (Skill) References
Skill (SkillID) ON UPDATE CASCADE ON DELETE RESTRICT,
Foreign KEY Fk_Task (Task) References
Task (TaskID) ON UPDATE CASCADE ON DELETE RESTRICT)
ENGINE=InnoDB;




CREATE TABLE IF NOT EXISTS MitarbeiterTask (
MitarbeiterTaskId INT NOT NULL AUTO_INCREMENT,
Mitarbeiter INT NOT NULL,
Task INT NOT NULL,
PRIMARY KEY (MitarbeiterTaskId),
UNIQUE KEY (Mitarbeiter, Task),
Foreign KEY Fk_Mitarbeiter (Mitarbeiter) References
Mitarbeiter (MitarbeiterID) ON UPDATE CASCADE ON DELETE RESTRICT,
Foreign KEY Fk_Task (Task) References
Task (TaskID) ON UPDATE CASCADE ON DELETE RESTRICT)
ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS ProjektTask (
ProjektTaskId INT NOT NULL AUTO_INCREMENT,
Projekt INT NOT NULL,
Task INT NOT NULL,
PRIMARY KEY (ProjektTaskId),
UNIQUE KEY (Projekt, Task),
Foreign KEY Fk_Projekt (Projekt) References
Projekt (ProjektID) ON UPDATE CASCADE ON DELETE RESTRICT,
Foreign KEY Fk_Task (Task) References
Task (TaskID) ON UPDATE CASCADE ON DELETE RESTRICT)
ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS AbteilungProjekt (
AbteilungProjektId INT NOT NULL AUTO_INCREMENT,
Abteilung INT NOT NULL,
Projekt INT NOT NULL,
PRIMARY KEY (AbteilungProjektId),
UNIQUE KEY (Abteilung, Projekt),
Foreign KEY Fk_Abteilung (Abteilung) References
Abteilung (AbteilungID) ON UPDATE CASCADE ON DELETE RESTRICT,
Foreign KEY Fk_Projekt (Projekt) References
Projekt (ProjektID) ON UPDATE CASCADE ON DELETE RESTRICT)
ENGINE=InnoDB;










