import React from "react";
import '../styles/App.css';
import '../styles/Switch.css';
import Member from "./Member";

function CreateTask(props){
    //za stvaranje zadataka i prikazivanje pozicija na mapi, voronijev dijagram
    const [form, setForm] = React.useState({description:"", responder_id: "", location: "", locations:[]});
    const [responders, setResponders] = React.useState([]);
    const [locations, setLocations] = React.useState([]);

    React.useEffect(()=>{
        fetch('/lokacija')
        .then(data => data.json())
        .then(data => setLocations(data));
    }, []);

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
            location_id: form.locations};

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

        form.locations=[];
        console.log(form.locations)
    }

    function onChange(event){
        const {name, value} = event.target;
        setForm(oldForm => ({...oldForm, [name]: value}))
    }

    function isValid(){
        const {description, responder_id} = form;
        return description.length > 0 && responder_id !== '';
    }

    function addLocation(event){
        event.preventDefault()
        form.locations.push(parseInt(form.location))
        console.log(form.locations)
    }
    
    return(
        <div className="">
            <form onSubmit={createTask}>
                Zadatak
                <div className="FormRow">
                    <label>Opis</label>
                    <input name='description' onChange={onChange} value={form.description}/>
                </div>
                <div className="FormRow">
                    <label>Spasilac</label>
                    <select name='responder_id' onChange={onChange}>
                        <option value=''>Odaberi spasioca</option>
                        {responders.filter(responder=>responder.currentAction_id!==null).map(responder=> <Member key={responder.id}memberId={responder.id}/>)}
                    </select>
                </div>
                
                <button type="submit" disabled = {!isValid()}>New Task</button>
            </form>
            <form onSubmit={addLocation}>
                <div className="FormRow">
                    <label>Lokacija</label>
                    <select name='location' onChange={onChange}>
                        <option value=''>Odaberi lokaciju</option>
                        {locations.map(location=><option key={location.id} value={location.id}>{location.id}</option>)}
                    </select>
                </div>
                <button type="submit" disabled = {form.location===""}>add Location</button>
            </form>
        </div>
    )
}


export default CreateTask;