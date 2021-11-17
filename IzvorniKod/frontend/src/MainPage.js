import React from "react";
import {getCookie} from './Cookies';

function MainPage(){
    
    
    

    return(
        <div className="MainPage">
            <header className="App-header">
                {getCookie("username")}
            </header>
            MainPage
        </div>
    )
}

export default MainPage;