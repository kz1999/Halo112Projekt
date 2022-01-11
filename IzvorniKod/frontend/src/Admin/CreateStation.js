import React from "react";
import '../styles/App.css';

function CreateStation(){
    const [form, setForm] = React.useState( {name:'', director_id:"", stationType:""});
    const [stations, setStations] = React.useState([]);
    const [responders, setResponders] = React.useState([]);

    React.useEffect(()=>{
        fetch('/stanice')
        .then(data => data.json())
        .then(stations => setStations(stations));
    }, []);

    React.useEffect(()=>{
        fetch('/spasioci')
        .then(data => data.json())
        .then(data => setResponders(data));
    }, []);

    function onChange(event){
        const {name, value} = event.target;
        setForm(oldForm => ({...oldForm, [name]: value}))
    }

    function onSubmit(event){
        event.preventDefault();
        const stationType = form.stationType;
        const data = {
            name: form.name,
            director_id: form.director_id,
            location_id: 1,
            type: "FIRESTATION"
        };
        if(stationType==="policeman"){
            data.type = "POLICE"
        }
        if(stationType==="doctor"){
            data.type = "HOSPITAL"
        }
        console.log(data);
        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        };
        fetch('/stanice', options);
    }

    function isValid(){
        const {name, director_id, stationType} = form;
        return name.length >= 1 && director_id !== "" && stationType !== "";
    }

    return(
        <div className="Test">
            <h2>Stvori stanicu</h2>
            <form onSubmit={onSubmit}>
                <div className="FormRow">
                    <label>Ime stanice: </label>
                    <input name='name' onChange={onChange} value={form.name}/>
                </div>
                <div className="FormRow">
                    <label>Vrsta stanice: </label>
                    <select name ="stationType" onChange={onChange} value={form.stationType}>
                        <option value="">Odaberi</option>
                        <option value="fireman">Vatrogasna postaja</option>
                        <option value="policeman">Policijska postaja</option>
                        <option value="doctor">Bolnica</option>
                    </select>
                </div>
                <div className="FormRow">
                    <label>Direktor: </label>
                    <select name='director_id' onChange={onChange} value={form.director_id}>
                        <option value="">Odaberi</option>
                        {
                            responders.filter(user => user.role === form.stationType).map(user => <option key={user.id} value={user.id}>{user.userName}</option>)
                        }
                    </select>
                </div>
                <button type="submit" disabled = {!isValid()}>Stvori</button>
            </form>
            <div>
                {
                    stations.map(station => <div key={station.id}>{station.name}, {
                        responders.filter(user => 
                            user.id === station.director_id
                        ).map(user => <a key={user.id}>{user.userName}</a>)
                    }</div>)
                }
            </div>
        </div>
    )
}

export default CreateStation;