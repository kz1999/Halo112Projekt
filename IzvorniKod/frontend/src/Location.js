import React from "react";
import './styles/App.css';

function Location(props){
    const [location, setLocation] = React.useState([]);

    React.useEffect(()=>{
        fetch('/lokacija/'+props.location_id)
        .then(data => data.json())
        .then(data => setLocation(data));
    }, []);

    if(location !== null && location !== undefined){
        return(
            <div className="Location">
                X: {location.x}, Y: {location.y}
            </div>
        )
    }return(
        <div></div>
    )
}


export default Location;