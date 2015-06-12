use Skillmanager;

INSERT INTO Abteilung VALUES (NULL,'Team Engineering & Operations')
,(NULL, 'Team Projekte & Support') 
,(NULL, 'Team Marketing & Sales') 
,(NULL, 'Finance & Administration');


INSERT INTO Mitarbeiter VALUES (NULL, 'Fritz', 'Meier', 'Network Engineer', 1, '1965-12-31', '2009-06-01', 'Hauptstrasse', 9, 4147, 'Aesch', NULL, NULL)
,(NULL, 'Arquisch', 'Armon', 'Network Engineer', 1, '1959-12-12', '2001-03-01', 'Birseckstrasse', 10, 4132, 'Muttenz', NULL, NULL)
,(NULL, 'Roger', 'Bachmann', 'System Engineer', 1, '1972-01-13', '2004-03-01', 'Bottmingerstrasse', 23, 4102, 'Binningen', NULL, NULL)
,(NULL, 'Mauro', 'Cappelletti', 'Chief Technical Officer', 1, '1959-12-13', '1999-07-01', 'Hauptstrasse', 10, 4106, 'Therwil', NULL, NULL)
,(NULL, 'Patrizia', 'Corsitto', 'Junior Network Engineer', 1, '1972-01-14', '2014-07-01', 'Tramstrasse', 32, 4123, 'Allschwil', NULL, NULL)
,(NULL, 'Vanessa', 'Eigenmann', 'Projektleiterin', 1, '1972-01-15', '2014-07-01', 'Weidenstrasse', 56, 4125, 'Riehen', NULL, NULL)
,(NULL, 'Mirko', 'Milekic', 'System Engineer', 1, '1959-12-18', '2014-10-01', 'Rheinstrasse', 43, 4410, 'Liestal', NULL, NULL)
,(NULL, 'Sergio', 'Filli', 'Field Engineer', 1, '1966-01-03', '2002-10-01', 'Baslerstrasse', 20, 4310, 'Rheinfelden', NULL, NULL); 


INSERT INTO Benutzer VALUES (NULL, 1, 'fmeier', 'password', 'fmeier@qlb.ch')
,(NULL, 2, 'aarmon', 'password', 'aarmon@qlb.ch')
,(NULL, 3, 'rbachmann', 'password', 'rbachmann@qlb.ch')
,(NULL, 4, 'mcappelletti', 'password', 'mcappelletti@qlb.ch')
,(NULL, 5, 'pcorsitto', 'password', 'pcorsitto@qlb.ch')
,(NULL, 6, 'veigenmann', 'password', 'veigenmann@qlb.ch')
,(NULL, 7, 'mmilekic', 'password', 'mmilekic@qlb.ch')
,(NULL, 8, 'sfilli', 'password', 'sfilli@qlb.ch');



INSERT INTO Role VALUES (NULL, 'ROLE_ADMIN')
,(NULL, 'ROLE_USER');




INSERT INTO BenutzerRole VALUES (NULL, 1, 2)
,(NULL, 2, 2)
,(NULL, 3, 2)
,(NULL, 4, 2)
,(NULL, 5, 1)
,(NULL, 6, 2)
,(NULL, 7, 2)
,(NULL, 8, 2);



INSERT INTO Gruppe VALUES (NULL, 'Coding')
,(NULL, 'Kommunikation')
,(NULL, 'Facility')
,(NULL, 'Fieldforce')
,(NULL, 'Hardware')
,(NULL, 'HLK')
,(NULL, 'IT')
,(NULL, 'Linux')
,(NULL, 'Netzwerk')
,(NULL, 'Physik')
,(NULL, 'Scripting')
,(NULL, 'Security')
,(NULL, 'Voice')
,(NULL, 'Windows')
,(NULL, 'Storage')
,(NULL, 'VM')
,(NULL, 'Datenbank')
,(NULL, 'Fieldforce');



