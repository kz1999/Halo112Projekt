import React from "react";
import '../styles/App.css';
import '../styles/Switch.css';

function Request(props){

    const [request, setRequest] = React.useState([]);
    const [responder, setResponder] = React.useState([]);

    React.useEffect(()=>{
        fetch('/spasioci/current')
        .then(data => data.json())
        .then(data => setResponder(data));
    }, []);

    React.useEffect(()=>{
        fetch('/dispatcher/requests/'+props.request_id)
        .then(data => data.json())
        .then(data => setRequest(data));
    }, []);

    function accept(event){
        event.preventDefault();
        const options={
            method: 'POST',
            headers:{'Content-Type': 'application/json'},
            body: JSON.stringify({})
        };

        fetch('spasioci/' + responder.id + '/acceptRequest/'+ request.id, options).then(data => console.log(data));
        console.log("accept")
    }

    function decline(event){
        event.preventDefault();
        const options={
            method: 'POST',
            headers:{'Content-Type': 'application/json'},
            body: JSON.stringify({})
        };
        console.log(options.body)
        fetch('spasioci/' + responder.id + '/rejectRequest/' + request.id, options).then(data => console.log(data));
        
    }

    return(
        <div className="Request">
            
            {request.emergencyLevel}
            {request.responderAbility}
            <button onClick={accept}>Accept</button>
            <button onClick={decline}>Reject</button>
        </div>
    )
}


export default Request;