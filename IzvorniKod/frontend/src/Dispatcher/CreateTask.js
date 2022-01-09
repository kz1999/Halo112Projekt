import React from "react";
import '../styles/App.css';
import '../styles/Switch.css';
import Member from "./Member";

function CreateTask(props){
    //za stvaranje zadataka i prikazivanje pozicija na mapi, voronijev dijagram
    const [form, setForm] = React.useState({description:"", responder_id: "", locations:[]});
    const [responders, setResponders] = React.useState([]);

    React.useEffect(()=>{
        fetch('/spasioci')
        .then(data => data.json())
        .then(data => setResponders(data));
    }, []);

    function createTask(event){
        event.preventDefault();
        const data = {
            text: form.description,
            responder_id: parseInt(form.responder_id),
            location_id: [2,2]};

        const options={
            method: 'POST',
            headers:{'Content-Type': 'application/json'},
            body: JSON.stringify(data)};

        fetch('/task', options)
            .then(task=>task.json())
            .then(task=>{
            fetch('/spasioci/'+task.responder_id)
                .then(responder=>responder.json())
                .then(responder=>{
                fetch('/akcije/tasks/'+responder.currentAction_id, {
                    method: 'POST',
                    headers:{'Content-Type': 'application/json'},
                    body: JSON.stringify({id: task.id}) 
                })
            })
        })
    }

    function onChange(event){
        const {name, value} = event.target;
        setForm(oldForm => ({...oldForm, [name]: value}))
    }

    function isValid(){
        const {description, responder_id} = form;
        return description.length > 0 && responder_id !== '';
    }
    
    return(
        <div className="">
            <form onSubmit={createTask}>
                <div className="FormRow">
                    <label>Deskripcija</label>
                    <input name='description' onChange={onChange} value={form.description}/>
                </div>
                <div className="FormRow">
                    <label>Spasilac</label>
                    <select name='responder_id' onChange={onChange}>
                        <option value=''>Odaberi spasioca</option>
                        {responders.map(responder=> <Member key={responder.id}memberId={responder.id}/>)}
                    </select>
                </div>
                <button type="submit" disabled = {!isValid()}>New Task</button>
            </form>
        </div>
    )
}


export default CreateTask;