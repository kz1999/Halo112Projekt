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


    return(
        
        <div className="UserForm">
            <h2>Promijeni korisnika: {form.userName}</h2>
            <form onSubmit={onSubmit}>
                <div className="FormRow">
                    <label className="form-label">E-mail adresa</label>
                    <input className="form-field" name='email' onChange={onChange} value={form.email}/>
                </div>
                <div className="FormRow">
                    <label className="form-label">Ime</label>
                    <input className="form-field" name='name' onChange={onChange} value={form.name}/>
                </div>
                <div className="FormRow">
                    <label className="form-label">Prezime</label>
                    <input className="form-field" name='surname' onChange={onChange} value={form.surname}/>
                </div>
                <div className="FormRow">
                    <label className="form-label">Telefonski broj</label>
                    <input className="form-field" name='phoneNumber' onChange={onChange} value={form.phoneNumber}/>
                </div>
                <div className="FormRow">
                    <label className="form-label">Uloga</label>
                    <select name ="role" onChange={onChange} value={form.role}>
                        <option value="dispatcher">Dispečer</option>
                        <option value="fireman">Vatrogasac</option>
                        <option value="policeman">Policajac</option>
                        <option value="doctor">Doktor</option>
                        <option value="admin">Admin</option>
                    </select>
                </div>
                <div className ="FormRow">
                <img name ="photo" src={form.photo} width="180" ></img>
                </div>
                <button className="submit-button" type="submit">Promijeni korisnika</button>
            </form>
        </div>
    )
    
}

export default ChangeUser;