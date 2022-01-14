import React from "react";
import ChangeUser from './ChangeUser';
import UsersList from "./UsersList";
import "./styles/Comments.css";


function Users(){

    const [userToChange, setUserToChange] = React.useState('');

    function returnToList(event){
        event.preventDefault();
        setUserToChange('');
    }

    if(userToChange===''){
        return(
            <UsersList setUserToChange = {setUserToChange}/>
        )
    }
    return(
        <div className="Users">
            <ChangeUser user = {userToChange}/>
            <button className="return-button" onClick={returnToList}>Return</button>
        </div>
    )
    
}

export default Users;