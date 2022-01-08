import React from "react";
import './styles/App.css';
import './styles/Switch.css';

function ResponderIsReady(){

    const [responder, setResponder] = React.useState([]);

    React.useEffect(()=>{
        fetch('/spasioci/current')
        .then(data => data.json())
        .then(responder => setResponder(responder));
    }, []);

    function myFunction() {
        var status = document.getElementById("check").checked;
        
        const data={
            status: status
        }
        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        };

        fetch('/spasioci/'+responder.id, options).then(data => data.json()).then(data => console.log(data));
    }

    return(
        <div className="Status">
            <h2>Status</h2>
            <label className="switch">
                <input type="checkbox" id="check" defaultChecked={responder.status} onClick={myFunction}/>
                <span class="slider round"></span>
            </label>
        </div>
    )
}


export default ResponderIsReady;