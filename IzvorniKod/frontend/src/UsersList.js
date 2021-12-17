import React from "react";
import User from "./User";
import ChangeUser from './ChangeUser';

function UsersList(){

    const [users, setUsers] = React.useState([]);
    const [userToChange, setUserToChange] = React.useState('');

    React.useEffect(()=>{
        fetch('/korisnici', {mode: "no-cors"})
        .then(data => data.json())
        .then(users => setUsers(users));
    }, []);

    function returnToList(event){
        event.preventDefault();
        setUserToChange('');
    }

    if(userToChange===''){
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
                { users.map(user => <User key={user.id} user = {user} setUserToChange = {setUserToChange}/>)}
            </div>
        )
    }
    else{
        return(
            <div className="Users">
                <ChangeUser user = {userToChange}/>
                <button onClick={returnToList}>Return</button>
            </div>
        )
    }
}

export default UsersList;