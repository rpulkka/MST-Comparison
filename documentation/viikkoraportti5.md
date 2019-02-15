<h1>Viikko 5</h1>

Työmäärä: 12h

Tällä viikolla toteutin Edge oliolle eli kaarille tarkoitetun keon edellisen kokonaisluvuilla toteutetun hahmotelman
pohjalta. Tähän kului joitakin tunteja aikaa, mutta luokka vaikuttaa toimivalle, sillä se ei muuta algoritmejen 
antamia tuloksia.

Sain JUNIT testit toimimaan. Oletin virheellisesti nullPointerin johtuvan siitä, että JUNIT löydä tiedostoa, mutta 
vika olikin alustamattomassa tiedostonlukijassa. Tämä nolo erehdys maksoi myös pari tuntia aikaa, mutta toisaalta
se oli opettavainen sekä tiedoston lukemisen, että testin olioiden alustamisen kannalta.

Pajassa käydyn keskustelun tuloksena aloin muuttamaan Primin algoritmia, s.e. se käyttääkin vain yhtä kekoa, joihin
solmuista lähtevät kaaret sitten siirretään kaksiulotteisesta taulukosta, jossa x koordinaatti kertoo solmun ja y
koordinaatti erottaa siitä lähtevät eri kaaret. Tämä kuitenkin tuotti outOfMemoryErrorin 10000 kaaren kokoisessa
testissä, kun yritettiin alustaa kaksiulotteista taulukkoa, jonka koko on siis [solmujen määrä][kaarten määrä]. 
Lisäksi Primin algoritmi antaa muutoksen seurauksena nyt hieman vääriä tuloksia myös pienissä testeissä. Tämä
ongelma pitäisi ratkaista ensi viikolla. Vinkit voisivat auttaa, koska lähestymistapani ongelmaan saattaa olla 
virheellinen.

Pajassa keskusteltiin myös Boruvkan algoritmin tehottomuudesta, joka johtuu siitä, että se joutuu tekemään isoissa
testeissä todella monta kekoa. Tähän yksi ratkaisu oli ilmeisesti kekojen koon optimointi sopivaksi ja turhien
kekojen poistaminen. Tämä vaatii vielä paljon suunnittelua ja on toteutettava edellisen ongelman jälkeen.
