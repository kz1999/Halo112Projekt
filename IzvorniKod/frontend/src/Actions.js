import React from "react";
import './styles/App.css';

function Actions(){
    const [allActions, setAllActions] = React.useState([]);
    const [form, setForm] = React.useState( {member_id:null});
    const [stations, setStations] = React.useState([]);

    React.useEffect(()=>{
        fetch('/akcije')
        .then(data => data.json())
        .then(allActions => setAllActions(allActions));
    }, []);

    React.useEffect(()=>{
        fetch('/stanice')
        .then(data => data.json())
        .then(stations => setStations(stations));
    }, []);

    function onClick1(event){
        event.preventDefault();
        
        const data = {
            id: 7
        };
        
        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        };

        fetch('/akcije/location/8', options).then(data => console.log(data));
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
        console.log(form.member_id)
        //postalji zahtjev tom memberu da je na toj akciji
        //fetch('/stanice/members/'+form.station_id, options);
    }

    function addAction(event){
        event.preventDefault();
        
        const data = {
            description:"majmunovo"
        };

        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        };

        fetch('/akcije', options).then(response=>response.json()).then(response=>console.log(response))
    }
    
    
    function onChange(event){
        const {name, value} = event.target;
        setForm(oldForm => ({...oldForm, [name]: value}))
    }

    return(

        <div className="Actions">
            <h2>Actions</h2>
            <div><button onClick={addAction}>addAction</button></div>
            { allActions.map(akcija => <div key={akcija.id}>{akcija.description}</div>)}
            <form onSubmit={onSubmit}>
                
                <div className="FormRow">
                    <label>member</label>
                    <select name='member_id' onChange={onChange} value={form.member_id}>
                        <option value={null}>Odaberi</option>
                        
                        {stations.map(station => 
                            <optgroup key={station.id} label={station.name}>
                                {
                                    station.members.map(member_id => <option key = {member_id} value={member_id}>{member_id}</option>)
                                }
                            </optgroup>)
                        }
                    </select>
                </div>
                <button type="submit">Add</button>
            </form>
        </div>
    )
}


export default Actions;