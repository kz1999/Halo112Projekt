import React from "react";
import '../styles/App.css';
import OPTGroupStanica from "./OPTGroupStanica";

function Akcija(props){
    const [action, setAction] = React.useState([]);
    const [form, setForm] = React.useState( {member_id:""});
    const [stations, setStations] = React.useState([]);

    React.useEffect(()=>{
        fetch('/akcije/'+props.actionId)
        .then(data => data.json())
        .then(data => setAction(data));
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
    function isValid(){
        const {member_id} = form;
        return member_id !== "";
    }

    function onSubmit(event){
        event.preventDefault();
        const data = {
            id: form.member_id
        };
        console.log(form.member_id)
        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        };

        fetch('/akcije/team/'+action.id, options).then(data => console.log(data));
        
        //postalji zahtjev tom memberu da je na toj akciji
        //fetch('/stanice/members/'+form.station_id, options);
    }

    function deleteAction(event){
        event.preventDefault();
    }

    return(
        <div className="Action">
            {action.description }
            <form onSubmit={onSubmit}>
                <div className="FormRow">
                    <label>include responder</label>
                    <select name='member_id' onChange={onChange} value={form.member_id}>
                        <option value="">Odaberi</option>
                        {stations.map(station => <OPTGroupStanica key={station.id} stationId={station.id}/>)}
                    </select>
                </div>
                <button type="submit" disabled = {!isValid()}>Add</button>
            </form>
            <button onClick={deleteAction}>delete action</button>
        </div>
    )
}


export default Akcija;