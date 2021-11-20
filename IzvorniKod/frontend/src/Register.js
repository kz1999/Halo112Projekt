import React from "react";
import './styles/App.css';

function Register(){
    const [form, setForm] = React.useState( {username:'', password:'', name:'', lastName:'', phoneNumber:'', email:'', role:''});

    function onChange(event){
        const {name, value} = event.target;
        setForm(oldForm => ({...oldForm, [name]: value}))
    }

    function onSubmit(e){
        e.preventDefault();
        

        const data = {
            userName: form.username,
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
        
        return fetch('/korisnici',options);
        
    }

    function isValid(){
        const {username, password} = form;
        return username.length === 1 && password.length > 8;
    }

    return(
        <div className="UserForm">
            <h2>Register</h2>
            <form onSubmit={onSubmit}>
                <div className="FormRow">
                    <label>Username</label>
                    <input name='username' onChange={onChange} value={form.username}/>
                </div>
                <div className="FormRow">
                    <label>Password</label>
                    <input name='password' type='password' onChange={onChange} value={form.password}/>
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
                
                <button type="submit" disabled = {!isValid}>Register</button>
            </form>
        </div>
    )
}

export default Register;