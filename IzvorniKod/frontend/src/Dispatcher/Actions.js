import React from "react";
import '../styles/App.css';
import Akcija from './Akcija'

function Actions(){
    const [allActions, setAllActions] = React.useState([]);
    
    React.useEffect(()=>{
        fetch('/akcije')
        .then(data => data.json())
        .then(allActions => setAllActions(allActions));
    }, []);

    return(

        <div className="Actions">
            <h2>Actions</h2>
            { allActions.map(akcija => <Akcija key={akcija.id} actionId={akcija.id}/>)}
        </div>
    )
}


export default Actions;