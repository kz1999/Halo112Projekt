import React from "react";
import '../styles/CreateStation.css';

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
            <div class="form-title"><b>Stvori stanicu</b></div>
            <form class="UserFormStation" onSubmit={onSubmit}>
                <div className="FormRow">
                    <label>Ime stanice: </label>
                    <input class="form-field" name='name' onChange={onChange} value={form.name}/>
                </div>
                <div className="FormRow">
                    <label class="form-label">Vrsta stanice: </label>
                    <select name ="stationType" onChange={onChange} value={form.stationType}>
                        <option value="">Odaberi</option>
                        <option value="fireman">Vatrogasna postaja</option>
                        <option value="policeman">Policijska postaja</option>
                        <option value="doctor">Bolnica</option>
                    </select>
                </div>
                <div className="FormRow">
                    <label class="form-label">Direktor: </label>
                    <select name='director_id' onChange={onChange} value={form.director_id}>
                        <option value="">Odaberi</option>
                        {
                            responders.filter(user => user.role === form.stationType).map(user => <option key={user.id} value={user.id}>{user.userName}</option>)
                        }
                    </select>
                </div>
                <button class="add-button" type="submit" disabled = {!isValid()}>Stvori</button>
            </form>
            <div>
                {
                    stations.map(station => <div className="station-name" key={station.id}><b>{station.name}, {
                        responders.filter(user => 
                            user.id === station.director_id
                        ).map(user => <a key={user.id}>{user.userName}</a>)
                    }</b></div>)
                }
            </div>
        </div>
    )
}

export default CreateStation;