import React, { useState } from "react";
import "./styles/App.css";
import L from "leaflet";
import {
  MapContainer,
  TileLayer,
  useMapEvents,
  Popup,
  Marker,
} from "react-leaflet";
import RoutingMachine from "./Routing";
import { LatLng } from "leaflet";
import carMarker from "./images/car.png";
import rescMarker from "./images/person.png";

function Map() {
  const iconCar = new L.Icon({
    iconUrl: carMarker,
    iconRetinaUrl: carMarker,
    iconAnchor: null,
    popupAnchor: null,
    shadowUrl: null,
    shadowSize: null,
    shadowAnchor: null,
    iconSize: new L.Point(40, 40),
    className: "leaflet-div-icon",
  });

  const initialMarkers: LatLng[] = [];
  const [markers, setMarkers] = useState(initialMarkers);
  
  React.useEffect(()=>{
    fetch('/lokacija')
    .then(data => data.json())
    .then(markers => {
      markers.map(marker => initialMarkers.push(new LatLng(marker.x, marker.y)))
    });
  }, []);
  
  function LocationMarkers() {
    const map = useMapEvents({
      click(e) {
        markers.push(e.latlng);
        setMarkers((prevValue) => [...prevValue, e.latlng]);
      },
    });

    return (
      <React.Fragment>
        {markers.map((marker) => (
          <Marker position={marker} icon={iconCar}></Marker>
        ))}
      </React.Fragment>
    );
  }

  return (
    <div className="Map">
      <h2>Map</h2>
      <MapContainer
        center={[45.8, 16]}
        zoom={13}
        scrollWheelZoom={true}
        closePopupOnClick={true}
      >
        <TileLayer
          attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
        />
        <RoutingMachine />
        <LocationMarkers />
      </MapContainer>
    </div>
  );
}

export default Map;
