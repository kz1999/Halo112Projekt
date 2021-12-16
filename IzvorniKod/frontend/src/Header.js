import React from 'react';
import {Link} from "react-router-dom";
import "./styles/Header.css";

function Header(props){

    function logout(){
        const options = {
            mode: "no-cors"
        };

        fetch('/logout', options).then(() => {
            props.onLogout();
        });
    }

    return(
        <header className="Header">
            <header className="App-header-container">
                <div className="App-header">
                    <Link to='/test'>Test</Link>
                    <Link to='/users'>Users list</Link>
                    <Link to='/login'>Login</Link>
                    <Link to='/register'>Register</Link>
                    <button onClick={logout}>Logout</button>
                </div>
            </header>
        </header>
    )
}

export default Header;