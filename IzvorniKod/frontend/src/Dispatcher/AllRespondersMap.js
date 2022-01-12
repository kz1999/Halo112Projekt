import React from "react";
import '../styles/App.css';
import '../styles/Switch.css';
import CreateTask from './CreateTask'

import {MapContainer,TileLayer,useMapEvents,Popup,Marker,} from "react-leaflet";
import * as L from "leaflet";
import { LatLng } from "leaflet";
import { createControlComponent } from "@react-leaflet/core";
import "leaflet-control-geocoder/dist/Control.Geocoder.css";
import "leaflet-control-geocoder/dist/Control.Geocoder.js";
import "leaflet-routing-machine/dist/leaflet-routing-machine.css";
import "leaflet-routing-machine/dist/leaflet-routing-machine.js";
import "leaflet-routing-machine";




function AllRespondersMap(props){
    //za stvaranje zadataka i prikazivanje pozicija na mapi, voronijev dijagram
    const [form, setForm] = React.useState({option:"", action:"", responder_id:""});
    const [actions, setActions] = React.useState([]);
    const [responders, setResponders] = React.useState([]);
    const [waypoints, setWaypoints] = React.useState([]);

    React.useEffect(()=>{
        fetch('/akcije')
        .then(data => data.json())
        .then(data => setActions(data));
        fetch('/spasioci')
        .then(data => data.json())
        .then(data => setResponders(data));
    }, []);

    function onChange(event){
        const {name, value} = event.target;
        setForm(oldForm => ({...oldForm, [name]: value}))
    }

    function Responder(props){ 
        const [location, setLocation] = React.useState(null);
        const [responder, setResponder] = React.useState(null);

        React.useEffect(()=>{
            fetch('/spasioci/'+props.responder_id)
            .then(data => data.json())
            .then(data => {setResponder(data); return data})
            .then(data => {
                fetch('/lokacija/'+data.location_id)
                .then(data => data.json())
                .then(data => setLocation(data));
                })
        }, []);
        
        if(location !== null)
            return(
                <Marker position={new L.latLng(location.x,location.y)}></Marker>
            )
        return(
            <div/>
        )
    }

    const createRoutineMachineLayer = (props) => {
        const instance = L.Routing.control({
          //waypoints: [L.latLng(45.8, 16), L.latLng(46, 16)],
          lineOptions: {
            styles: [{ color: "#6FA1EC", weight: 4 }],
          },
          addWaypoints: true,
          draggableWaypoints: true,
          routeWhileDragging: true,
          fitSelectedRoutes: true,
          //showAlternatives: false,
          collapsible: true,
          geocoder: L.Control.Geocoder.nominatim(),
          //showAlternatives: true,
        });
      
        return instance;
      };
    const RoutingMachine = createControlComponent(createRoutineMachineLayer);

    
    function FilterAllResponders(){ 
        if(form.option==='1'){
            return(
                responders.map(responder=>
                    <Responder key={responder.id} responder_id={responder.id}/>)
            )
        }else if(form.option==='2'){
            return(
                responders.filter(responder => responder.status===true && responder.action===null).map(responder=>
                    <Responder key={responder.id} responder_id={responder.id}/>)
            )
        }else if(form.option==='3' && form.action!==''){
            return(
                responders.filter(responder=>responder.currentAction_id === parseInt(form.action)).map(responder=>
                    <Responder key={responder.id} responder_id={responder.id}/>) 
            )
        }else if(form.option==='4' && form.responder_id!==''){
            return(
                <React.Fragment>
                    <Responder responder_id={form.responder_id}/>
                    <RoutingMachine/>
                </React.Fragment>
            )
        }
        return(
            <div/>
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
                    <select name='responder_id' onChange={onChange} hidden={form.option !== '4'}>
                        <option value="">Odaberi</option>
                        {responders.filter(responder => responder.currentAction_id !== null).map(responder=><option key={responder.id} value={responder.id} label={responder.userName}/>)}
                    </select>
                </div>
                <button type="submit" hidden={form.option !== '4'} disabled = {form.responder_id === ''}>Dodaj zadatak</button>
            </form>
            <div className="Action map">
                <MapContainer
                    center={[45.8, 16]}
                    zoom={13}
                    scrollWheelZoom={true}
                    closePopupOnClick={true}>
                    <TileLayer
                        attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
                        url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"/>

                    <FilterAllResponders/>
                    
                </MapContainer>
            </div>
            
        </div>
    )
}


export default AllRespondersMap;