INSERT INTO Skill VALUES (NULL, 1, 'Perl', 'Definiert die Fähigkeit, Programme in Perl zu schreiben', NULL, NULL)
,(NULL, 1, 'PHP', 'Definiert die Fähigkeit, Programme in PHP zu schreiben', NULL, NULL)
,(NULL, 1, 'Python', 'Definiert die Fähigkeit, Programme in Python zu schreiben', NULL, NULL)
,(NULL, 1, 'Ruby', NULL, NULL, NULL)
,(NULL, 2, 'Representation', 'Definiert die Fähigkeit, sich gegenüber Kunden entsprechend zu representieren', NULL, NULL)
,(NULL, 3, 'GLS', 'Kann über das GLS monitoren und Aktionen auslösen', NULL, NULL)
,(NULL, 3, 'Gebaeudeerkentnisse', 'Definiert die Fähigkeit, der Kentnisse über die Gebäudeinfrastruktur (DC, POP)', NULL, NULL)
,(NULL, 3, 'Datacenter', 'Kennt die Verhaltensordung, Begriffe und die wichtigsten Prozesse', NULL, NULL)
,(NULL, 3, 'Energieversorgung Datacenter', 'Kennt die Stromeinführung, Verteilung, USV und NEA', NULL, NULL)
,(NULL, 3, 'Videoueberwachung', 'Kennt die Hardware, Funktionsprinzip und Grafikoberfläche des Videoüberwachungssystem', NULL, NULL)
,(NULL, 3, 'Brandmeldung und Brandloeschung', 'Kennt die Zusammenhänge der beiden Systeme und die entsprechenden Kontaktstellen', NULL, NULL)
,(NULL, 3, 'Belueftung und Befeuchtung', 'Kennt die Funktionsweise und Kontaktstellen', NULL, NULL)
,(NULL, 4, 'Cabeling', 'Kennt die Stecker, Kabeltypen und kann damit Umgehen', NULL, NULL)
,(NULL, 4, 'Rack', 'Kennt den Umgang und Montage mit Racks PDUs und Leistungsschutzschalter', NULL, NULL)
,(NULL, 5, 'Cisco Hardware', 'Kennt die Hardwarespezifikationen in Grösse, Performance, Einsatzmöglichkeiten und Problembehebung', NULL, NULL)
,(NULL, 5, 'Extreme Hardware', 'Kennt die Hardwarespezifikationen in Grösse, Performance, Einsatzmöglichkeiten und Problembehebung', NULL, NULL)
,(NULL, 5, 'Zyxel Hardware', 'Kennt die Hardwarespezifikationen in Grösse, Performance, Einsatzmöglichkeiten und Problembehebung', NULL, NULL)
,(NULL, 5, 'Moxa Hardware', 'Kennt die Hardwarespezifikationen in Grösse, Performance, Einsatzmöglichkeiten und Problembehebung', NULL, NULL)
,(NULL, 5, 'HP Hardware', 'Kennt die Hardwarespezifikationen in Grösse, Performance, Einsatzmöglichkeiten und Problembehebung', NULL, NULL)
,(NULL, 5, 'Hexatronic Hardware', 'Kennt die Hardwarespezifikationen in Grösse, Performance, Einsatzmöglichkeiten und Problembehebung', NULL, NULL)
,(NULL, 5, 'RAD Hardware', 'Kennt die Hardwarespezifikationen in Grösse, Performance, Einsatzmöglichkeiten und Problembehebung', NULL, NULL)
,(NULL, 5, 'Ciena Hardware', 'Kennt die Hardwarespezifikationen in Grösse, Performance, Einsatzmöglichkeiten und Problembehebung', NULL, NULL)
,(NULL, 5, 'Paketfront Hardware', 'Kennt die Hardwarespezifikationen in Grösse, Performance, Einsatzmöglichkeiten und Problembehebung', NULL, NULL)
,(NULL, 5, 'Optiken', 'Kennt die Hardwarespezifikationen in Grösse, Performance, Einsatzmöglichkeiten und Problembehebung', NULL, NULL)
,(NULL, 6, 'Kaelteerzeugung', 'Kennt die Hardware, Funktionsbeschrieb und kann gemäss Interventions-Handbuch enstören', NULL, NULL)
,(NULL, 6, 'Kuehlkreis', 'Kennt die Hardware, Funktionsbeschrieb und kann gemäss Interventions-Handbuch enstören', NULL, NULL)
,(NULL, 6, 'Umluftkuehler', 'Kennt die Hardware, Funktionsbeschrieb und kann gemäss Interventions-Handbuch enstören', NULL, NULL)
,(NULL, 6, 'Regel und Steuertechnik', 'Kennt die Betriebsparameter und das Prinzip des Kühlprozesses', NULL, NULL)
,(NULL, 5, 'Neitur Hardware', 'Kennt die Hardwarespezifikationen in Grösse, Performance, Einsatzmöglichkeiten und Problembehebung', NULL, NULL)
,(NULL, 5, 'Netapp Shelf', NULL, NULL, NULL)
,(NULL, 5, 'Cisco Blades', NULL, NULL, NULL)
,(NULL, 8, 'Apache', 'Definiert die Fähigkeit ein Apache zu installieren, konfigurieren, verwalten und debuggen', NULL, NULL)
,(NULL, 8, 'Bind9', 'Definiert die Fähigkeit ein Bind9 zu installieren, konfigurieren, verwalten und debuggen', NULL, NULL)
,(NULL, 8, 'Postfix', 'Definiert die Fähigkeit ein Postfix zu installieren, konfigurieren, verwalten und debuggen', NULL, NULL)
,(NULL, 8, 'Linux Know How', 'Definiert das Wissen über Linux Allgemein', NULL, NULL)
,(NULL, 17, 'MySQL', 'Definiert die Fähigkeit MySQL zu installieren, konfigurieren, verwalten und debuggen', NULL, NULL)
,(NULL, 8, 'LDAP', 'Definiert die Fähigkeit LDAP zu installieren, konfigurieren, verwalten und debuggen', NULL, NULL)
,(NULL, 8, 'PureFTPD', 'Definiert die Fähigkeit PureFTPD zu installieren, konfigurieren, verwalten und debuggen', NULL, NULL)
,(NULL, 8, 'Icinga', 'Definiert die Fähigkeit Icinga zu installieren, konfigurieren, verwalten und debuggen', NULL, NULL)
,(NULL, 8, 'PRTG', 'Definiert die Fähigkeit PRTG zu installieren, konfigurieren, verwalten und debuggen', NULL, NULL)
,(NULL, 8, 'OTRS', 'Definiert die Fähigkeit OTRS zu installieren, konfigurieren, verwalten und debuggen', NULL, NULL)
,(NULL, 8, 'PowerDNS', 'Definiert die Fähigkeit PowerDNS zu installieren, konfigurieren, verwalten und debuggen', NULL, NULL)
,(NULL, 8, 'Cacti', 'Definiert die Fähigkeit ein Cacti zu installieren, konfigurieren, verwalten und debuggen', NULL, NULL)
,(NULL, 8, 'Easy RedMine', 'Definiert die Fähigkeit Easy RedMine zu installieren, konfigurieren, verwalten und debuggen', NULL, NULL)
,(NULL, 8, 'DokuWiki', 'Definiert die Fähigkeit DokuWiki zu installieren, konfigurieren, verwalten und debuggen', NULL, NULL)
,(NULL, 8, 'Smokeping', 'Definiert die Fähigkeit Smokeping zu installieren, konfigurieren, verwalten und debuggen', NULL, NULL)
,(NULL, 8, 'Webapplikationen', 'Definiert die Fähigkeit eine Webapplikationen zu installieren, konfigurieren, verwalten und debuggen', NULL, NULL)
,(NULL, 8, 'SSL-Zertifikat', NULL, NULL, NULL)
,(NULL, 9, 'Sophos', 'Definiert die Fähigkeit Sophos zu installieren und betreiben', NULL, NULL)
,(NULL, 9, 'Layer2 Forwarding', 'Kennt Switching', NULL, NULL)
,(NULL, 9, 'OSPF', 'Definiert die Fähigkeit OSPF zu konfigurieren, Analysieren, Debuggen & Entwicklen', NULL, NULL)
,(NULL, 9, 'BGP', 'Definiert die Fähigkeit BGP konfigurieren, Analysieren, Debuggen & Entwicklen', NULL, NULL)
,(NULL, 9, 'MPLS', 'Definiert die Fähigkeit MPLS zu konfigurieren, Analysieren, Debuggen & Entwicklen', NULL, NULL)
,(NULL, 9, 'Redundanz Protokolle', 'Definiert die Fähigkeit Spanning Tree, HSRP, VRRP, EAPS zu konfigurieren, analysieren, debuggen und Entwickeln', NULL, NULL)
,(NULL, 9, 'IPv4 Adressierung', NULL, NULL, NULL)
,(NULL, 9, 'IPv6 Adressierung', NULL, NULL, NULL)
,(NULL, 9, 'Multicast', 'Definiert die Kentnisse über Multicast-Protokolle und kann analysieren und entstören', NULL, NULL)
,(NULL, 9, 'Becs', NULL, NULL, NULL)
,(NULL, 9, 'Cisco ASA', NULL, NULL, NULL)
,(NULL, 9, 'Cisco UCS', NULL, NULL, NULL)
,(NULL, 5, 'Cisco Router und Switch', NULL, NULL, NULL)
,(NULL, 9, 'VoIP', NULL, NULL, NULL)
,(NULL, 9, 'Wireless', NULL, NULL, NULL)
,(NULL, 9, 'WDM', NULL, NULL, NULL)
,(NULL, 9, 'HFC', NULL, NULL, NULL)
,(NULL, 10, 'Elektrotechnik', NULL, NULL, NULL)
,(NULL, 10, 'Hydraulik', NULL, NULL, NULL)
,(NULL, 10, 'Thermodynamik', NULL, NULL, NULL)
,(NULL, 11, 'Bash', 'Definiert die Fähigkeit Abläufe mit Bashscripts zu automatisieren', NULL, NULL)
,(NULL, 12, 'Hochspannungsanlagen', NULL, NULL, NULL)
,(NULL, 13, 'Patton', 'Definiert die Fähigkeit eine PattonBox zu installieren, konfigurieren und debuggen', NULL, NULL)
,(NULL, 13, 'vPBX', NULL, NULL, NULL)
,(NULL, 13, 'CarrierSystem', NULL, NULL, NULL)
,(NULL, 13, 'Telefonhardware', NULL, NULL, NULL)
,(NULL, 14, 'Exchange', NULL, NULL, NULL)
,(NULL, 14, 'Active Directory', NULL, NULL, NULL)
,(NULL, 14, 'Windows DNS', NULL, NULL, NULL)
,(NULL, 14, 'Windows DHCP', NULL, NULL, NULL)
,(NULL, 14, 'Group Policy', NULL, NULL, NULL)
,(NULL, 15, 'Volumes und LUNs', 'erstellen, löschen und verändern physikalische Volumes', NULL, NULL)
,(NULL, 15, 'vFilter', 'erstellen, löschen und verändern Virtuelle Volumes', NULL, NULL)
,(NULL, 15, 'Backup und Mirroring', NULL, NULL, NULL)
,(NULL, 15, 'Storage Tools', NULL, NULL, NULL)
,(NULL, 16, 'ESX', 'Installieren, konfigurieren, verwalten, upgraden und debuggen', NULL, NULL)
,(NULL, 16, 'vSphere', 'installieren, konfigurieren, verwalten, upgraden und debuggen', NULL, NULL)
,(NULL, 16, 'VM Tools', 'vSphere Client, vSphere PowerGUI', NULL, NULL)
,(NULL, 16, 'Horizon View', 'VDI, neue VMS erstellen verändern, pool konfigurieren und debuggen', NULL, NULL)
,(NULL, 17, 'SQL', 'SQL Befehle in den Engines MySQL MS SQL und Oracle', NULL, NULL)
,(NULL, 17, 'DB Admin', 'DB erstellen, Backup und Troubleshooting', NULL, NULL)
,(NULL, 17, 'ERM/UML', NULL, NULL, NULL)
,(NULL, 12, 'PKI', NULL, NULL, NULL)
,(NULL, 12, 'Intrusion Prevention', NULL, NULL, NULL)
,(NULL, 12, 'Firewall Grundbegriffe', NULL, NULL, NULL)
,(NULL, 12, 'Anti-Virus', NULL, NULL, NULL)
,(NULL, 12, 'Anti-Spam', NULL, NULL, NULL);



