potrebno je prvo otici u frontend folder, iz njega otvoriti command prompt i pokrenuti sljedeću naredbu koja će instalirati potrebnu verziju reacta:

### npm install react-scripts --save

otići u package.json i u posljednjem redku promjeniti link u: http://halo112h.herokuapp.com/
potom pokrenuti aplikaciju iz naredbenog retka sa sljedećom naredbom:

### npm start

browser bi trebao automatski pokrenuti stranicu: http://localhost:3000, ali ako nece, mozete ju rucno otvoriti.

login ne radi, pa se moze unijeti bilo koje ime za ulazak u program, prije pritiska na gumb login nije dostupan nijedan link osim /login i /register.

nakon pritiska na gumb ulazi se u stranicu i frontend se ponasa kao da je admin. Mogu se mijenjati podaci korisnika, ili dodavati novi na /register. Dostupna je i main stranica koja bi se prikazivala svima (cak i ne adminima).

*napomena: login ne radi isključivo na frontendu, na backendu je implementiran. Ideja je da kad se netko ulogira, samo ako je admin moze vidjeti i uredivati tude podatke. Inace bi mu bila dostupna samo /main stranica
