import React from "react";
import '../styles/App.css';
import '../styles/Abilities.css';


function Abilities(){
    const [form, setForm] = React.useState( {member_id:'',responderAbility:'',responderRole:''});
    const [responders, setResponders] = React.useState({});

    React.useEffect(()=>{
        fetch('/spasioci/current')
        .then(data => data.json())
        .then(data => {
            form.responderRole = data.role;
            responders[data.id]=data
            fetch('/stanice/'+data.station_id)
                .then(stanica => stanica.json())
                .then(stanica => stanica.members)
                .then(members => members.map(member_id => fetch('/spasioci/'+member_id).then(data=>data.json()).then(data=>responders[data.id]=data)))
        })
    }, []);

    function onChange(event){
        const {name, value} = event.target;
        setForm(oldForm => ({...oldForm, [name]: value}))
    }

    function onSubmit(event){
        event.preventDefault();
        const data={
            
            responderAbility: form.responderAbility
        }

        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        };
        console.log(data)
        fetch('/spasioci/'+form.member_id, options)
    }

    function isValid(){
        const {member_id, responderAbility} = form;
        return member_id !== '' && responderAbility !== '';
    }
    

    const proba = {   
        'fireman': ["CISTERN","COMMAND","FOREST","LADDER"],
        'policeman': ["MOTORCYCLE", "CONTACT", "ARMORED", "CAR"],
        "doctor": ["AMBULANCE", "MOTORCYCLE"],
        "":[] 
    }
    
    
        return(
            <div className="Test">
                <h2>Odaberi posebnu moć</h2>
                <form className="UserFormAbilities" onSubmit={onSubmit}>
                    <div className="FormRow">
                        <label className="form-label">Član: </label>
                        <select name='member_id' onChange={onChange}>
                            <option value=''>Odaberi</option>
                            {
                                Object.values(responders).map(responder => <option key={responder.id} value={responder.id}>{responder.userName}</option>)
                            }
                        </select>
                    </div>
                    <div className="FormRow">
                        <label className="form-label">Posebna moć: </label>
                        <select name='responderAbility' onChange={onChange} value={form.responderAbility}>
                            <option value=''>Odaberi</option>
                            {
                                proba[form.responderRole].map(nesto => <option key={nesto} value={nesto}>{nesto}</option>)
                            }
                        </select>
                    </div>

                    <button className="add-button" type="submit" disabled = {!isValid()}>Add</button>
                </form>
            </div>
        )
    
}

export default Abilities;
