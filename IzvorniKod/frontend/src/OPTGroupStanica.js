import React from "react";
import './styles/App.css';
import Member from './Member'

function OPTGroupStanica(props){
    const [station, setStation] = React.useState([]);
    const [responders, setResponders] = React.useState([]);

    React.useEffect(()=>{
        fetch('/stanice/'+props.stationId)
        .then(data => data.json())
        .then(data => setStation(data));
    }, []);

    React.useEffect(()=>{
        fetch('/spasioci')
        .then(data => data.json())
        .then(data => setResponders(data));
    }, []);

    return(
        <optgroup label={station.name +  ", " + responders.filter(responder=>responder.status===true).filter(responder=>responder.stationId===station.id).length}>
            {
                responders.filter(responder=>responder.status===true)
                .filter(responder=>responder.stationId===station.id)
                .map(member_id => <Member key = {member_id} memberId={member_id}/>)
            }
        </optgroup>)
    
}


export default OPTGroupStanica;





