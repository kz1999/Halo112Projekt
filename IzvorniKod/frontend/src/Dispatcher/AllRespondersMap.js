import React from "react";
import '../styles/App.css';
import '../styles/Switch.css';
import CreateTask from './CreateTask'

function AllRespondersMap(props){
    //za stvaranje zadataka i prikazivanje pozicija na mapi, voronijev dijagram
    const [form, setForm] = React.useState({option:"", action:""});
    const [actions, setActions] = React.useState([]);
    const [responders, setResponders] = React.useState([]);

    React.useEffect(()=>{
        fetch('/akcije')
        .then(data => data.json())
        .then(data => setActions(data));
    }, []);

    React.useEffect(()=>{
        fetch('/spasioci')
        .then(data => data.json())
        .then(data => setResponders(data));
    }, []);

    function onChange(event){
        const {name, value} = event.target;
        setForm(oldForm => ({...oldForm, [name]: value}))
    }

    function Responder(props){ 
        const [location, setLocation] = React.useState([]);
        const [responder, setResponder] = React.useState([]);

        React.useEffect(()=>{
            fetch('/lokacija/'+props.location_id)
            .then(data => data.json())
            .then(data => setLocation(data));
        }, []);
        React.useEffect(()=>{
            fetch('/spasioci/'+props.responder_id)
            .then(data => data.json())
            .then(data => setResponder(data));
        }, []);
        return(
            <div>
                <div>{props.responder_id}, {location.x}, {location.y}</div>
            </div>
        )
    }
    
    function FilterAllResponders(){ 
        if(form.option==='1'){
            return(
                <div>
                    {responders.map(responder=>
                        <Responder key={responder.id} responder_id={responder.id} location_id={responder.location_id}/>)
                    }
                </div>
            )
        }else if(form.option==='2'){
            return(
                <div>
                    {responders.filter(responder => responder.status===true && responder.action===null).map(responder=>
                        <Responder key={responder.id} responder_id={responder.id} location_id={responder.location_id}/>)
                    }
                </div>
            )
        }else if(form.option==='3' && form.action!==''){
            return(
                <div>
                    {responders.filter(responder=>responder.currentAction_id === parseInt(form.action)).map(responder=>
                        <Responder key={responder.id} responder_id={responder.id} location_id={responder.location_id}/>)
                    }
                </div>
            )
        }
        
        return(
            <div>
                
            </div>
        )
    }

    return(
        <div className="">
            <form>
                <div className="FormRow">
                    <label>Opcija</label>
                    <select name='option' onChange={onChange} value={form.option}>
                        <option value="">Odaberi</option>
                        <option value="1">svi spasioci</option>
                        <option value="2">dostupni neaktivni spasioci</option>
                        <option value="3">aktivnih spasioci na odredenoj akciji</option>
                        <option value="4">dodaj zadatak spasiocu na akciji</option>
                    </select>
                    <div/>
                    <select name='action' onChange={onChange} hidden={form.option !== '3'}>
                        <option value="">Odaberi</option>
                        {actions.map(action=><option key={action.id} value={action.id} label={action.description}/>)}
                    </select>
                </div>
            </form>
            
            <div hidden={form.option !== '4'}><CreateTask/></div>
            <FilterAllResponders/>
            
        </div>
    )
}


export default AllRespondersMap;