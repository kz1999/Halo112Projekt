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

    function onClick1(event){
        //trenutno dodaje lokaciju za akciju, ali ta funkcija je nepotrebna
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

    function addAction(event){
        event.preventDefault();
        
        const data = {
            description:"majmunovo"
        };

        const options={
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        };

        fetch('/akcije', options).then(response=>response.json()).then(response=>console.log(response))
    }

    return(

        <div className="Actions">
            <h2>Actions</h2>
            { allActions.map(akcija => <Akcija key={akcija.id} actionId={akcija.id}/>)}
            <button onClick={onClick1}>X</button>
        </div>
    )
}


export default Actions;