import React from "react";
import './styles/App.css';

function ChangeUser(props){

    const [form, setForm] = React.useState( {username:props.user.userName, password:props.user.passwordHash, 
        name:props.user.name, lastName:props.user.surname, phoneNumber:props.user.phoneNumber, email:props.user.email, role:props.user.role});


    function onChange(event){
        const {name, value} = event.target;
        setForm(oldForm => ({...oldForm, [name]: value}))
    }

    function onSubmit(e){
        e.preventDefault();
        

        const data = {
            passwordHash: form.password,
            name: form.name,
            surname: form.lastName,
            phoneNumber: form.phoneNumber,
            email: form.email,
            role: form.role
        };
        
        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        };
        
        return fetch('/korisnici/' + form.username, options);
        
    }

    function isValid(){
        const {username, password} = form;
        return username.length === 1 && password.length > 8;
    }

    return(
        <div className="UserForm">
            <h2>Change user: {form.username}</h2>
            <form onSubmit={onSubmit}>
                <div className="FormRow">
                    <label>Password</label>
                    <input name='password' onChange={onChange} value={form.password}/>
                </div>
                <div className="FormRow">
                    <label>E-mail adress</label>
                    <input name='email' onChange={onChange} value={form.email}/>
                </div>
                <div className="FormRow">
                    <label>Name</label>
                    <input name='name' onChange={onChange} value={form.name}/>
                </div>
                <div className="FormRow">
                    <label>Last name</label>
                    <input name='lastName' onChange={onChange} value={form.lastName}/>
                </div>
                <div className="FormRow">
                    <label>Telephone number</label>
                    <input name='phoneNumber' onChange={onChange} value={form.phoneNumber}/>
                </div>
                <div className="FormRow">
                    <label>Role</label>
                    <input name='role' onChange={onChange} value={form.role}/>
                </div>
                
                <button type="submit" disabled = {!isValid}>ChangeUser</button>
            </form>
        </div>
    )
}

export default ChangeUser;