import React from "react";


function User(props){
    const {username, password} = props.user

    return (
        <p>{username} {password} </p>
    );
}

export default User;