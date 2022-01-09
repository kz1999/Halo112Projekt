import React from "react";
import './styles/App.css';

function Location(props){

    const [location, setLocation] = React.useState([]);

    React.useEffect(()=>{
        fetch('/lokacija/'+props.location_id)
        .then(data => data.json())
        .then(data => setLocation(data));
    }, []);

    return(
        <div className="Location">
            {location.x}{location.y}
        </div>
    )
}


export default Location;