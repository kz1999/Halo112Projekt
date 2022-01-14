Upute za pokretanje backenda:

Linkovi za skidanje Eclipse-a i Mavena:
https://www.eclipse.org/downloads/
https://maven.apache.org/download.cgi

Nakon što ste skinuli maven, raspakirajte sadržaj arhive u neki vršni direktorij.
Definirajte da varijabla okruženja M2_HOME pokazuje na vršni direktorij instalacije maven.
U varijablu okruženja PATH dodajte putanju do bin direktorija koji se nalazi u vršnom direktoriju mavena.

U Eclipse-u treba dodati maven projekt:
Eclipse -> File -> Import -> Maven -> Existing Maven Projects, pa u Root Directory postavite putanju do "backend" direktorija.
Označite kvačicu kod "/pom.xml" od halo112 projekta.
Kliknite finish.

U paketu com.example.halo112_generic koji se nalazi unutar src/main/java otvorite Halo112GenericApplication.java
Backend možete pokrenut klikanjem na gumb "Run" (nalazi se u alatnoj traci, zelene boje s bijelim trokutićem unutra).