import React from "react";
import './styles/App.css';
import './styles/Switch.css';

function ResponderIsReady(){

    function myFunction() {
        if (document.getElementById('check').checked){
            console.log("da");
        }
        else{
        console.log("ne");
        }
    }

    return(
        <div className="Status">
            <h2>Status</h2>
            <label class="switch">
                <input type="checkbox" id="check" onClick={myFunction}/>
                <span class="slider round"></span>
            </label>
        </div>
    )
}


export default ResponderIsReady;