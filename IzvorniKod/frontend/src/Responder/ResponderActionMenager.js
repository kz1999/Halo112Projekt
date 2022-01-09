import React from "react";
import CurrentAction from "./CurrentAction";
import ResponderIsReady from "./ResponderIsReady";


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
                <ResponderIsReady/>
                {
                    actions.filter(action=> action.team.filter(responder => responder.id===responder.id).length > 0)
                    .map(action => <div>{action.urgency}, {action.description}</div>)
                }
            </div>
        )
    }
    return(
        <div className="ActionMenager">
            <CurrentAction currentAction_id={responder.currentAction_id}/>
        </div>
    )


}

export default ResponderActionMenager;
