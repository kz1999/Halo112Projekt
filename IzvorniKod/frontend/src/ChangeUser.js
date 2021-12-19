import React from "react";
import './styles/App.css';

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

    return(
        
        <div className="UserForm">
            <h2>Change user: {form.userName}</h2>
            <form onSubmit={onSubmit}>
                <div className="FormRow">
                    <label>Password</label>
                    <input name='password' onChange={onChange} value={form.passwordHash}/>
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
                    <input name='surname' onChange={onChange} value={form.surname}/>
                </div>
                <div className="FormRow">
                    <label>Telephone number</label>
                    <input name='phoneNumber' onChange={onChange} value={form.phoneNumber}/>
                </div>
                <div className="FormRow">
                    <label>Role</label>
                    <input name='role' onChange={onChange} value={form.role}/>
                </div>
                <div className="FormRow">
                    <label>Confirmed</label>
                    <input name='confirmed' onChange={onChange} value={form.confirmed}/>
                </div>
                <button type="submit">ChangeUser</button>
            </form>
        </div>
    )
    
}

export default ChangeUser;