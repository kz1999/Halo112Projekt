import React from "react";
import '../styles/App.css';
import '../styles/AddLocation.css';

function CreateLocation(){
    const [form, setForm] = React.useState( {name:'', x:'', y:''});

    function onChange(event){
        const {name, value} = event.target;
        setForm(oldForm => ({...oldForm, [name]: value}))
    }

    function onSubmit(event){
        event.preventDefault();
        
        const data = {
            name: form.name,
            x: form.x,
            y: form.y
        };
        
        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        };

        fetch('/lokacija', options).then(data => data.json()).then(data => console.log(data));
    }

    function isValid(){
        const {name, x, y} = form;
        return name.length >= 1 && x.length >= 1 && y.length >= 1;
    }

    return(
        <div className="Location">
            <h2>Add Location</h2>
            <form className="UserForm" onSubmit={onSubmit}>
                <div className="FormRow">
                    <label className="form-label">Name:</label>
                    <input className="form-field" name='name' onChange={onChange} value={form.name}/>
                </div>
                <div className="FormRow">
                    <label className="form-label">X</label>
                    <input className="form-field" name='x' type='number' onChange={onChange} value={form.x}/>
                </div>
                <div className="FormRow">
                    <label className="form-label">Y</label>
                    <input className="form-field" name='y' type='number' onChange={onChange} value={form.y}/>
                </div>
                <button className="add-button" type="submit" disabled = {!isValid()}>Add</button>
            </form>
        </div>
    )
}

export default CreateLocation;