import React from "react";
import CurrentAction from "./CurrentAction";
import Status from "./Status";
import Request from "./Request";

function ResponderActionMenager(){
    const [actions, setActions] = React.useState([]);
    const [responder, setResponder] = React.useState([]);

    React.useEffect(()=>{
        fetch('/akcije')
        .then(data => data.json())
        .then(data => setActions(data));
    }, []);

    React.useEffect(()=>{
        fetch('/spasioci/current')
        .then(data => data.json())
        .then(data => setResponder(data));
    }, []);

    if(responder.currentAction_id === null){

        return(
            <div className="ActionMenager">
                <Status/>
                <h2>Pozivi na akciju:</h2>
                {
                    responder.requestsList.map(request_id=> 
                    <Request key={request_id}request_id={request_id}></Request>)
                }
            </div>
        )
    }
    return(
        <div className="ActionMenager">
            <Status/>
            <CurrentAction currentAction_id={responder.currentAction_id}/>
        </div>
    )


}

export default ResponderActionMenager;
