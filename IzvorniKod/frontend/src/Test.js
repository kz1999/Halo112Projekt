import React from "react";
import './styles/App.css';

function Test(props){

    const api  = process.env.REACT_APP_API_URL;
    
    function onClickUser(event){
        event.preventDefault();

        const options = {
            method: 'GET',
            mode: "no-cors"
        };

        fetch(api + '/user', options).then(response => response.json()).then(response => console.log(response));
    }

    return(
        <div className="Test">
            <h2>Test</h2>
            <div><button onClick={onClickUser}>User</button></div>
            
        </div>
    )
}

export default Test;