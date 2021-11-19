import React from "react";
import './styles/User.css';

function User(props){
    const username = props.user.korisnickoIme;
    const name = props.user.ime;
    const lastName = props.user.prezime;
    const phoneNumber = props.user.brojMobitela;
    const email = props.user.email;
    const role = props.user.uloga;
    const confirmed = props.user.potvrden;

    return (
        <p>{username} {name} {lastName} {phoneNumber} {email} {role} {confirmed}</p>
    );
}

export default User;