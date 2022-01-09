import React from "react";
import '../styles/App.css';
import '../styles/Switch.css';

function CurrentAction(props){

    return(
        <div className="Status">
            <h2>{props.currentAction_id}</h2>
        </div>
    )
}


export default CurrentAction;