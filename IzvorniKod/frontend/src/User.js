import React from "react";
import './styles/User.css';

function User(props){
    
    
    //username, Password, E-mail adress, Name, Last name, Telephone number, Role
    return(
        <div className="flex-container">
            <div>
                {props.user.userName}
            </div>
            <div>
                {props.user.password}
            </div>
            <div>                    
                {props.user.email}
            </div>
            <div>
                {props.user.name}
            </div>
            <div>
                {props.user.lastName}
            </div>
            <div>
                {props.user.phoneNumber}
            </div>
            <div>                    
                {props.user.role}
            </div>
            <div>
                {props.user.confirmed.toString()}
            </div>
        </div>
    )
}

export default User;