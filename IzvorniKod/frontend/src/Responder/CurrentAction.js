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
import Task from "./Task";

function CurrentAction(props) {
  const [tasks, setTasks] = React.useState([]);
  const [responderId, setResponderId] = React.useState([]);
  var locations = [];

  React.useEffect(() => {
    fetch("/task")
      .then((data) => data.json())
      .then((data) => setTasks(data));
  }, []);

  React.useEffect(() => {
    fetch("/spasioci/current")
      .then((data) => data.json())
      .then((data) => setResponderId(data.id));
  }, []);

  const taskArr = tasks
    .filter((task) => task.responder_id === responderId)
    .map((task) => task.location_id);

  for (let i = 0; i < taskArr.length; i++) {
    let temp = taskArr[i];
    for (let j = 0; j < temp.length; j++) {
      locations = locations.concat(taskArr[i]);
    }
  }

  const waypointsAux = [];

  for (let i = 0; i < locations.length; i++) {
    let locationId = locations[i];
  }

  console.log(waypointsAux);

  const createRoutineMachineLayer = (props) => {
    const instance = L.Routing.control({
      //waypoints: waypointsAux,
      lineOptions: {
        styles: [{ color: "#6FA1EC", weight: 4 }],
      },
      addWaypoints: true,
      routeWhileDragging: true,
      draggableWaypoints: true,
      fitSelectedRoutes: true,
      showAlternatives: false,
      collapsible: true,
      geocoder: L.Control.Geocoder.nominatim(),
    });

    return instance;
  };

  const RoutingMachine = createControlComponent(createRoutineMachineLayer);

  return (
    <>
      <div className="Status">
        <h2>Action id: {props.currentAction_id}</h2>
        {tasks
          .filter((task) => task.responder_id === responderId)
          .map((task) => (
            <Task key={task.id} taskId={task.id} />
          ))}
      </div>
      <div>
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
        </MapContainer>
      </div>
    </>
  );
}

export default CurrentAction;
