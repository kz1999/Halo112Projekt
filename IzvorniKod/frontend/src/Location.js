import React from "react";
import './styles/App.css';

function Location(){
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

    return(
        <div className="Location">
            <h2>Add Location</h2>
            <form onSubmit={onSubmit}>
                <div className="FormRow">
                    <label>name</label>
                    <input name='name' onChange={onChange} value={form.name}/>
                </div>
                <div className="FormRow">
                    <label>x</label>
                    <input name='x' onChange={onChange} value={form.x}/>
                </div>
                <div className="FormRow">
                    <label>y</label>
                    <input name='y'  onChange={onChange} value={form.y}/>
                </div>
                <button type="submit">Add</button>
            </form>
        </div>
    )
}

export default Location;