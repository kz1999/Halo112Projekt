import React from "react";
import './styles/App.css';

function Comments(){
    const [previousComments, setPreviousComments] = React.useState([]);
    const [yourComment, setYourComment] = React.useState('');
    
    React.useEffect(()=>{
        fetch('/komentari')
        .then(data => data.json())
        .then(previousComments => setPreviousComments(previousComments));
    }, []);
    
    function onChange(event){
        const {name, value} = event.target;
        setLoginForm(oldForm => ({...oldForm, [name]: value}))
    }

    function onSubmit(event){
        event.preventDefault();
        
        //timestamp
        const data = {
            owner_id: 1,
            text: yourComment
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
                    <input name='yourComment' onChange={onChange} value={yourComment} />
                </div>
                <button type="submit">Send</button>
            </form>
        </div>
    )
}

export default Comments;