# TESZTESET
## Azonosító
E2ERegistrationTest
## Cím
Budapest13 Smart City alkalmazás letöltése és regisztrálás
## Rövid jellemzés
A teszteset célja hogy a felhasználó letölti a Budapest13 Smart City alkalmazást a Google Play Store-on keresztül, telepíti, regisztrálja magát, majd egy visszaigazoló e-mail-ben ezt megerősíti.
## Előfeltétel
- Internetkapcsolat
- Google fiók
- Android operációs rendszerrel rendelkező telefon
## Teszt követelmények
- JAVA - Magasszintű programnyelv, amiben íródott a teszt
- IntelliJ IDEA - A környezet ahol a teszt íródott
- Maven - Tool, ami a különböző dependenciák futtatásáért felelős
- Selenium v4.21.0 - Teszteléshez szükséges metódusok
- Appium v9.2.2. - Mobil teszteléshez szükséges metódusok könyvtára
- TestNG v7.10.2 - A tesztesetek futtatását teszi lehetővé
- Android Studio - Program, ahol egy android mobil környezete szimulálható
- Appium Server GUI - Program, ami virtális kapcsolatot teremt az IDEA és a szimulált telefon között
- Appium Inspector - Program, amivel megkereshetőek az element-ek
## Teszt lépések
1. Megnyitom a Google Play Store-t
2. Rákeresek a "Budapest13 Smart City" alkalmazásra
3. Ha ez megjelenik, letöltöm és telepítem
4. Megnyitom az alkalmazást
5. Elutasítom az értesítés lehetőséget
5. Rányomok a UserProfile jelre a bal felső sarokban
6. Rányomok a Register Now linkre
7. Kitöltöm a regisztrációhoz szükséges adatok, elfogadom a szerződéseket
8. Rányomok a Next gombra
9. Rányomok a Skip gombra
10. Ha létrejön a felhasználó fiók, rányomok az OK gombra a felugró ablakon
11. Átmegyek az e-mail fiókomba
12. Megkeresem a visszaigazoló e-mailt a megerősítésre, és rányomok
13. Rányomok a Megerősítés gombra
## Elvárt működés
Létrejön a felhasználó fiók a Budapest13 Smart City alkalmazásban