INSERT INTO SkillMaster VALUES (NULL, 7, 1)
,(NULL, 5, 2 )
,(NULL, 3, 3 )
,(NULL, 3, 4 )
,(NULL, 4, 5 )
,(NULL, 2, 6 )
,(NULL, 8, 7 )
,(NULL, 2, 8 )
,(NULL, 2, 9 )
,(NULL, 2, 10)
,(NULL, 2, 11)
,(NULL, 2, 12)
,(NULL, 8, 13)
,(NULL, 8, 14)
,(NULL, 2, 15)
,(NULL, 2, 16)
,(NULL, 2, 17)
,(NULL, 2, 19)
,(NULL, 8, 20)
,(NULL, 8, 21)
,(NULL, 1, 22)
,(NULL, 4, 23)
,(NULL, 2, 24)
,(NULL, 2, 25)
,(NULL, 2, 26)
,(NULL, 2, 27)
,(NULL, 2, 28)
,(NULL, 1, 29)
,(NULL, 1, 30)
,(NULL, 1, 31)
,(NULL, 3, 32)
,(NULL, 3, 33)
,(NULL, 3, 34)
,(NULL, 3, 35)
,(NULL, 3, 36)
,(NULL, 3, 37)
,(NULL, 3, 38)
,(NULL, 3, 39)
,(NULL, 3, 40)
,(NULL, 3, 41)
,(NULL, 3, 42)
,(NULL, 3, 43)
,(NULL, 3, 44)
,(NULL, 3, 45)
,(NULL, 3, 46)
,(NULL, 3, 47)
,(NULL, 3, 48)
,(NULL, 3, 49)
,(NULL, 2, 50)
,(NULL, 2, 51)
,(NULL, 2, 52)
,(NULL, 2, 53)
,(NULL, 2, 54)
,(NULL, 2, 55)
,(NULL, 2, 56)
,(NULL, 2, 57)
,(NULL, 4, 58)
,(NULL, 1, 59)
,(NULL, 1, 60)
,(NULL, 3, 61)
,(NULL, 3, 62)
,(NULL, 4, 63)
,(NULL, 2, 64)
,(NULL, 4, 65)
,(NULL, 2, 66)
,(NULL, 4, 67)
,(NULL, 4, 68)
,(NULL, 3, 69)
,(NULL, 2, 70)
,(NULL, 3, 71)
,(NULL, 3, 72)
,(NULL, 3, 73)
,(NULL, 3, 74)
,(NULL, 3, 75)
,(NULL, 1, 76)
,(NULL, 1, 77)
,(NULL, 1, 78)
,(NULL, 1, 79)
,(NULL, 1, 80)
,(NULL, 1, 81)
,(NULL, 1, 82)
,(NULL, 1, 83)
,(NULL, 1, 84)
,(NULL, 1, 85)
,(NULL, 1, 86)
,(NULL, 1, 87)
,(NULL, 1, 88)
,(NULL, 1, 89)
,(NULL, 1, 90)
,(NULL, 1, 91)
,(NULL, 1, 92)
,(NULL, 1, 93)
,(NULL, 1, 94)
,(NULL, 3, 95);



