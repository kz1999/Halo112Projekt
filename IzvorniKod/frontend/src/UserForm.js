import React from "react";

function UserForm(){
    const [form, setForm] = React.useState( {jmbag: '', givenName:'', familyName:''});

    function onChange(event){
        const {name, value} = event.target;
        setForm(oldForm => ({oldForm, [name]: value}))
    }

    function onSubmit(e){
        e.preventDefault();
        const data = {
            jmbag: form.jmbag,
            familyName: form.familyName,
            givenName: form.givenName
        };
        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        };
        return fetch('/users',options);
    }

    function isValid(){
        const {jmbag, givenName, familyName} = form;
        return jmbag.length === 10 && givenName.length > 0 && familyName.length > 0;
    }

    return(
        <div className="UserForm">
            <h2>New User</h2>
            <form onSubmit={onSubmit}>
                <div className="FormRow">
                    <label>JMBAG</label>
                    <input name='jmbag' onChange={onChange} value={form.jmbag}/>
                </div>
                <div className="FormRow">
                    <label>Given name</label>
                    <input name='givenName' onChange={onChange} value={form.givenName}/>
                </div>
                <div className="FormRow">
                    <label>Family name</label>
                    <input name='familyName' onChange={onChange} value={form.familyName}/>
                </div>
                <button type="submit" disabled = {!isValid}>Submit</button>
            </form>
        </div>
    )
}

export default UserForm;