import React from "react";
import '../styles/App.css';
import '../styles/Register.css';

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
        const {username, role} = form;
        return username.length >= 1 && role !== null ;
    }
    function picture(e){
        const {name} = e.target;
        console.log(e.target.files[0]);
        const reader = new FileReader();

        reader.readAsDataURL(e.target.files[0]);
        reader.addEventListener('load',()=>{
            setForm(oldForm => ({...oldForm, [name]: reader.result}))
        })        
    }

    return(
        <div className="UserFormReg">
            <div class="form-title"><b>Register</b></div>
            <form name="form" onSubmit={onSubmit}>
                <div className="FormRow">
                    <label class="form-label">Username:</label>
                    <input class="form-field" name='username' onChange={onChange} value={form.username}/>
                </div>
                <div className="FormRow">
                    <label class="form-label">Password:</label>
                    <input class="form-field" name='password' type='password' onChange={onChange} value={form.password}/>
                </div>
                <div className="FormRow">
                    <label class="form-label">E-mail adress:</label>
                    <input class="form-field" name='email' onChange={onChange} value={form.email}/>
                </div>
                <div className="FormRow">
                    <label class="form-label">Name:</label>
                    <input class="form-field" name='name' onChange={onChange} value={form.name}/>
                </div>
                <div className="FormRow">
                    <label class="form-label">Last name:</label>
                    <input class="form-field" name='lastName' onChange={onChange} value={form.lastName}/>
                </div>
                <div className="FormRow">
                    <label class="form-label">Telephone number:</label>
                    <input class="form-field" name='phoneNumber' onChange={onChange} value={form.phoneNumber}/>
                </div>
                <div className="Role">
                    <label class="form-label">Role:</label>
                    <select name ="role" onChange={onChange} value={form.role}>
                        <option value={null}></option>
                        <option value="dispatcher">Dispatcher</option>
                        <option value="fireman">Fireman</option>
                        <option value="policeman">Policeman</option>
                        <option value="doctor">Doctor</option>
                        <option value="admin">Admin</option>
                    </select>
                </div>
                <div className="form-picture">
                    <label class="form-label">Picture:</label>
                    <input type ="file" name = "photo" onChange={picture} ></input>
                </div>
                <button class="reg-button" type="submit" disabled = {!isValid()}>Register</button>
            </form>
        </div>
    )
}

export default Register;