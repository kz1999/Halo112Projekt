import React from 'react';
import {Link} from "react-router-dom";
import "./styles/Header.css";

function HeaderLoggedIn(props){

    function logout(){
        fetch('/logout').then(() => {
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
                        <button onClick={logout}> user: {props.currentUser}, role: admin<div/>Logout!</button>
                    </div>
                </header>
            </header>
        )
    }
    else if(props.role === "dispatcher"){
        return(
            <header className="Header">
                <header className="App-header-container">
                    <div className="App-header">
                        <Link to='/test'>Test</Link>    
                        <button onClick={logout}> user: {props.currentUser}, role: dispatcher<div/>Logout!</button>
                    </div>
                </header>
            </header>
        )
    }
    else if(props.role === "fireman"){
        return(
            <header className="Header">
                <header className="App-header-container">
                    <div className="App-header">
                        <Link to='/test'>Test</Link>    
                        <button onClick={logout}> user: {props.currentUser}, role: fireman<div/>Logout!</button>
                    </div>
                </header>
            </header>
        )
    }
    else if(props.role === "police"){
        return(
            <header className="Header">
                <header className="App-header-container">
                    <div className="App-header">
                        <Link to='/test'>Test</Link>    
                        <button onClick={logout}> user: {props.currentUser}, role: police<div/>Logout!</button>
                    </div>
                </header>
            </header>
        )
    }
    else if(props.role === "paramedic"){
        return(
            <header className="Header">
                <header className="App-header-container">
                    <div className="App-header">
                        <Link to='/test'>Test</Link>    
                        <button onClick={logout}> user: {props.currentUser}, role: paramedic<div/>Logout!</button>
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
            </header>)
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

