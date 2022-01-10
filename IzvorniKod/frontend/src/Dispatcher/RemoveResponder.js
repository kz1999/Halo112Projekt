import React from "react";
import '../styles/App.css';
import Member from "./Member";

function RemoveResponder(props){
    const [formRemoveMember, setFormRemoveMember] = React.useState( {member_id:""});

    function onChange(event){
        const {name, value} = event.target;
        setFormRemoveMember(oldForm => ({...oldForm, [name]: value}))
    }

    function removeResponderFromAction(event){
        event.preventDefault();
        const data = {
            action_id: props.action_id,
            member_id: formRemoveMember.member_id
        };
        console.log(formRemoveMember.member_id)
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
        <div>
            <form onSubmit={removeResponderFromAction}>
                <div className="FormRow">
                    <label>Remove responder from action</label>
                    <select name='member_id' onChange={onChange}>
                        <option value="">Odaberi</option>
                        {props.actionTeam.map(member_id => <Member key={member_id} memberId={member_id}></Member>)}
                    </select>
                </div>
                <button type="submit" disabled = {!isValidRemoveResponder()}>Remove Responder</button>
            </form>
        </div>
    )
}


export default RemoveResponder;