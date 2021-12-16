import React from "react";
import './styles/App.css';

function Test(props){

    function onClickUser(event){
        event.preventDefault();

        const options = {
            method: 'GET',
            mode: "no-cors"
        };

        fetch('/user', options).then(response => response.json()).then(response => console.log(response));
    }

    function onClickLogout(event){
        event.preventDefault();

        const options = {
            mode: "no-cors"
        };

        fetch('/logout', options).then(response => console.log(response));
    }

    return(
        <div className="Test">
            <h2>Test</h2>
            <div><button onClick={onClickUser}>User</button></div>
            <div><button onClick={onClickLogout}>Logout</button></div>
        </div>
    )
}

export default Test;