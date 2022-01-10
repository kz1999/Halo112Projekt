import React from "react";
import Location from "../Location";

function Task(props){

    const [task, setTask] = React.useState([]);

    React.useEffect(()=>{
        fetch('/task/'+props.taskId)
        .then(data => data.json())
        .then(data => setTask(data))
    }, []);

    function Prikazi(){
        if(task.location_id!==undefined){
            return(
                task.location_id.map(location_id=><Location key={location_id} location_id={location_id}/>)
            )
        }return(
            <div></div>
        )
    }

    return(
        <div className="Location">
            <Prikazi/>
            Text: {task.text}
        </div>
    )
}


export default Task;