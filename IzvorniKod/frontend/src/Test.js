import React from "react";
import './styles/App.css';

function Test(){

    function onClick1(event){
        event.preventDefault();
        
        const data = {
            id: 7
        };
        
        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        };

        fetch('/akcije/location/8', options).then(data => console.log(data));
    }

    function onClick2(event){
        event.preventDefault();
        
        fetch('/akcije').then(response=>response.json()).then(response=>console.log(response))
    }

    function onClick3(event){
        event.preventDefault();
        
        const data = {
            owner_id: 1,
            text: "blabla"
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
        <div className="Test">
            <h2>Test</h2>    
            <div><button onClick={onClick1}>Gumb1</button></div>
            <div><button onClick={onClick2}>Gumb2</button></div>
            <div><button onClick={onClick3}>Gumb3</button></div>
        </div>
    )
}

export default Test;