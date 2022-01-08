import React from "react";
import './styles/App.css';
import StationDirectorDiv from "./StationDirectorDiv"

function CreateStation(){
    const [form, setForm] = React.useState( {name:'', director_id:null, location_id:null, stationType:null});
    const [locations, setLocations] = React.useState([]);
    const [stations, setStations] = React.useState([]);
    const [responders, setResponders] = React.useState([]);

    React.useEffect(()=>{
        fetch('/lokacija')
        .then(data => data.json())
        .then(locations => setLocations(locations));
    }, []);

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
            location_id: form.location_id,
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
        const {name, director_id, location_id, stationType} = form;
        return name.length >= 1 && director_id != null && location_id != null && stationType != null;
    }

    return(
        <div className="Test">
            <h2>Add Station</h2>
            <form onSubmit={onSubmit}>
                <div className="FormRow">
                    <label>name</label>
                    <input name='name' onChange={onChange} value={form.name}/>
                </div>
                <div className="FormRow">
                    <label>Role</label>
                    <select name ="stationType" onChange={onChange} value={form.stationType}>
                        <option value={null}>Odaberi</option>
                        <option value="fireman">Fire station</option>
                        <option value="policeman">Police station</option>
                        <option value="doctor">Hospital</option>
                    </select>
                </div>
                <div className="FormRow">
                    <label>director</label>
                    <select name='director_id' onChange={onChange} value={form.director_id}>
                        <option value={null}>Odaberi</option>
                        {
                            responders.filter(user => user.role === form.stationType).map(user => <option key={user.id} value={user.id}>{user.userName}</option>)
                        }
                    </select>
                </div>
                <div className="FormRow">
                    <label>location</label>
                    <select name='location_id' onChange={onChange} value={form.location_id}>
                        <option value={null}>Odaberi</option>
                        {
                            locations.map(lokacija => <option key={lokacija.id} value={lokacija.id}>{lokacija.name}</option>)
                        }
                    </select>
                </div>
                <button type="submit" disabled = {!isValid()}>Add</button>
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