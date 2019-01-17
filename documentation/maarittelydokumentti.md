<h1>Määrittelydokumentti</h1>

<h2>Algoritmit ja tietorakenteet</h2>

Harjoitustyössä toteutetaan Kruskalin ja Primin algoritmit, joiden lisäksi pyrin toteuttamaan mahdollisuuksien
mukaan myös Boruvkan algoritmin sekä reverse-delete -algorimin. Algoritmit on valittu sillä perusteella, että ne
ovat yleisimpiä pienintä virittävää puuta selvittäviä algoritmeja. Näiden toteuttaminen puolestaan vaatii muun
muassa keon toteuttamista ja Union-find rakenteen toteuttamista.

<h2>Ratkaistava ongelma</h2>

Harjoitustyö vertailee pienintä virittävää puuta laskevien algoritmien tehokkuutta. Ohjelma tarkistaa, että
algoritmit saavat saman vastauksen ja laskee vastauksen laskemiseen kuluneet ajat vertailun vuoksi. Voisi siis
sanoa, että harjoitustyön tehtävä on selvittää, mikä algoritmeista on tehokkain ja toisaalta selviää myös, mikä on
kätevin algoritmi toteuttaa. Tietenkin molempiin asioihin vaikuttaa se, kuinka hyvin algoritmit on toteutettu 
ja tämä tulee ottaa vertailun loppupäätelmissä huomioon.

<h2>Syötteet</h2>

Tarkoituksena on käyttää satunnaisuutta sisältäviä, ohjelman itsensä generoimia verkkoja. Algoritmit tulevat
ratkaisemaan saman verkon pienimmän virittävän puun kerrallaan, jotta niitä voidaan vertailla. Tulen määrittelemään
verkkojen suuruusluokan siten, että algoritmien tehokkuuserot tulevat esille.

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
