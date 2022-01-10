import React from "react";
import '../styles/App.css';
import OPTGroupStanica from "./OPTGroupStanica";
import Member from "./Member"
import RemoveResponder from "./RemoveResponder";

function Akcija(props){
    const [action, setAction] = React.useState([]);
    const [form, setForm] = React.useState( {how:"", urgencyLVL: ''});
    const [actionTeam, setActionTeam] = React.useState( []);

    React.useEffect(()=>{
        fetch('/akcije/'+props.actionId)
        .then(data => data.json())
        .then(data => {
            setAction(data);
            setActionTeam(data.team)
        });
    }, []);

    function onChange(event){
        const {name, value} = event.target;
        setForm(oldForm => ({...oldForm, [name]: value}))
    }
    

    function sendRequest(event){
        event.preventDefault();
        const data = {
            action_id: action.id,
            emergencyLevel: parseInt(form.urgencyLVL),
            responderAbility: form.how
        };
        console.log(form.member_id)
        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        };
        console.log(data);
        fetch('/dispatcher/createRequest', options).then(data => data.json()).then(data => console.log(data));
        
        //postalji zahtjev tom memberu da je na toj akciji
        //fetch('/stanice/members/'+form.station_id, options);
    }

    function deleteAction(event){
        event.preventDefault();
        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({})
        };
        fetch('/akcije/close/'+action.id, options).then(response=>response.json()).then(response=>console.log(response))
        
    }

    

    function isValidSendRequest(){
        const {how, urgencyLVL} = form;
        return how !== '' && urgencyLVL !=='';
    }

    return(
        <div className="Action">
            Naziv akcije: {action.description }
            <form onSubmit={sendRequest}>
                <div className="FormRow">
                    <label>Prijevozno sredstvo</label>
                    <select name='how' onChange={onChange} value={form.member_id}>
                        <option value="">Odaberi</option> 
                        {["CISTERN", "COMMAND", "FOREST", "LADDER", "AMBULANCE", "MOTORCYCLE", "CONTACT", "ARMORED", "CAR"].map(option => <option key={option} value={option}>{option}</option>)}
                    </select>
                </div>
                <div className="FormRow">
                    <label>Razina hitnosti</label>
                    <select name='urgencyLVL' onChange={onChange} value={form.urgencyLVL}>
                        <option value=''>Odaberi</option>
                        {[1,2,3,4,5,6,7,8,9,10].map(lvl => <option key={lvl} value={lvl}>{lvl}</option>)}
                    </select>
                </div>
                <button type="submit" disabled = {!isValidSendRequest()}>Send Request</button>
            </form>
            <RemoveResponder action_id={action.id} actionTeam={actionTeam}/>
            <button onClick={deleteAction}>set as done</button>
        </div>
    )
}


export default Akcija;