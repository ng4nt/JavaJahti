# JavaJahti
JavaJahti on Android‑mobiilisovellus, joka toimii oppimispelinä Java‑ohjelmoinnin yleisimpien virheiden tunnistamiseen. Sovellus esittää käyttäjälle koodiesimerkkejä, joissa on virhe. Käyttäjän tehtävänä on valita oikea virhetyyppi.

Seminaarityön tavoitteena on edistää omaa Java-osaamista ja perehtyen samalla Kotliniin. Tavoitteena myös oppia Android Studiota ja mobiiliohjelmointia paremmin.
Ongelmakoodit saadaan valmiista tehtäväpankista. Peli ei vaadi tietokantaa, vaan tehtävät koodataan suoraan sovelluksen lähdekoodiin.


Ominaisuudet
- Monivalintapeli Java‑koodin virheiden tunnistamiseen
- Tilastonäkymä pelin lopussa
- Datan visualisointi Chart.js‑kirjastolla
- Oma sovelluskuvake ja splash screen
- Pelin toimivuus testattu emulaattorilla ja Samsung S9 -puhelimella

---

## Virhetyypit
Sovellus kattaa seuraavat Java‑virhetyypit:

- **Syntaksivirhe**
- **Tietotyyppivirhe**
- **Logiikkavirhe**
- **Vertailu‑ ja sijoitusvirhe**

Pelin lopussa käyttäjälle näytetään kaksi toimintopainiketta:
- **Tarkastele tuloksia**, joka avaa erillisen tilastonäkymän
- **Aloita alusta**, joka käynnistää pelin uudelleen

Tehtävät perustuvat valmiiseen tehtäväpankkiin, joka on määritelty suoraan sovelluksen lähdekoodissa. Sovellus ei käytä tietokantaa, vaan kaikki data käsitellään sovelluksen muistissa.

Tilastonäkymä on toteutettu erillisessä `StatsActivity`‑luokassa hyödyntäen Androidin WebView‑komponenttia.

---

## Tilastot ja datan visualisointi
Pelin lopussa käyttäjä voi siirtyä erilliseen tilastonäkymään, jossa pelin aikana kerätty data visualisoidaan.

Tilastonäkymä sisältää:
- Oikeat vs. Väärät vastaukset piirakkakaaviolla
- Virhetyyppien jakauma

Visualisointi on toteutettu **Chart.js**‑kirjaston avulla WebView‑komponentissa. Tavoitteena oli yhdistää kurssiin liittyvä aihe mobiiliohjelmointiin.

---

## Käytetyt teknologiat
- **Kotlin** – pääasiallinen ohjelmointikieli
- **Android Studio** – kehitysympäristö
- **Android SDK** – Android‑sovelluksen rajapinnat
- **ConstraintLayout** – käyttöliittymän toteutus
- **WebView** – web‑sisällön näyttämiseen sovelluksessa
- **Chart.js** – tilastojen ja kaavioiden visualisointiin
- **Material Design** – käyttöliittymän visuaaliset periaatteet
---

## Sovelluksen rakenne
- `MainActivity`  
  Vastaa pelilogiikasta, kysymysten näyttämisestä ja käyttäjän vastauksista.

- `StatsActivity`  
  Näyttää tilastot WebViewn kautta käyttäen Chart.js‑kaavioita.

- `CodeTask`  
  Malliluokka yhdelle kooditehtävälle.

- `ErrorType`  
  Enum‑luokka mahdollisille virhetyypeille.


## Jatkokehitysideat
Mahdollisia jatkokehitysideoita sovellukselle ovat:
- laajempi tehtäväpankki tai satunnaisesti vaihtuvat tehtävät
- käyttäjäkohtainen pistelasku ja tallennetut tulokset
- vaikeustasojen lisääminen
- kieliversiot (esim. englanninkielinen käyttöliittymä)
- opettavampi palaute, jossa virhe selitetään vastauksen jälkeen

---
Projektin aikana opin merkittävästi sekä ohjelmoinnista että mobiilisovelluskehityksestä. Aiempi kokemukseni painottui pääasiassa Java‑ohjelmointiin, mutta tämän työn kautta pääsin soveltamaan osaamistani käytännössä Android‑ympäristössä ja tutustumaan Kotlin‑kieleen.
Opitut keskeiset asiat:

- Android‑sovelluksen rakenne ja activity‑pohjainen navigaatio
- käyttöliittymän rakentaminen XML:llä ja ConstraintLayoutilla
- tapahtumapohjainen ohjelmointi (napinpainallukset, käyttöliittymän tila)
- pelilogiikan hallinta ilman tietokantaa
- datan kerääminen ja visualisointi mobiilisovelluksessa
- WebView‑komponentin ja JavaScript‑rajapinnan käyttö

Opin myös suunnittelemaan käyttöliittymää käyttäjän näkökulmasta, esimerkiksi milloin painikkeiden tulee olla näkyvissä ja miten käyttäjälle annetaan selkeä palaute toiminnasta.

---

## Lähteet
Projektissa on hyödynnetty seuraavia lähteitä:
- Android Developers ‑dokumentaatio https://developer.android.com
- Chart.js virallinen dokumentaatio https://www.chartjs.org
- Kotlin‑kielen dokumentaatio https://kotlinlang.org
- https://www.geeksforgeeks.org/android/how-to-create-a-quiz-app-in-android/
