import React from "react";
import '../styles/App.css';

function Login(props){
    const [loginForm, setLoginForm] = React.useState( {username:'', password:'' });
    const [error, setError] = React.useState('');
    
    function onChange(event){
        const {name, value} = event.target;
        setLoginForm(oldForm => ({...oldForm, [name]: value}))
    }

    function onSubmit(event){
        event.preventDefault();
        setError('');
        const body =  `username=${loginForm.username}&password=${loginForm.password}`;

        const options = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: body,
            mode: "no-cors"
        };
        fetch('/login',options).then(()=>{
            fetch('/user', {mode:"no-cors"}).then(response=>response.json()).then(response=>{
            if(response === null){
                setError("Login failed");
            }else if(response.confirmed !== true){
                setError("Login failed");
            }else{
                props.checkUserStatus();
            }
        })});
    }

    return(
        <div className="Login">
            <h2>Login</h2>
            <form onSubmit={onSubmit}>
                <div className="FormRow">
                    <label>Username</label>
                    <input name='username' onChange={onChange} value={loginForm.username} />
                </div>
                <div className="FormRow">
                    <label>Password</label>
                    <input name='password' type='password' onChange={onChange} value={loginForm.password}/>
                </div>
                <button type="submit">Login</button>
                <div className="error">{error}</div>
            </form>
        </div>
    )
}

export default Login;