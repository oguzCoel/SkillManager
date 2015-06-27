Manage Abteilungs

Scenario: Adding a new abteilung

Given the list of abteilungen
| AbteilungId | AbteilungName                    | 
| 1           | Team Engineering &amp; Operations|
| 2           | Team Projekte &amp; Support      | 
| 3			  | Team Marketing &amp; Sales       |
| 4           | Finance &amp; Administration     |
When the user adds the abteilung testabteilung 
Then the list of abteilung is
| AbteilungId | AbteilungName                    | 
| 1           | Team Engineering &amp; Operations|
| 2           | Team Projekte &amp; Support      | 
| 3			  | Team Marketing &amp; Sales       |
| 4           | Finance &amp; Administration     |
| 5           | Testabteilung                    |

