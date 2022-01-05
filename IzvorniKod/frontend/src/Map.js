import React from "react";
//import "leaflet/dist/leaflet.css";
import { MapContainer, TileLayer } from "react-leaflet";
import RoutingMachine from "./Routing";

function Map() {
  return (
    <MapContainer center={[43.505, 16.09]} zoom={13} scrollWheelZoom={true}>
      <TileLayer
        attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
        url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
      />
      <RoutingMachine />
    </MapContainer>
  );
}

export default Map;
