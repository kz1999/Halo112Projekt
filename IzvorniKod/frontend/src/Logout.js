import React from "react";
import './styles/App.css';

function Logout(props){

    function onClick(event){
        event.preventDefault();
        const body =  `username=admin&password=pass`;

        const options = {
            method: 'GET',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: body,
            mode: 'no-cors'
        };

        fetch('/user').then(response => console.log(response));
    }

    return(
        <div className="Test">
            <h2>Logout</h2>
            
                
            <button onClick={onClick}>Logout</button>
            
        </div>
    )
}

export default Logout;