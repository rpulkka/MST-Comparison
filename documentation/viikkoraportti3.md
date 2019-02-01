<h1> Viikko 3 </h1>

Työmäärä: 11h

Tällä viikolla yritin toteuttaa Boruvkan algoritmin sekä tein jonkin verran refaktorointia. Monen yrityksen jälkeen 
se vaikutti toimivalle pienten esimerkkiverkkojen kanssa. Loppuviikosta kuitenkin tein simppelöidyn 
verkkogeneraattorin GraphCreator -luokkaan. Verkkojen koon kasvaessa noin sadan kieppeille, havaitsin että Boruvkan 
algoritmi antaa hieman muista poikkeavan tuloksen. Monien tulostusten jälkeen löysin kohdan, missä Boruvka valitsee 
toisin kuin muut algoritmit, mutta siinä
vaiheessa se vaikuttaa toimivan kuitenkin loogisesti. En osaa vielä sanoa, miksi algoritmi tuottaa väärän tuloksen 
enkä oikeastaan tiedä kuinka saisin sen selville, olen jo yrittänyt selvittää asiaa tulostuksilla, mutta tuntien 
jälkeen löysin poikkeavan kohdan sen toiminnassa, mutta en varsinaista virhettä, sillä siinäkin kohtaa se näyttää
toimivan oikein. Luultavasti tässä tapauksessa pitäisi jakaa algoritmi osiin ja tulostusten sijaan kirjoittaa 
testejä algorimin osille, mutta en ole varma pääsenkö silti ongelman ytimeen vai testaanko vain turhaan lopullisesti
toimimatonta algoritmia. Ikävä seikka on se, että algoritmi toimii lähes oikein, sen tulos heittää korkeintaan yhden
kaaren pituuden verran (vaikka se kyllä valitsee saman määrän kaaria kuin muut algoritmit ja sen sijaan tekee 
joitakin poikkeavia valintoja kaarten suhteen). Boruvka -luokka on ongelmasta johtuen sotkuinen ja täynnä
tulostuksia. Test Graph #3 on GraphCreator -luokan luoma verkko, jonka muutin tiedostomuotoon ja olen yrittänyt
selvittää ongelmaa sen avulla, koska siinä Boruvka antaa väärän tuloksen. Itse pidän 3. viikkoa epäonnistumisena,
algoritmin toimimattomuudesta johtuva debuggaus on suuri riski harjoitustyön onnistumisen kannalta, sillä siihen on
jo kulunut tunteja, eikä sen selvittämisessä olla vielä pitkällä. Ensi viikko luultavasti kuluu testaukseen, koska
muu tekeminen on tässä tilanteessa melko järjetöntä.
