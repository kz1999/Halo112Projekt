import React from "react";
import './styles/User.css';


function StationDirectorDiv(props){

    const [director, setDirector] = React.useState([]);
    const [korisnici, setKorisnici] = React.useState([]);

    React.useEffect(()=>{
        fetch('/spasioci/'+props.director_id)
        .then(data => data.json())
        .then(data => setDirector(data));
    }, []);

    React.useEffect(()=>{
        fetch('/korisnici')
        .then(data => data.json())
        .then(data => setKorisnici(data));
    }, []);

    return(
        <div>{props.stationName}, {korisnici.filter(korisnik => korisnik.id === director.user_id)[0]}</div>
    )
}

export default StationDirectorDiv;