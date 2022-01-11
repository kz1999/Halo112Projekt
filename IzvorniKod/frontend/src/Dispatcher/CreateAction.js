import React from "react";
import '../styles/App.css';
import Akcija from './Akcija'

function CreateAction(){
    const [form, setForm] = React.useState({description:"", name:""});

    function addAction(event){
        event.preventDefault();
        
        const data = {
            name: form.name,
            description: form.description
        };

        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        };
        //console.log(data)
        fetch('/akcije', options).then(response=>response.json()).then(response=>console.log(response))
    }

    function onChange(event){
        const {name, value} = event.target;
        setForm(oldForm => ({...oldForm, [name]: value}))
    }

    function isValid(){
        const {description, name} = form;
        return description.length > 0 && name.length > 0;
    }

    return(

        <div className="CreateAction">
            <h2>Otvori akciju</h2>
            <form onSubmit={addAction}>
                <div className="FormRow">
                    <label>Naziv</label>
                    <input name='name' onChange={onChange} value={form.name}/>
                </div>
                <div className="FormRow">
                    <label>Informacije</label>
                    <input name='description' onChange={onChange} value={form.description}/>
                </div>
                <button type="submit" disabled = {!isValid()}>Otvori akciju</button>
            </form>
        </div>
    )
}


export default CreateAction;