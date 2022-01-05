import React from "react";
import './styles/App.css';

function Station(){
    const [form, setForm] = React.useState( {name:'', director_id:'', location_id:'', stationType:''});
    const [users, setUsers] = React.useState([]);
    const [locations, setLocations] = React.useState([]);

    React.useEffect(()=>{
        fetch('/korisnici')
        .then(data => data.json())
        .then(users => setUsers(users));
    }, []);

    React.useEffect(()=>{
        fetch('/lokacija')
        .then(data => data.json())
        .then(locations => setLocations(locations));
    }, []);

    function onChange(event){
        const {name, value} = event.target;
        setForm(oldForm => ({...oldForm, [name]: value}))
    }

    function onSubmit(event){
        event.preventDefault();
        
        const data = {
            name: form.name,
            director_id: form.director_id,
            location_id: form.location_id,
            stationType: form.stationType
        };
        
        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        };

        fetch('/stanice', options).then(data => data.json()).then(data => console.log(data));
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
                    <label>director</label>
                    <select name='director_id' onChange={onChange} value={form.director_id}>
                        <option value="">Odaberi</option>
                        {
                            users.filter(user => user.role === form.stationType).map(user => <option key={user.id} value={user.id}>{user.userName}</option>)
                        }
                    </select>
                </div>
                <div className="FormRow">
                    <label>location</label>
                    <select name='location_id' onChange={onChange} value={form.location_id}>
                        <option value="">Odaberi</option>
                        {
                            locations.map(lokacija => <option key={lokacija.id} value={lokacija.id}>{lokacija.name}</option>)
                        }
                    </select>
                </div>
                <div className="FormRow">
                    <label>Role</label>
                    <select name ="stationType" onChange={onChange} value={form.stationType}>
                        <option value="">Odaberi</option>
                        <option value="fireman">Fire Department</option>
                        <option value="policeman">Police Department</option>
                        <option value="doctor">Ambulance</option>
                    </select>
                </div>
                <button type="submit">Add</button>
            </form>
        </div>
    )
}

export default Station;