INSERT INTO MitarbeiterSkill VALUES (NULL, 1, 8, 2, 3)
,(NULL, 1, 9, 1, 3)
,(NULL, 1, 10, 4, 4)
,(NULL, 1, 11, 2, 2)
,(NULL, 1, 12, 3, 4)
,(NULL, 1, 13, 1, 3)
,(NULL, 1, 14, 5, 4)
,(NULL, 1, 7, 3, 1)
,(NULL, 5, 1, 2, 2)
,(NULL, 3, 1, 5, 2)
,(NULL, 7, 2, 1, 5)
,(NULL, 3, 2, 5, 5)
,(NULL, 7, 3, 2, 4)
,(NULL, 5, 3, 4, 3)
,(NULL, 7, 4, 1, 1)
,(NULL, 5, 4, 2, 3)
,(NULL, 6, 5, 3, 2)
,(NULL, 2, 5, 3, 5)
,(NULL, 8, 6, 4, 4)
,(NULL, 1, 6, 2, 1)
,(NULL, 8, 15, 5, 5)
,(NULL, 4, 16, 5, 5)
,(NULL, 7, 17, 3, 3)
,(NULL, 8, 19, 4, 5)
,(NULL, 2, 29, 5, 2)
,(NULL, 2, 30, 3, 1)
,(NULL, 8, 30, 4, 4)
,(NULL, 8, 31, 3, 3)
,(NULL, 2, 31, 3, 4)
,(NULL, 5, 32, 4, 4)
,(NULL, 7, 32, 3, 4)
,(NULL, 5, 33, 3, 3)
,(NULL, 7, 33, 4, 2)
,(NULL, 5, 34, 3, 3)
,(NULL, 7, 34, 2, 1)
,(NULL, 5, 35, 5, 5)
,(NULL, 7, 35, 4, 3)
,(NULL, 5, 36, 1, 1)
,(NULL, 7, 36, 2, 2)
,(NULL, 5, 37, 1, 1)
,(NULL, 7, 37, 5, 3)
,(NULL, 5, 38, 2, 2)
,(NULL, 7, 38, 1, 2)
,(NULL, 5, 39, 5, 5)
,(NULL, 7, 39, 4, 4)
,(NULL, 5, 40, 3, 3)
,(NULL, 7, 40, 4, 4)
,(NULL, 5, 41, 3, 2)
,(NULL, 7, 41, 3, 3)
,(NULL, 5, 42, 2, 2)
,(NULL, 7, 42, 5, 5)
,(NULL, 5, 43, 2, 2)
,(NULL, 7, 43, 5, 5)
,(NULL, 5, 44, 2, 1)
,(NULL, 7, 44, 3, 3)
,(NULL, 4, 50, 5, 5)
,(NULL, 8, 50, 4, 3)
,(NULL, 1, 51, 4, 4)
,(NULL, 8, 51, 3, 3)
,(NULL, 1, 52, 3, 3)
,(NULL, 4, 52, 5, 5)
,(NULL, 4, 53, 4, 2)
,(NULL, 8, 53, 3, 3)
,(NULL, 1, 54, 2, 2)
,(NULL, 8, 54, 2, 2)
,(NULL, 1, 55, 5, 5)
,(NULL, 4, 55, 4, 4)
,(NULL, 4, 56, 5, 5)
,(NULL, 1, 56, 3, 3)
,(NULL, 4, 57, 2, 2)
,(NULL, 8, 57, 3, 3)
,(NULL, 2, 61, 5, 5)
,(NULL, 4, 61, 5, 5)
,(NULL, 8, 61, 5, 5)
,(NULL, 7, 61, 1, 2)
,(NULL, 5, 61, 1, 1)
,(NULL, 3, 76, 5, 5)
,(NULL, 7, 76, 4, 4)
,(NULL, 3, 77, 5, 5)
,(NULL, 7, 77, 5, 5)
,(NULL, 3, 78, 4, 4)
,(NULL, 7, 78, 4, 4)
,(NULL, 3, 79, 4, 3)
,(NULL, 7, 79, 4, 4)
,(NULL, 3, 80, 4, 4)
,(NULL, 7, 80, 4, 3)
,(NULL, 3, 81, 3, 3)
,(NULL, 7, 81, 5, 4)
,(NULL, 3, 82, 5, 4)
,(NULL, 7, 82, 3, 3)
,(NULL, 3, 83, 4, 4)
,(NULL, 7, 83, 5, 5)
,(NULL, 5, 84, 4, 4)
,(NULL, 7, 84, 5, 5)
,(NULL, 3, 84, 5, 4)
,(NULL, 7, 85, 4, 4)
,(NULL, 3, 85, 5, 5)
,(NULL, 5, 85, 1, 1)
,(NULL, 3, 86, 5, 4)
,(NULL, 7, 86, 2, 2);



