<h1>Viikko 2</h1>

Työmäärä: 11h

Tällä viikolla toteutin Kruskalin ja Primin algoritmit käyttäen apuna Javan valmiita kirjastoja. Lisäksi sain 
ohjelman lukemaan kaarten tietoja .csv -muotoisista tiedostoista, niin että jokaisella rivilla on yhden kaaren
tiedot muodossa "x,y,z", jossa x on alkusolmu, y on loppusolmu ja z on kaaren pituus. Ohjelma tällä hetkellä lukee 
tiedot kolmeen taulukkoon: alkusolmun, loppusolmun ja pituuden  sisältäviin taulukoihin.  Suunnittelin kaksi 
yksinkertaistettua testiverkkoa, joilla testasin ohjelman toimintaa. Ensimmäinen näistä on jo muunnettu .csv 
-formaattiin ja ohjelman pääluokka on tällä hetkellä laitettu laskemaan sitä Kruskalin ja Primin algoritmeilla. 
Molemmat niistä on kirjoitettu testeiksi. Lisään piirrokset testidatasta tämän raportin loppuun kuvina.

Haasteita ohjelman toteutuksessa tulee olemaan se, miten muutan tiedostosta luetun datan kullekin algoritmille 
sopivaan muotoon. Ensinnäkin, olen muotoillut testidatana käyttämäni .csv dokumentin s.e. kaaret on kirjoitettu
kahteen kertaan, solmusta A solmuun B ja solmusta B solmuun A. Tämä kuulostaa hieman epäkäytännölliselle, varsinkin
jos ohjelmalla halutaan testata muiden tekemiä verkkoja, koska ne tuskin on merkitty kirjoittamalla sama kaari
tiedostoon kahdesti. En vielä ole keksinyt muuta tapaa saada kaarien esitystä toimimaan Primin algoritmilla. Tämä 
esitys kuitenkin oli luultavasti syynä Boruvkan algoritmin epäonnistumiseen, koska siinä aiheutui ongelma saman
kaaren löytyessä verkosta toistamiseen. Toiseksi, nyt olen toteuttanut Kruskalin ja Primin algoritmit siten, että
ne muokkaavat taulukoista luetun datan kaari-olioksi ja tämä saattaa olla tarpeeton ja hidas vaihe, mutta en ole 
ehtinyt vielä miettiä sille parempaa ratkaisua. 

Reverse-Delete algoritmissa mietityttää se, että jos ollaan poistamassa kaarta verkosta, tarvitaan tieto siitä,
rikkooko poistaminen puun vai ei, siis toisin sanoen, säilyykö poiston jälkeen yhteys jokaisen solmun välillä.
Minusta tämä ei vaikuta kovin triviaalilta. Union-Find osaa kyllä yhdistää verkkoja saman "parentin" alle, mutta
en tiedä kuinka tapahtuu verkon jakaminen kahteen, tai voisiko sen ongelman ylipäätään välttää jotenkin.

Ensi viikolla jatkuu näiden ongelmien ratkaiseminen ja Boruvkan algoritmin toteutus.

---

Ensimmäinen testiverkko, lähtötilanne:

(images/testgraph1.png)

Ensimmäinen testiverkko, lopputilanne:

(images/testgraph1res.png)

Toinen testiverkko, lähtötilanne:

(images/testgraph2.png)

Toinen testiverkko, lopputilanne:

(images/testgraph2res.png)
