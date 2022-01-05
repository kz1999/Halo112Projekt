import React from "react";
import './styles/App.css';
import { MapContainer, TileLayer, useMapEvents } from "react-leaflet";
import RoutingMachine from "./Routing";


function Map(){

    return(
        <div className="Map">
            <h2>Map</h2>
            <MapContainer center={[45.8, 16]} zoom={13} scrollWheelZoom={true} closePopupOnClick={true}>
                <TileLayer
                    attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
                    url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
                 />
                <RoutingMachine />
            </MapContainer>
        </div>
    )
}

export default Map;