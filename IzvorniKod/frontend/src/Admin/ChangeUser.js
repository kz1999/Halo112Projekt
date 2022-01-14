import React from "react";
import '../styles/App.css';
import '../styles/ChangeUser.css'

function ChangeUser(props){
    
    const [form, setForm] = React.useState([]);
    
    React.useEffect(()=>{
        fetch('/korisnici/'+props.user)
        .then(data => data.json())
        .then(data => setForm(data))
    }, []);

    function onChange(event){
        const {name, value} = event.target;
        setForm(oldForm => ({...oldForm, [name]: value}))
    }

    function onSubmit(e){
        e.preventDefault();

        const data = form;
        
        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        };
        return fetch('/korisnici/' + form.userName, options);
    }

    function proba (){
        for (let i=0;i<3;i++){
            <img name ="photo" src={form.photo}  ></img>

        }
    }

    return(
        
        <div className="UserForm">
            <h2>Change user: {form.userName}</h2>
            <form onSubmit={onSubmit}>
                <div className="FormRow">
                    <label className="form-label">Password:</label>
                    <input className="form-field" name='password' onChange={onChange} value={form.passwordHash}/>
                </div>
                <div className="FormRow">
                    <label className="form-label">E-mail adress</label>
                    <input className="form-field" name='email' onChange={onChange} value={form.email}/>
                </div>
                <div className="FormRow">
                    <label className="form-label">Name</label>
                    <input className="form-field" name='name' onChange={onChange} value={form.name}/>
                </div>
                <div className="FormRow">
                    <label className="form-label">Last name</label>
                    <input className="form-field" name='surname' onChange={onChange} value={form.surname}/>
                </div>
                <div className="FormRow">
                    <label className="form-label">Telephone number</label>
                    <input className="form-field" name='phoneNumber' onChange={onChange} value={form.phoneNumber}/>
                </div>
                <div className="FormRow">
                    <label className="form-label">Role</label>
                    <select name ="role" onChange={onChange} value={form.role}>
                        <option value="dispatcher">Dispatcher</option>
                        <option value="fireman">Fireman</option>
                        <option value="policeman">Policeman</option>
                        <option value="doctor">Doctor</option>
                        <option value="admin">Admin</option>
                    </select>
                </div>
                <div className ="FormRow">
                <img name ="photo" src={form.photo} width="180" ></img>
                </div>
                <button className="submit-button" type="submit">ChangeUser</button>
            </form>
        </div>
    )
    
}

export default ChangeUser;