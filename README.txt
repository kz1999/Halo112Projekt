Backend:
GET na / vraća string "Index page!"

GET na /helloworld vraća login page ako korisnik nije ulogiran,
		   ovaj link je u svrhu testiranja role("ADMIN")
		   i samo admin ima pristup, ako je admin ulogiran
		   vraća string "Hello world"

GET na /login vraća string "LOGIN PAGE"
POST na /login ulogira korisnika uz dane parametre i ako
		je login uspješan vraća "Index page!", u
		suprotnom vraća "LOGIN PAGE"

GET na /korisnici vraća sve korisnike
POST na /korisnici kreira novog korisnika

GET na /korisnici/{userName} vraća pojedinog korisnika ako 
			     postoji, u suprotnom vraća "null"
POST na /korisnici/{userName} mijenja atribute zadanog korisnika
			      i vraća ga

GET na /user vraća trenutno ulogiranog usera, ako nitko nije
	     ulogiran, vraća null

Sve metode se mogu isprobati na Postman
POST na /login se daje u obliku x-www-form-urlencoded

POST na /korisnici se daje u obliku JSON
			(userName ne smije biti prazan niti null)
POST na /korisnici/{userName} se također daje u obliku JSON
			(userName ne smije biti prazan niti null)
	primjer:
		{
			"userName": "Thompson",
			"name": "Marko",
			"surname": "Perković",
			"pass": "password123"
		}

