import React, { Component, useState } from "react";
import "../styles/App.css";
import "../styles/Switch.css";

import {
  MapContainer,
  TileLayer,
  useMapEvents,
  Popup,
  Marker,
} from "react-leaflet";
import * as L from "leaflet";
import { LatLng } from "leaflet";
import { createControlComponent } from "@react-leaflet/core";
import "leaflet-control-geocoder/dist/Control.Geocoder.css";
import "leaflet-control-geocoder/dist/Control.Geocoder.js";
import "leaflet-routing-machine/dist/leaflet-routing-machine.css";
import "leaflet-routing-machine/dist/leaflet-routing-machine.js";
import "leaflet-routing-machine";
//import RoutingMachine from "../Routing";
import carMarker from "../images/car.png";
import rescMarker from "../images/person.png";

function CurrentAction(props) {
  const [responderLocation, setResponderLocation] = React.useState(
    new LatLng(0, 0)
  );
  const [respondersLocations, setRespondersLocations] = React.useState([]);
  const [taskLocations, setTaskLocations] = React.useState({});

  const iconPerson = new L.Icon({
    iconUrl: rescMarker,
    iconRetinaUrl: rescMarker,
    iconAnchor: null,
    popupAnchor: null,
    shadowUrl: null,
    shadowSize: null,
    shadowAnchor: null,
    iconSize: new L.Point(40, 40),
    //className: "leaflet-div-icon",
  });

  React.useEffect(() => {
    fetch("/spasioci/current")
      .then((spasioc) => spasioc.json())
      .then((spasioc) => {
        if (spasioc !== undefined) {
          fetch("/lokacija/" + spasioc.location_id)
            .then((location) => location.json())
            .then((location) => {
              setResponderLocation(new LatLng(location.x, location.y));
            });
          fetch("/akcije/" + spasioc.currentAction_id)
            .then((akcija) => akcija.json())
            .then((akcija) => akcija.tasks)
            .then((tasks) =>
              tasks.filter((task) => task.responder_id === spasioc.id)
            )
            .then((tasks) => {
              tasks.map((task) => {
                task.location_id.map((location_id) => {
                  fetch("/lokacija/" + location_id)
                    .then((location) => location.json())
                    .then((location) => {
                      if (task.id in taskLocations) {
                        taskLocations[task.id].push(
                          new LatLng(location.x, location.y)
                        );
                      } else {
                        taskLocations[task.id] = [
                          new LatLng(location.x, location.y),
                        ];
                      }
                    });
                });
              });
            });
          fetch("/spasioci")
            .then((spasioci) => spasioci.json())
            .then((spasioci) =>
              spasioci.filter(
                (kolega) =>
                  kolega.currentAction_id === spasioc.currentAction_id &&
                  kolega.id !== spasioc.id
              )
            )
            .then((spasioci) =>
              spasioci.map((kolega) => {
                fetch("/lokacija/" + kolega.currentAction_id)
                  .then((location) => location.json())
                  .then((location) =>
                    respondersLocations.push(new LatLng(location.x, location.y))
                  );
              })
            );
        }
      });
  }, []);

  const createRoutineMachineLayer = (props) => {
    const instance = L.Routing.control({
      waypoints: props.waypoints,
      lineOptions: {
        styles: [{ color: "#6FA1EC", weight: 4 }],
      },
      addWaypoints: true,
      fitSelectedRoutes: true,
      showAlternatives: false,
      //geocoder: L.Control.Geocoder.nominatim(),
    });
    return instance;
  };
  const RoutingMachine = createControlComponent(createRoutineMachineLayer);

  function LocateUser() {
    const map = useMapEvents({
      keypress() {
        map.locate();
      },
      locationfound(e) {
        fetch("/spasioci/current")
            .then(spasioc => spasioc.json())
            .then(spasioc => {
                const options={
                    method: 'POST',
                    headers:{
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({x: e.latlng.lat, y: e.latlng.lng})
                };
                fetch('/lokacija/'+spasioc.location_id, options)
            })
        setResponderLocation(e.latlng);
      },
    });

    return null;
  }

  return (
    <div className="Action map">
      <h2>Action id: {props.currentAction_id}</h2>
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
        <React.Fragment>
          <LocateUser />

          <Marker position={responderLocation} icon={iconPerson}></Marker>
          {respondersLocations.map((marker) => (
            <Marker key={marker} position={marker}></Marker>
          ))}
        </React.Fragment>
        {Object.values(taskLocations).map((task) => (
          <RoutingMachine key={task} waypoints={task} />
        ))}
      </MapContainer>
    </div>
  );
}

export default CurrentAction;
