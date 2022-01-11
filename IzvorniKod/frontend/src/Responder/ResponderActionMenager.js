import React from "react";
import CurrentAction from "./CurrentAction";
import Status from "./Status";
import Request from "./Request";

function ResponderActionMenager(){
    const [currentAction_id, setCurrentAction_id] = React.useState(null);
    const [requestsList, setRequestsList] = React.useState([]);

    React.useEffect(()=>{
        fetch('/spasioci/current')
        .then(response => response.json())
        .then(data => {
            if(data !== undefined){
                setRequestsList(data.requestsList)
                setCurrentAction_id(data.currentAction_id)
            }
        });
    });

    if(currentAction_id !== null){
        return(
            <div className="ActionMenager">
                <Status/>
                <CurrentAction currentAction_id={currentAction_id}/>
            </div>
        )
    }
    return(
        <div className="ActionMenager">
            <Status/>
            <h2>Pozivi na akciju:</h2>
            {
                requestsList.map(request_id=> 
                <Request key={request_id}request_id={request_id}></Request>)
            }
        </div>
    )
}

export default ResponderActionMenager;
