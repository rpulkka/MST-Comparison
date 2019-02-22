<h1>Viikko 6</h1>

Työmäärä: 9h

Viikko oli työmäärältään hieman pienempi kuin muutama aiempi viikko, mutta se oli sitäkin tuotteliaampi ja 
palkitsevampi. Useampikin asia saatiin korjattua ja projektin onnistuminen alkaa näyttää todennäköiseltä.

Ensiksi sain korjattua Primin algoritmia vaivanneet omiin tietorakenteisiin siirtymisestä seuranneet ongelmat. Tähän
meni aikaa muutama tunti.

Seuraavaksi toteutin viime viikolla tekemäni keon pohjalta valmiiksi kaarille tarkoitetun keko -luokan, EdgeHeap.
Tämän jälkeen toteutin myös muut projektissa tarpeelliset tietorakenteet, eli taulukkolistan sekä numeroille, että
olioille ja lisäksi setin numeroille. Nyt kaikkien tietorakenteiden pitäisi olla omatekoisia, eikä Javan toteuttamia
kirjastojen tietorakenteita.

Pajasta saatujen neuvojen avulla sain myös korjattua Primin algoritmia vaivanneen outOfMemoryErrorin alkamalla 
käyttää kaarilistaesitystä algoritmin toteutuksessa. 

Toteutin ohjelmaan PerformanceTester luokan, joka laskee keskiarvoja algoritmien suoritusajoista testattavan
verkon tapauksessa. En ole vielä kuitenkaan laajemmin tehnyt suorituskykytestausta, koska pidän mielekkäämpänä
testata algoritmeja, sitten kun ne ovat vielä lähempänä lopullista muotoaan. Testasin kuitenkin kahdella verkolla
aliohjelman toimintaa, sain tulokseksi largeTest1.csv tiedostolla seuraavat sadan suorituksen keskiarvot: Kruskal 
(39ms), Prim (509ms), Boruvka (669ms). Ja largeTest2.csv tiedostolla seuraavat sadan suorituksen keskiarvot: Kruskal 
(27ms), Prim (509ms), Boruvka (688ms). Kruskal on siis nyt huomattavasti muita nopeampi. En ole vielä täysin varma
kuinka muita algorimeja tulisi optimoida tai onko se mahdollista ja järkevää.

Seuraavaksi aion keskittyä ohjelman käyttöliittymän hiomiseen ja kommentointiin. Olisi kiva myös saada neuvoja Primin
ja Boruvkan optimointiin, jos se nähdään tarpeelliseksi. Otan myös vastaan mielipiteitä siitä, mitä minun pitäisi 
tehdä seuraavaksi. Mahdollisia ohjelman parannuksia olisivat mm. Reverse-Delete algoritmin toteutus, joka vaikuttaa
hankalalta ja satunnaislukujen generointi. Onkohan yksikkötestaus vielä riittävän hyvää, voisin ehkä parantaa
sitäkin. En ole ihan varma, mitä olisi järkevää tehdä seuraavaksi.
