USE Skillmanager;

DELIMITER |

CREATE TRIGGER RefreshMitarbeiterBewertungDurchschnittAfterInsert BEFORE INSERT ON MitarbeiterSkill
FOR EACH ROW
BEGIN

DECLARE avg DECIMAL (10,2);
DECLARE i INT DEFAULT 1;
DECLARE j INT DEFAULT 1;

IF (NEW.MasterBewertung IS NULL) THEN
SET NEW.MasterBewertung = 0;
END IF;

IF (NEW.SelbstBewertung IS NULL) THEN
SET NEW.SelbstBewertung = 0;
END IF;





WHILE (i<=(SELECT COUNT(*)FROM Mitarbeiter)) DO

SET @avg = (SELECT AVG(MasterBewertung) from MitarbeiterSkill WHERE Mitarbeiter=i);
UPDATE Mitarbeiter SET MitarbeiterMasterBewertungDurchschnitt=@avg WHERE Mitarbeiter.MitarbeiterID=i;

SET @avg = (SELECT AVG(SelbstBewertung) from MitarbeiterSkill WHERE Mitarbeiter=i);
UPDATE Mitarbeiter SET MitarbeiterSelbstBewertungDurchschnitt=@avg WHERE Mitarbeiter.MitarbeiterID=i;

SET i=i+1;

END WHILE;


WHILE (j<=(SELECT COUNT(*)FROM Skill)) DO

SET @avg = (SELECT AVG(MasterBewertung) from MitarbeiterSkill WHERE Skill=j);
UPDATE Skill SET SkillMasterBewertungDurchschnitt=@avg WHERE Skill.SkillID=j;

SET @avg = (SELECT AVG(SelbstBewertung) from MitarbeiterSkill WHERE Skill=j);
UPDATE Skill SET SkillSelbstBewertungDurchschnitt=@avg WHERE Skill.SkillID=j;

SET j=j+1;

END WHILE;


END;

|

delimiter ;





DELIMITER |

CREATE TRIGGER RefreshMitarbeiterBewertungDurchschnittAfterUpdate BEFORE UPDATE ON MitarbeiterSkill
FOR EACH ROW
BEGIN

DECLARE avg DECIMAL (10,2);
DECLARE i INT DEFAULT 1;
DECLARE j INT DEFAULT 1;

IF (NEW.MasterBewertung IS NULL) THEN
SET NEW.MasterBewertung = 0;
END IF;

IF (NEW.SelbstBewertung IS NULL) THEN
SET NEW.SelbstBewertung = 0;
END IF;


WHILE (i<=(SELECT COUNT(*)FROM Mitarbeiter)) DO

SET @avg = (SELECT AVG(MasterBewertung) from MitarbeiterSkill WHERE Mitarbeiter=i);
UPDATE Mitarbeiter SET MitarbeiterMasterBewertungDurchschnitt=@avg WHERE Mitarbeiter.MitarbeiterID=i;

SET @avg = (SELECT AVG(SelbstBewertung) from MitarbeiterSkill WHERE Mitarbeiter=i);
UPDATE Mitarbeiter SET MitarbeiterSelbstBewertungDurchschnitt=@avg WHERE Mitarbeiter.MitarbeiterID=i;

SET i=i+1;

END WHILE;


WHILE (j<=(SELECT COUNT(*)FROM Skill)) DO

SET @avg = (SELECT AVG(MasterBewertung) from MitarbeiterSkill WHERE Skill=j);
UPDATE Skill SET SkillMasterBewertungDurchschnitt=@avg WHERE Skill.SkillID=j;

SET @avg = (SELECT AVG(SelbstBewertung) from MitarbeiterSkill WHERE Skill=j);
UPDATE Skill SET SkillSelbstBewertungDurchschnitt=@avg WHERE Skill.SkillID=j;

SET j=j+1;

END WHILE;

END;

|

delimiter ;

















