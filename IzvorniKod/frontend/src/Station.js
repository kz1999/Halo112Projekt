import React from "react";
import './styles/App.css';

function Station(){
    const [form, setForm] = React.useState( {name:null, station_id:null});
    const [users, setUsers] = React.useState([]);

    React.useEffect(()=>{
        fetch('/korisnici')
        .then(data => data.json())
        .then(users => setUsers(users));
    }, []);

    function onChange(event){
        const {name, value} = event.target;
        setForm(oldForm => ({...oldForm, [name]: value}))
    }

    function onSubmit(event){
        event.preventDefault();
        
        const data = {
            name: form.name,
        };
        
        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        };
        console.log(data);
        fetch('/stanice/create', options).then(data => data.json()).then(data => console.log(data));
    }

    function isValid(){
        const {name} = form;
        return name != null;
    }

    return(
        <div className="Test">
            <h2>Add Member to station</h2>
            <form onSubmit={onSubmit}>
                <div className="FormRow">
                    <label>location</label>
                    <select name='name' onChange={onChange} value={form.name}>
                        <option value={null}>Odaberi</option>
                        {
                            users.map(user => <option key={user.id} value={user.id}>{user.name}</option>)
                        }
                    </select>
                </div>
                <button type="submit" disabled = {!isValid()}>Add</button>
            </form>
        </div>
    )
}

export default Station;