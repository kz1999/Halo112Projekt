import React from "react";
import User from "./User";

function UsersList(props){

    const [users, setUsers] = React.useState([]);

    React.useEffect(()=>{
        fetch('/korisnici', {mode: "no-cors"})
        .then(data => data.json())
        .then(users => setUsers(users));
    }, []);

    return(
        <div className="Users">
            <h2>Users list</h2>
            <div className="flex-container">
                <div>USERNAME</div>
                <div>PASSWORD</div>
                <div>EMAIL</div>
                <div>NAME</div>
                <div>SURNAME</div>
                <div>PHONE NUMBER</div>
                <div>ROLE</div>
                <div>CONFIRMED</div>
            </div>
            { users.map(user => <User key={user.id} user = {user} setUserToChange = {props.setUserToChange}/>)}
        </div>
    )
    
    
}

export default UsersList;
