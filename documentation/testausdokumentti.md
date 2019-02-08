<h1>Testausdokumentti</h1>

HUOM! Testaus on suoritettu manuaalisesti, koska en toistaiseksi onnistunut saamaan JUNIT testejä lukemaan
tiedostoja. Tulevilla viikoilla tilanne tullaan korjaamaan.
<p/>
Ohjelmaa on testattu lukuisilla valmiiksi generoiduilla verkoilla. Testaukseen käytetyt verkot löytyvät kansiosta
src/main/resources. Tänne sijoitetaan kaikki verkot, joita halutaan testata, csv. muodossa. Suurin osa 
tämänhetkisistä testiverkoista on generoitu ohjelmaan sisältyvällä GraphCreator luokalla, joka on kuitenkin vielä
kehitysvaiheessa, jotkut pienet verkot olen puolestaan laatinut itse. Algoritmit toimivat manuaalisen testauksen 
nojalla oikein kaikissa tähän asti laadituissa testeissä.
<p/>
Testidokumentteja voi suorittaa käynnistämällä ohjelman, ja sitten kirjoittamalla tiedoston nimi muodossa nimi.scv ja
painamalla enter. Tarjolla olevien testitiedostojen nimet tulostuvat ohjelman käynnistyessä.
<p/>
simpleTest1.csv ja simpleTest2.csv ovat helppoja esimerkkiverkkoja, joilla testasin aluksi, että algoritmit toimivat
oikein pienissä verkoissa, jotka eivät sisällä erikoistapauksia.
<p/>
emptyGraph.csv sisältää tyhjän verkon.
<p/>
singleEdge.csv on yhden kaaren kokoinen verkko.
<p/>
overlappingEdges.csv on verkko, joka sisältää ainakin kaksi "päällekkäistä" kaarta, eli kaksi kaarta, jotka 
yhdistävät samat solmut. 
<p/>
preMadeMST.csv sisältää pienen verkon, jonka MST on sama kuin verkko itse.
<p/>
twoIdenticalEdges.csv dokumentin verkko sisältää kaksi identtistä kaarta.
<p/>
nonConnectedVertex.csv on tapaus verkosta, jossa on solmu, josta ei lähde kaaria.
<p/>
largeTestX.csv dokumentit (X = 1..5) sisältävät GraphCreatorilla luotuja suuria verkkoja, joissa on 100000 kaarta ja
20000 solmua. 
<p/>
Suurista testeistä huomataan, että Primin algoritmi toimii tällä erää selvästi muita hitaammin, joten sitä tulee 
optimoida. Tämä johtuu luultavasti siitä, että sen tarvitsee lisätä kaaret kekoon kahdesti.