INSERT INTO Qualifikation VALUES (NULL, 'Informatiker/in EFZ', 'Ausbildung')
,(NULL, 'Elektriker/EFZ', 'Ausbildung')
,(NULL, 'Techniker/in Informatik HF', 'Ausbildung')
,(NULL, 'Informatiker/in FH', 'Ausbildung')
,(NULL, 'Proejektleiter/in (Management)', 'Ausbildung')
,(NULL, 'Microsoft Certified Application Professional', 'Weiterbildung')
,(NULL, 'Cisco Certified Network Associate Routing and Switching', 'Weiterbildung')
,(NULL, 'Junior Level Linux Professional', 'Weiterbildung')
,(NULL, 'Advanced Level Linux Professional', 'Weiterbildung')
,(NULL, 'Senior Level Linux Professional', 'Weiterbildung')
,(NULL, 'ITIL Foundation', 'Weiterbildung')
,(NULL, 'VMware Certified Professional – Cloud (VCP-Cloud)', 'Weiterbildung');



INSERT INTO MitarbeiterQualifikation VALUES (NULL, 1, 1)
,(NULL, 1, 3 )
,(NULL, 1, 6 )
,(NULL, 1, 7 )
,(NULL, 1, 12)
,(NULL, 2, 2 )
,(NULL, 2, 4 )
,(NULL, 2, 5 )
,(NULL, 3, 1 )
,(NULL, 3, 6 )
,(NULL, 3, 8 )
,(NULL, 3, 9 )
,(NULL, 3, 10)
,(NULL, 3, 11)
,(NULL, 3, 12)
,(NULL, 4, 1 )
,(NULL, 4, 2 )
,(NULL, 4, 4 )
,(NULL, 4, 5 )
,(NULL, 4, 7 )
,(NULL, 5, 1 )
,(NULL, 5, 11)
,(NULL, 6, 5 )
,(NULL, 7, 1 )
,(NULL, 7, 6 )
,(NULL, 7, 8 )
,(NULL, 7, 11)
,(NULL, 8, 2 )
,(NULL, 8, 7 );




















































































							 
							 
							 
