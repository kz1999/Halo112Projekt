import React from "react";
import '../styles/App.css';
import OPTGroupStanica from "./OPTGroupStanica";
import Member from "./Member"

function Akcija(props){
    const [action, setAction] = React.useState([]);
    const [form, setForm] = React.useState( {how:"", urgencyLVL: '', member_id:""});

    const [actionTeam, setActionTeam] = React.useState([]);

    React.useEffect(()=>{
        fetch('/akcije/'+props.actionId)
        .then(data => data.json())
        .then(data => {
            setAction(data);
            setActionTeam(data.team);
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

    function removeResponderFromAction(event){
        event.preventDefault();
        
        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({})
        };
        fetch('akcije/team/'+props.actionId+'/remove/'+form.member_id, options)
    }

    function isValidSendRequest(){
        const {how, urgencyLVL} = form;
        return ;
    }

    return(
        <div className="Action">
            Naziv akcije: {action.name}
            <form onSubmit={sendRequest}>
                <div className="FormRow">
                    <label>Prijevozno sredstvo</label>
                    <select name='how' onChange={onChange}>
                        <option value="">Odaberi</option> 
                        {["CISTERN", "COMMAND", "FOREST", "LADDER", "AMBULANCE", "MOTORCYCLE", "CONTACT", "ARMORED", "CAR"].map(option => <option key={option} value={option}>{option}</option>)}
                    </select>
                </div>
                <div className="FormRow">
                    <label>Razina hitnosti</label>
                    <select name='urgencyLVL' onChange={onChange}>
                        <option value=''>Odaberi</option>
                        {[1,2,3,4,5,6,7,8,9,10].map(lvl => <option key={lvl} value={lvl}>{lvl}</option>)}
                    </select>
                </div>
                <button type="submit" disabled = {!(form.how !== '' && form.urgencyLVL !=='')}>Pošalji zahtjev</button>
            </form>
            <form onSubmit={removeResponderFromAction}>
                <div className="FormRow">
                    <label>Ukloni spasioca sa akcije</label>
                    <select name='member_id' onChange={onChange}>
                        <option value="">Odaberi</option>
                        {actionTeam.map(responder=> <option value = {responder.id}>{responder.userName}</option>)}
                    </select>
                </div>
                <button type="submit" disabled = {form.member_id === ""}>Ukloni spasioca sa akcije</button>
            </form>
            <button onClick={deleteAction}>Označi akciju kao gotovu</button>
        </div>
    )
}


export default Akcija;