import React from "react";
import '../styles/App.css';
import OPTGroupStanica from "./OPTGroupStanica";
import Member from "./Member"

function Akcija(props){
    const [action, setAction] = React.useState([]);
    const [form, setForm] = React.useState( {how:"", urgencyLVL: ""});
    const [formRemoveMember, setFormRemoveMember] = React.useState( {member_id:""});
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
    function isValidSendRequest(){
        const {member_id} = form;
        return true;
    }

    function sendRequest(event){
        event.preventDefault();
        const data = {
            action_id: action.id,
            emergencyLevel: form.urgencyLVL,
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
        console.log(data)
        //fetch('/akcije/team/'+action.id, options).then(data => console.log(data));
        
        //postalji zahtjev tom memberu da je na toj akciji
        //fetch('/stanice/members/'+form.station_id, options);
    }

    function deleteAction(event){
        event.preventDefault();
        const data = {
            action_id: action.id,
        };
        console.log(form.member_id)
        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        };
        console.log(data)

    }

    function removeResponderFromAction(event){
        event.preventDefault();
        const data = {
            action_id: action.id,
            member_id: formRemoveMember.member_id
        };
        console.log(form.member_id)
        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        };
        console.log(data)
    }

    function isValidRemoveResponder(){
        const {member_id} = formRemoveMember;
        return member_id !== '';
    }

    return(
        <div className="Action">
            {action.description }
            <form onSubmit={sendRequest}>
                <div className="FormRow">
                    <label>how</label>
                    <select name='how' onChange={onChange} value={form.member_id}>
                        <option value="">Odaberi</option>
                        {["truck"].map(option => <option key={option} value={option}>{option}</option>)}
                    </select>
                </div>
                <div className="FormRow">
                    <label>urgency</label>
                    <select name='urgencyLVL' onChange={onChange} value={form.urgencyLVL}>
                        <option value="">Odaberi</option>
                        {[1,2,3,4,5,6,7,8,9,10].map(lvl => <option key={lvl} value={lvl}>{lvl}</option>)}
                    </select>
                </div>
                <button type="submit" disabled = {!isValidSendRequest()}>Send Request</button>
            </form>
            
            <form onSubmit={removeResponderFromAction}>
                <div className="FormRow">
                    <label>removeResponderFromAction</label>
                    <select name='member_id' onChange={onChange} value={form.member_id}>
                        <option value="">Odaberi</option>
                        {actionTeam.map(member_id => <Member key={member_id} memberId={member_id}></Member>)}
                    </select>
                </div>
                <button type="submit" disabled = {!isValidRemoveResponder()}>Send Request</button>
            </form>
            <button onClick={deleteAction}>set as done</button>
        </div>
    )
}


export default Akcija;