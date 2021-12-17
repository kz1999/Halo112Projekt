import React from "react";
import './styles/User.css';


function User(props){

    function onClick(event){
        event.preventDefault();
        //promjeni iz unconfirmed u confirmed (post na /korisnici/username)
    }

    return(
        <div className="flex-container">
            <div className="link" onClick={props.setUserToChange(props.user.userName)}>{props.user.userName}</div>
            <div>{props.user.password}</div>
            <div>{props.user.email}</div>
            <div>{props.user.name}</div>
            <div>{props.user.lastName}</div>
            <div>{props.user.phoneNumber}</div>
            <div>{props.user.role}</div>
            <div onClick={onClick}>{props.user.confirmed.toString()}</div>
        </div>
    )
}

export default User;