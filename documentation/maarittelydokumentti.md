<h1>Määrittelydokumentti</h1>

<h2>Algoritmit ja tietorakenteet</h2>

Harjoitustyössä toteutetaan Kruskalin ja Primin algoritmit, joiden lisäksi pyrin toteuttamaan mahdollisuuksien
mukaan myös Boruvkan algoritmin sekä reverse-delete -algorimin. Algoritmit on valittu sillä perusteella, että ne
ovat yleisimpiä pienintä virittävää puuta selvittäviä algoritmeja. Näiden toteuttaminen puolestaan vaatii muun
muassa keon toteuttamista ja Union-find rakenteen toteuttamista.

<h2>Ratkaistava ongelma</h2>

Harjoitustyö vertailee pienintä virittävää puuta laskevien algoritmien tehokkuutta. Ohjelma tarkistaa, että
algoritmit saavat saman vastauksen ja laskee vastauksen laskemiseen kuluneet ajat vertailun vuoksi. Samalla 
vastauksella tarkoitetaan tässä tapauksessa sitä, että algoritmit laskevat pienimmän virittävän puun kaarten 
summan, jolloin kaikilla tulisi olla sama vastaus, vaikka ne päätyisivätkin erilaisiin puihin. Voisi siis
sanoa, että harjoitustyön tehtävä on selvittää, mikä algoritmeista on tehokkain ja toisaalta selviää myös, mikä on
kätevin algoritmi toteuttaa. Tietenkin molempiin asioihin vaikuttaa se, kuinka hyvin algoritmit on toteutettu 
ja tämä tulee ottaa vertailun loppupäätelmissä huomioon.

<h2>Syötteet</h2>

Puut syötetään ohjelmaan .csv -muotoisina tiedostoina, jossa jokainen rivi sisältää yhden kaaren tiedot. Jokaisesta
kaaresta tallennetaan alkusolmu, loppusolmu ja pituus, kaikki kokonaislukuina ja ne erotetaan tiedostossa pilkulla.
Esim. rivi "1,2,3" merkitsee kaarta, joka alkaa solmusta 1, päättyy solmuun 2 ja on pituudeltaan 3. Tavoitteena
olisi, että tiedostomuotoiset syötteet mahdollistaisivat myös muiden tekemien (esim. internetistä ladattujen)
verkkojen ratkaisemisen. Ohjelmaan voitaisiin myös mahdollisesti lisätä verkkoja generoiva aliohjelma, joka 
generoisi sopivia verkkoja jokseenkin satunnaisesti. Algoritmit tulevat ratkaisemaan saman verkon pienimmän
virittävän puun kerrallaan, jotta niitä voidaan vertailla. Tulen määrittelemään vertailussa käytettävien verkkojen
suuruusluokan siten, että algoritmien tehokkuuserot tulevat esille, mutta toki ohjelmaa voi kokeilla monenlaisilla
syötteillä.

<h2>Tavoitteet aikavaativuudessa</h2>

Tarkoituksena on päästä mahdollisimman lähelle kunkin algoritmin teoreettista aikavaativuutta. Kruskalin, Primin ja
Boruvkan algoritmin aikavaativuus on O(E log V), jossa E on kaarten määrä ja V on solmujen määrä. Reverse-delete
-algoritmin aikavaativuus on O(E log V (log log V)3), jossa E on kaarten määrä ja V on solmujen määrä.

<h2>Linkkejä</h2>

Havainnollistava video Boruvkan algoritmista sekä Reverse-Delete algoritmista:

[Video](https://www.youtube.com/watch?v=czcf73b0Ga0)

Wikipedia -linkit algoritmien kuvauksiin:

[Kruskal](https://en.wikipedia.org/wiki/Kruskal%27s_algorithm)<br/>
[Prim](https://en.wikipedia.org/wiki/Prim%27s_algorithm)<br/>
[Boruvka](https://en.wikipedia.org/wiki/Bor%C5%AFvka%27s_algorithm)<br/>
[Reverse-delete](https://en.wikipedia.org/wiki/Reverse-delete_algorithm)</br>
