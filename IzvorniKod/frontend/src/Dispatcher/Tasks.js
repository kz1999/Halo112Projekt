import React from "react";
import '../styles/App.css';
import '../styles/Switch.css';
import SpasiociPoStanicama from "./SpasiociPoStanicama";
import CreateTask from "./CreateTask";
import AllRespondersMap from "./AllRespondersMap"

function Tasks(props){
    //za stvaranje zadataka i prikazivanje pozicija na mapi, voronijev dijagram

    return(
        <div className="">
            <h2>Dodaj zadatke</h2>
            <SpasiociPoStanicama/>
           {//<CreateTask/>
}
            <AllRespondersMap/>
        </div>
    )
}


export default Tasks;