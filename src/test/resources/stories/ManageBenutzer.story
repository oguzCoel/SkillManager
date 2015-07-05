ManageBenutzer

Scenario: Der Admin sollte einen neuen Benutzer anlegen können

Given eine AbteilungX mit ID 1
And eine MitarbeiterX in der AbteilungX, mit Vornamen 'Peter' und Nachname 'Meier', geboren am 1970-09-09 und angestellt seit 2009-09-09
And einen Benutzeraccount für MitarbeiterX, mit Benutzername 'pmeier', passwort 'pass' und Mailadresse 'pmeier@qlb.ch'
When der Administrator den MitarbeiterX und seinen Benutzeraccount erfasst
Then ist MitarbeiterX in der AbteilungX mit ID 1 erfasst
And der zugehörige Benutzeraccount ist ebenfalls in der Datenbank gespeichert 
 