import React from "react";
import './styles/App.css';

function Test(props){

    function onClick(event){
        event.preventDefault();
        const body =  `username=admin&password=pass`;

        const options = {
            method: 'GET',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            //body: body,
            mode: "no-cors"
        };

        fetch('/user', options).then(response => response.json()).then(response => console.log(response));
    }

    return(
        <div className="Test">
            <h2>Test</h2>
            <div>
            <button onClick={onClick}>Logout</button>
            </div>
            
        </div>
    )
}

export default Test;