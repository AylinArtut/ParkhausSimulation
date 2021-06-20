# ParkhausSimulation

Ein webbasiertes Projekt für das Studium mit Java, welches ein Parkhausverwaltungssystem simuliert. :tulip:
Neben Quellcode versioniere ich auch meine Projektplanung, sowie meine einsamen Kanbanboard-Aktivitäten. :frog:

-------------------------------------------------------------------------------------------------------------------

**New cute feature:**

Das Frauen-Parkhäusschen im Prinzessin-Style muss vor Start spielerisch betreten werden. :smile:

Gespielt wird, indem man per Drag & Drop die Prinzessin-Fahrerin auf das Schloss artige Parkhaus zieht. :octocat:

![alt text](https://s20.directupload.net/images/210620/yafn5g2q.jpg) 

Jetzt auch mit Tabelle der Preise für die Autos, welche das Parkhaus verlassen haben:

![alt text](https://s20.directupload.net/images/210620/r8drsh2c.jpg) 

-------------------------------------------------------------------------------------------------------------------
**Screenshot des aktuellen Stands:**

Die bunten (Farbe wird zufällig generiert), ovalen Elemente sollen die Autos darstellen & das Rechteck indem sie sich befinden die Parkplätze:

![alt text](https://bilderupload.org/image/860374329-parkhaus-screenshot.jpg) 

Jetzt auch mit der Möglichkeit das Parkhaus zu verlassen:

![alt text](https://bilderupload.org/image/e55188520-yayy.jpg)

-------------------------------------------------------------------------------------------------------------------

<table>
  <thead>
    <tr>
      <th>Allgemeine ToDo's & Tasks:</th>
      <th>In Progress:</th>
      <th>Done:</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td></td>
      <td></td>
      <td>Grobe Planung des Parkhauses mit Skizze (Produkt Vision)</td>
    </tr>
    <tr>
      <td></td>
      <td></td>
      <td>Erstellung der User Stories</td>
    </tr>
    <tr>
      <td></td>
      <td></td>
      <td>Lokale Einrichtung des Tomcat-Servers in der IDE (IntelliJ)</td>
    </tr>
    <tr>
      <td></td>
      <td></td>
      <td>Einfindung in Funktionsweise mit Servlets & Co. (Erstellung von Test-Servlets & -Klassen)</td>
    </tr>
     <tr>
      <td></td>
      <td></td>
      <td>Planung bzw. Erstellung benötigter Klassen ("Car" & "CarPark")</td>
    </tr>
     <tr>
      <td></td>
      <td></td>
      <td>Planung der benötigten Methoden für Klasse "Car"</td>
    </tr>
    <tr>
      <td></td>
      <td></td>
      <td>Planung der benötigten Methoden für Klasse "CarPark"</td>
    </tr>
    <tr>
      <td>Erstellung der JUnittests für die Klasse "Car"</td>
      <td></td>
      <td></td>
    </tr>
    <tr>
      <td>Erstellung der JUnittests für die Klasse "CarPark"</td>
      <td></td>
      <td></td>
    </tr>
    <tr>
      <td></td>
      <td>Erstellung der Methoden für die Klasse "Car"</td>
      <td></td>
    </tr>
    <tr>
      <td></td>
      <td>Erstellung der Methoden für die Klasse "CarPark"</td>
      <td></td>
    </tr>
    <tr>
      <td></td>
      <td>Erstellung der Benutzeroberfläche mit Buttons & Co.</td>
      <td></td>
    </tr>
    <tr>
      <td>Optional: Mini-Browsergame mit Hinzunahme von jQuery (Auto-Steuerung etc.)</td>
      <td></td>
      <td></td>
    </tr>
  </tbody>
</table>

-------------------------------------------------------------------------------------------------------------------

**Grobe Vorstellung (Produkt Vision):**
![alt text](https://s12.directupload.net/images/210430/ok2ufitt.png)

-------------------------------------------------------------------------------------------------------------------

**Planung benötigter Methoden für beide Klassen:**
![alt text](https://s8.directupload.net/images/210430/anzn8bxp.png)

-------------------------------------------------------------------------------------------------------------------

<table>
  <thead>
    <th>User Stories:</th>
  </thead>
  <tbody>
    <tr>
      <td>Enter-Button (zum Betreten des Parkhauses)</td>
    </tr>
    <tr>
      <td>Leave-Button (zum Verlassen des Parkhauses)</td>
    </tr>
    <tr>
      <td>Tabelle (zur Erfassung von allen Parkgebühren)</td>
    </tr>
    <tr>
      <td>Parkschein (für Zeit-Erfassung / TimeStamp)</td>
    </tr>
    <tr>
      <td>Preisliste (Grundpreis | in Stunden | keine Zahlung beim Verlassen nach 5 Minuten)</td>
    </tr>
  </tbody>
</table>
