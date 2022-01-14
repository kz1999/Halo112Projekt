import React from "react";
import '../styles/Login.css';

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
        <div className="UserFormLogin">
            <div class="form-title"><b>Prijavi se</b></div>
            <form onSubmit={onSubmit}>
                <div className="FormRow">
                    <label class="form-label">Korisničko ime:</label>
                    <input class="form-field" name='username' onChange={onChange} value={loginForm.username} />
                </div>
                <div className="FormRow">
                    <label class="form-label">Lozinka:</label>
                    <input class="form-field" name='password' type='password' onChange={onChange} value={loginForm.password}/>
                </div>
                <button class="login-button" type="submit">Prijavi se</button>
                <div className="error">{error}</div>
            </form>
        </div>
    )
}

export default Login;