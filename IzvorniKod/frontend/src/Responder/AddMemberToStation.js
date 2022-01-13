import React from "react";
import '../styles/App.css';

function AddMemberToStation(){
    const [form, setForm] = React.useState( {member_id:'',station_id:''});
    const [responders, setResponders] = React.useState([]);
    const [responder, setResponder] = React.useState([]);
    const [station, setStation] = React.useState([]);

    React.useEffect(()=>{
        fetch('/spasioci')
        .then(data => data.json())
        .then(data => setResponders(data));
    }, []);

    React.useEffect(()=>{
        fetch('/spasioci/current')
        .then(data => data.json())
        .then(data => {
            fetch('/stanice/'+data.station_id)
                .then(data2 => data2.json())
                .then(data2 => setStation(data2))
            setResponder(data)
        
        })
    }, []);

    function onChange(event){
        const {name, value} = event.target;
        setForm(oldForm => ({...oldForm, [name]: value}))
    }

    function onSubmit(event){
        event.preventDefault();
        const data={
            id:form.member_id
        }

        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        };

        fetch('/stanice/members/'+responder.station_id, options);
    }

    function isValid(){
        const {member_id} = form;
        return member_id !== '';
    }
    
    return(
        <div className="Test">
            <h2>Add Member to station</h2>
            <form className="UserFormStation" onSubmit={onSubmit}>
                {station.name}
                <div className="FormRow">
                    <label className="form-label">Member: </label>
                    <select name='member_id' onChange={onChange} value={form.member_id}>
                        <option value=''>Odaberi</option>
                        {
                            responders.filter(responder => responder.station_id === null).map(user => <option key={user.id} value={user.id}>{user.userName}</option>)
                        }
                    </select>
                </div>
                <button className="add-button" type="submit" disabled = {!isValid()}>Add</button>
            </form>
        </div>
    )
    
}

export default AddMemberToStation;
