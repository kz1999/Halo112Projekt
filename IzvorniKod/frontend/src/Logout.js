import React from "react";
import './styles/App.css';

function Logout(props){

    function onClick(event){
        event.preventDefault();
        const body =  `username=admin&password=pass`;

        const options = {
            method: 'POST',
            /*headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: body*/
        };

        fetch('/login',options).then(response => console.log(response));
        
        
        /*
        const options = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: body
        };
        fetch('/login',options)
            .then(response => {
                if(response.status===401){
                    setError("Login failed")
                };
            });
            */
    }

    return(
        <div className="Logout">
            <h2>Logout</h2>
            
                
            <button onClick={onClick}>Logout</button>
            
        </div>
    )
}

export default Logout;