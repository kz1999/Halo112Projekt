import React from "react";
import '../styles/App.css';
import Akcija from './Akcija'

function CreateAction(){
    const [form, setForm] = React.useState({description:""});

    function addAction(event){
        event.preventDefault();
        
        const data = {
            description: form.description
        };

        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        };
        console.log(data)
        //fetch('/akcije', options).then(response=>response.json()).then(response=>console.log(response))
    }

    function onChange(event){
        const {name, value} = event.target;
        setForm(oldForm => ({...oldForm, [name]: value}))
    }

    function isValid(){
        const {description} = form;
        return description.length > 0;
    }

    return(

        <div className="CreateAction">
            <h2>CreateAction</h2>
            <form onSubmit={addAction}>
                <div className="FormRow">
                    <label>description</label>
                    <input name='description' onChange={onChange} value={form.description}/>
                </div>
                <button type="submit" disabled = {!isValid()}>Send Request</button>
            </form>
        </div>
    )
}


export default CreateAction;