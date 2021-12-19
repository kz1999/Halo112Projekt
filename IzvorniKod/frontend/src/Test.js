import React from "react";
import './styles/App.css';

function Test(){

    function onClickUser(event){
        event.preventDefault();
        fetch('/user').then(data => data.json()).then(data => console.log(data));
    }

    return(
        <div className="Test">
            <h2>Test</h2>    
            <div><button onClick={onClickUser}>Gumb</button></div>
        </div>
    )
}

export default Test;