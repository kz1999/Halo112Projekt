import React from "react";
import './styles/App.css';

function Test(){

    function onClickStation(event){
        event.preventDefault();
        
        const data = {
            name: "pimpek",
            director_id: null,
            location_id: null,
            stationType: "FIREMAN"
        };
        
        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        };

        fetch('/akcije', options).then(data => data.json()).then(data => console.log(data));
    }

    function onClickLocation(event){
        event.preventDefault();
        
        fetch('/akcije').then(response=>response.json()).then(response=>console.log(response))
    }

    

    return(
        <div className="Test">
            <h2>Test</h2>    
            <div><button onClick={onClickStation}>Gumb</button></div>
            <div><button onClick={onClickLocation}>Gumb</button></div>
        </div>
    )
}

export default Test;