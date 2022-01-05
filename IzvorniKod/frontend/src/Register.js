import React from "react";
import './styles/App.css';

function Register(){
    const [form, setForm] = React.useState( {username:'', password:'', name:'', lastName:'', phoneNumber:'', email:'', role:null, photo:''});

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
            role: form.role,
            photo: form.photo
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
        const {username, password, role} = form;
        return username.length > 3 && password.length > 7 && role !== null ;
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
                    <select name ="role" onChange={onChange} value={form.role}>
                        <option value={null}></option>
                        <option value="dispatcher">Dispatcher</option>
                        <option value="fireman">Fireman</option>
                        <option value="policeman">Policeman</option>
                        <option value="doctor">Doctor</option>
                        <option value="admin">Admin</option>
                    </select>
                </div>
                <div className="FormRow">
                    <label>Picture </label>
                    <input type ="file" name = "picture" onChange={onChange} value={form.photo}></input>
                </div>
                <button type="submit" disabled = {!isValid()}>Register</button>
            </form>
        </div>
    )
}

export default Register;