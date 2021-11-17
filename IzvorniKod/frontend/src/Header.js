import React from 'react';
import {Link} from "react-router-dom";
import "./styles/Header.css";
import {getCookie} from "./Cookies";

function Header(props){

    function logout(){
        fetch("/logout").then(()=>{
            props.onLogout();
        })
    }

    return(
        <header className="Header">
            <header className="App-header">
                {getCookie("username")}
                <Link to='/users'>Users</Link>
                <button onClick={logout}>Logout</button>
            </header>
        </header>
    )
}

export default Header;