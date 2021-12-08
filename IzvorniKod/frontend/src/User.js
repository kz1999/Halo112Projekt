import React from "react";
import './styles/User.css';
import ChangeUser from './ChangeUser';

function User(props){
    
    return (
        <div>
        <ChangeUser key={props.user.id} user = {props.user}/>
        </div>
    );
}

export default User;