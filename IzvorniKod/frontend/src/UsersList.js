import React from "react";
import User from "./User";


function UsersList(){

    const [users, setUsers] = React.useState([]);
    
    React.useEffect(()=>{
        fetch('/korisnici')
        .then(data => data.json())
        .then(users => setUsers(users))
    }, []);
    
    return(
        <div className="Users">
            <h2>Users list</h2>
            <div className="flex-container">
                <div>
                    userName
                </div>
                <div>
                    password
                </div>
                <div >                    
                    email
                </div>
                <div>
                    name
                </div>
                <div>
                    lastName
                </div>
                <div>
                    phoneNumber
                </div>
                <div >                    
                    role
                </div>
                <div >                    
                    confirmed
                </div>
                </div>
            { users.map(user => <User key={user.id} user = {user}/>)}
            
        </div>
    )
}

export default UsersList;