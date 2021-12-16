import React from 'react';
import {Link} from "react-router-dom";
import "./styles/Header.css";

function HeaderLoggedIn(props){

    function logout(){
        const options = {
            mode: "no-cors"
        };

        fetch('/logout', options).then(() => {
            props.onLogout();
        });
    }
    if(props.role === "admin"){
        return(
            <header className="Header">
                <header className="App-header-container">
                    <div className="App-header">
                        <Link to='/test'>Test</Link>
                        <Link to='/users'>Users list</Link>
                        <button onClick={logout}> user: {props.currentUser}, role: {props.role}<div/>Logout!</button>
                    </div>
                </header>
            </header>
        )
    }
    else{
        return(
            <header className="Header">
                <header className="App-header-container">
                    <div className="App-header">
                        <Link to='/test'>Test</Link>    
                        <button onClick={logout}> user: {props.currentUser}, role: {props.role}<div/>Logout!</button>
                    </div>
                </header>
            </header>
        )
    }
}

function HeaderLoggedOut(){

    return(
        <header className="Header">
            <header className="App-header-container">
                <div className="App-header">
                    <Link to='/login'>Login</Link>
                    <Link to='/register'>Register</Link>
                </div>
            </header>
        </header>
    )
}
export {HeaderLoggedIn, HeaderLoggedOut};

