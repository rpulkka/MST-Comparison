<h1>Käyttöohjeet</h1>

<h2>Käynnistäminen</h2>

Lataa .jar tiedosto Release kohdasta. Käynnistä .jar komennolla 'java -jar MST_Comparison.jar'. Voit myös kloonata repon ja 
käynnistää ohjelman NetBeansista.

<h2>Käyttötarkoitukset<h2>

Vaihtoehto 1 suorittaa valitsemasi testitiedoston kerran. Kirjoita tiedoston nimi muodossa nimi.csv . Valittavat tiedostot näkyvät
kansiossa src/main/resources. Jos haluat lisätä sinne oman tiedostosi, ainoa mahdollisuus ajaa se on avata ohjelma NetBeansin 
kautta, .jar avaa vain sisällään olevia tiedostoja, eli ne mitkä on valmiina edellä mainitussa kansiossa.
<p/>
Vaihtoehto 2 on tehdä suorituskykytestaus. Valitse tiedosto samoin kuin kohdassa 1. Tiedosto ajetaan 100 kertaa kullakin 
algoritmilla ja näiden aikojen keskiarvo tulostuu näytölle.
<p/>
Vaihtoehto 3 on luoda ohjelman avulla uusi verkko. Seuraa ohjeita parametrien antamiseksi. Muista, että liian suuret (100000+)
syötteet saattavat kaataa ohjelman ja että jos solmujen suhde on suuri kaariin nähden, ohjelma saattaa luoda epäyhtenäisen verkon,
jolloin tulokset ovat vääriä. Lopuksi ohjelma ajaa muodostetun verkon ja kertoo tulokset. 
<p/>
Sulje ohjelma syötteellä 4.
