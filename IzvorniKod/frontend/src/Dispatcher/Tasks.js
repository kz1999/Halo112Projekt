import React from "react";
import '../styles/App.css';
import '../styles/Switch.css';
import SpasiociPoStanicama from "./SpasiociPoStanicama";

function Tasks(props){
    //za stvaranje zadataka i prikazivanje pozicija na mapi, voronijev dijagram
    return(
        <div className="">
            <h2>Dodaj zadatke</h2>
            <SpasiociPoStanicama/>
        </div>
    )
}


export default Tasks;