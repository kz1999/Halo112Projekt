import React from "react";
import '../styles/App.css';
import '../styles/Switch.css';
import Task from "./Task";

function CurrentAction(props){

    const [tasks, setTasks] = React.useState([]);
    const [responderId, setResponderId] = React.useState([]);

    React.useEffect(()=>{
        fetch('/task')
        .then(data => data.json())
        .then(data => setTasks(data));
    }, []);

    React.useEffect(()=>{
        fetch('/spasioci/current')
        .then(data => data.json())
        .then(data => setResponderId(data.id));
    }, []);

    return(
        <div className="Status">
            <h2>Action id: {props.currentAction_id}</h2>
            {tasks.filter(task=>task.responder_id === responderId).map(task=>

                <Task key={task.id} taskId={task.id}/>
                )}
            
            
        </div>
    )
}


export default CurrentAction;