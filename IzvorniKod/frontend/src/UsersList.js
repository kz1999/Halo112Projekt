import React from "react";
import User from "./User";
import Card from "./Card";

function UsersList(){

    const [users, setUsers] = React.useState([]);
    
    React.useEffect(()=>{
        fetch('/korisnici')
        .then(data => data.json())
        .then(users => setUsers(users))
    }, []);
    
    return(
        <Card title="Users">
            
            { users.map(user => <User key={user.id} user = {user}/>)}
            
        </Card>
    )
}

export default UsersList;