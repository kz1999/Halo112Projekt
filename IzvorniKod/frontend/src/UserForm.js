import React from "react";

function UserForm(){
    const [form, setForm] = React.useState( {username:'', password:''});

    function onChange(event){
        const {name, value} = event.target;
        setForm(oldForm => ({oldForm, [name]: value}))
    }

    function onSubmit(e){
        e.preventDefault();
        const data = {
            
            username: form.username,
            password: form.password
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
        const {username, password} = form;
        return username.length === 1 && password.length > 8;
    }

    return(
        <div className="UserForm">
            <h2>New User</h2>
            <form onSubmit={onSubmit}>
                <div className="FormRow">
                    <label>Username</label>
                    <input name='username' onChange={onChange} value={form.username}/>
                </div>
                <div className="FormRow">
                    <label>Password</label>
                    <input name='password' onChange={onChange} value={form.password}/>
                </div>
                <button type="submit" disabled = {!isValid}>Login</button>
            </form>
        </div>
    )
}

export default UserForm;