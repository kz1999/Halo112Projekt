import React from "react";
import './styles/App.css';

function Logout(props){

    function onClickLogin(event){
        event.preventDefault();
        const body =  `username=admin&password=pass`;

        const options = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: body,
            //mode: 'no-cors'
        };
        
        fetch('/login', options).then(data => console.log(data));
    }

    function onClickLogout(event){
        event.preventDefault();
        const options = {
            //mode: 'no-cors'
        };
        fetch('/logout', options).then(data => console.log(data));
    }

    function onClickUser(event){
        event.preventDefault();
        fetch('/user').then(data => data.json()).then(data => console.log(data));
    }

    return(
        <div className="Test">
            <h2>Logout</h2>    
            <div><button onClick={onClickLogin}>Login</button></div>
             
            <div><button onClick={onClickLogout}>Logout</button></div>
             
            <div><button onClick={onClickUser}>User</button></div>
        </div>
    )
}

export default Logout;