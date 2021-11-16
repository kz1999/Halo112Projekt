import React from "react";
import Student from "./Student";
import './styles/StudentList.css'

function UserList(){

    const [users, setUsers] = React.useState([]);
    
    React.useEffect(()=>{
        fetch("http://localhost:8080/korisnici")
        .then(data => data.json())
        .then(students => setUsers(users))
    }, []);
    
    return(
        <div>
            
            { users.map(users => <User key={user.jmbag} student = {user}/>)}
            
        </div>
    )
}

export default UserList;