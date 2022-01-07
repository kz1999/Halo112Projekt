import React from "react";
import './styles/App.css';

function Comments(){
    const [previousComments, setPreviousComments] = React.useState([]);
    const [user, setUser] = React.useState([]);
    const [form, setForm] = React.useState( {text:'' });
    
    React.useEffect(()=>{
        fetch('/komentari')
        .then(data => data.json())
        .then(previousComments => setPreviousComments(previousComments));
    }, []);

    React.useEffect(()=>{
        fetch('/user')
        .then(data => data.json())
        .then(user => setUser(user));
    }, []);

    function onChange(event){
        const {name, value} = event.target;
        setForm(oldForm => ({...oldForm, [name]: value}))
    }

    function onSubmit(event){
        event.preventDefault();
        console.log(user.id)
        //timestamp
        const data = {
            owner: user.id,
            text: form.text
        };
        
        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        };

        fetch('/komentari', options).then(data => console.log(data));
    }

    return(
        <div className="Comments">
            <h2>Comments</h2>
            <form onSubmit={onSubmit}>
                <div className="FormRow">
                    <label>yourComment</label>
                    <input name='text' onChange={onChange} value={form.text} />
                </div>
                <button type="submit">Send</button>
            </form>
            { previousComments.map(comment => <div key={comment.id}>{comment.text}</div>)}
        </div>
    )
}

export default Comments;