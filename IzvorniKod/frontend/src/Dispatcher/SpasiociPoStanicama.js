import React from "react";
import '../styles/App.css';
import '../styles/Switch.css';
import '../styles/CreateTask.css'
import OPTGroupStanica from "./OPTGroupStanica";

function SpasiociPoStanicama(props){
    //za stvaranje zadataka i prikazivanje pozicija na mapi, voronijev dijagram
    const [stations, setStations] = React.useState([]);
    

    React.useEffect(()=>{
        fetch('/stanice')
        .then(data => data.json())
        .then(data => setStations(data));
    }, []);
                    
    return(
        <div className="Stanice">
            <select className="choice-box" name ="role">
                <option>Slobodni Spasioci</option>
            {stations.map(station => <OPTGroupStanica key={station.id} stationId={station.id}/>)}
            </select>
        </div>
    )
}


export default SpasiociPoStanicama;