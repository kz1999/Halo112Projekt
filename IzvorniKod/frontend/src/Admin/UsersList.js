import React from "react";
import User from "./User";

function UsersList(props){

    const [users, setUsers] = React.useState([]);

    React.useEffect(()=>{
        
        fetch('/korisnici')
        .then(data => data.json())
        .then(users => setUsers(users));
        
    }, []);

    return(
        <div className="Users">
            <h2>Popis korisnika</h2>
            <div className="flex-container">
                <div>KORISNICKO IME</div>
                <div>ŠIFRA</div>
                <div>E-MAIL</div>
                <div>IME</div>
                <div>PREZIME</div>
                <div>TELEFONSKI BROJ</div>
                <div>ULOGA</div>
                <div>POTVRĐEN</div>
            </div>
            { users.map(user => <User key={user.id} user = {user} setUserToChange = {props.setUserToChange}/>)}
        </div>
    )
    
    
}

export default UsersList;
