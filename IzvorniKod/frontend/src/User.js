import React from "react";
import './styles/User.css';
import ChangeUser from './ChangeUser';

function User(props){

    /*
    const id = props.user.id;
    const username = props.user.userName;
    const password = props.user.passwordHash;
    const photo = props.user.photo;
    const name = props.user.name;
    const surname = props.user.surname;
    const phoneNumber = props.user.phoneNumber;
    const email = props.user.email;
    const role = props.user.role;
    const confirmed = props.user.confirmed;
    */
    
    return (
        <div>
        {/*({id}) {username} {password} {photo} {name} {surname} {phoneNumber} {email} {role} ({confirmed}) */}
        <ChangeUser key={props.user.id} user = {props.user}/>
        </div>
        
        
    );
}

export default User;