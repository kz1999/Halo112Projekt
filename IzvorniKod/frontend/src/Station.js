import React from "react";
import './styles/App.css';

function Station(){
    const [form, setForm] = React.useState( {member_id:null,station_id:null});
    const [users, setUsers] = React.useState([]);
    const [stations, setStations] = React.useState([]);

    React.useEffect(()=>{
        fetch('/korisnici')
        .then(data => data.json())
        .then(users => setUsers(users));
    }, []);

    React.useEffect(()=>{
        fetch('/stanice')
        .then(data => data.json())
        .then(stations => setStations(stations));
    }, []);

    function onChange(event){
        const {name, value} = event.target;
        setForm(oldForm => ({...oldForm, [name]: value}))
    }

    function onSubmit(event){
        event.preventDefault();
        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: form.member_id
        };

        fetch('/stanice/'+form.station_id+'/members', options);
    }

    function isValid(){
        const {member_id,station_id} = form;
        return member_id != null && station_id != null;
    }

    return(
        <div className="Test">
            <h2>Add Member to station</h2>
            <form onSubmit={onSubmit}>
                <div className="FormRow">
                    <label>station</label>
                    <select name='station_id' onChange={onChange} value={form.station_id}>
                        <option value={null}>Odaberi</option>
                        {
                            stations.map(station => <option key={station.id} value={station.id}>{station.name}</option>)
                        }
                    </select>
                </div>
                <div className="FormRow">
                    <label>member</label>
                    <select name='member_id' onChange={onChange} value={form.member_id}>
                        <option value={null}>Odaberi</option>
                        {
                            users.map(user => <option key={user.id} value={user.id}>{user.userName}</option>)
                        }
                    </select>
                </div>
                <button type="submit" disabled = {!isValid()}>Add</button>
            </form>
        </div>
    )
}

export default Station;