import React from "react";
import '../styles/User.css';


function User(props){

    const [user, setUser] = React.useState([]);

    React.useEffect(()=>{
        fetch('/korisnici/'+props.user.userName)
        .then(data => data.json())
        .then(data => setUser(data));
    }, []);

    function changeUser(event){
        event.preventDefault();
        props.setUserToChange(props.user.userName);
    }

    function confirmUser(event){
        event.preventDefault();
        user.confirmed=true;
        const data = user;
        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        };
        fetch('/korisnici/' + user.userName, options);
    }

    return(
        <div className="flex-container">
            <div className="link" onClick={changeUser}>{user.userName}</div>
            <div>{}</div>
            <div>{user.email}</div>
            <div>{user.name}</div>
            <div>{user.surname}</div>
            <div>{user.phoneNumber}</div>
            <div>{user.role}</div>
            <div className="link" onClick={confirmUser}>{JSON.stringify(user.confirmed)}</div>
        </div>
    )
}

export default User;