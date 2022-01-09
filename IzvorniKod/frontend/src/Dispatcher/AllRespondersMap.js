import React from "react";
import '../styles/App.css';
import '../styles/Switch.css';

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
        React.useEffect(()=>{
            fetch('/lokacija/'+props.location_id)
            .then(data => data.json())
            .then(data => setLocation(data));
        }, []);
        return(
            <div>
                <div>{location.x}, {location.y}</div>
            </div>
        )
    }
    
    function FilterAllResponders(){ 
        if(form.option==='1'){
            return(
                <div>
                    {responders.map(responder=>
                        <Responder location_id={responder.location_id}/>)
                    }
                </div>
            )
        }else if(form.option==='2'){
            return(
                <div>
                    {responders.filter(responder => responder.status===true && responder.action===null).map(responder=>
                        <Responder location_id={responder.location_id}/>)
                    }
                </div>
            )
        }else if(form.option==='3' && form.action!==''){
            return(
                <div>
                    {responders.filter(responder=>responder.currentAction_id === parseInt(form.action)).map(responder=>
                        <Responder location_id={responder.location_id}/>)
                    }
                </div>
            )
        }
        
        return(
            <div>
                greska
            </div>
        )
    }

    return(
        <div className="">
            <form>
                <div className="FormRow">
                    <label>asd</label>
                    <select name='option' onChange={onChange} value={form.option}>
                        <option value="1">svi spasioci</option>
                        <option value="2">dostupnih neaktivnih spasioca</option>
                        <option value="3">aktivnih spasioci na odredenoj akciji</option>
                    </select>
                    <div/>
                    <select name='action' onChange={onChange} hidden={form.option !== '3'}>
                        {actions.map(action=><option key={action.id} value={action.id} label={action.description}/>)}
                    </select>
                </div>
            </form>
            <div>
            <FilterAllResponders/>
            </div>
        </div>
    )
}


export default AllRespondersMap;