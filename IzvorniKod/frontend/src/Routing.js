import L from "leaflet";
import { createControlComponent } from "@react-leaflet/core";
import "leaflet-control-geocoder/dist/Control.Geocoder.css";
import "leaflet-control-geocoder/dist/Control.Geocoder.js";
import "leaflet-routing-machine/dist/leaflet-routing-machine.css";
import "leaflet-routing-machine/dist/leaflet-routing-machine.js";
import "leaflet-routing-machine";

const createRoutineMachineLayer = (props) => {
  const instance = L.Routing.control({
    //waypoints: [L.latLng(45.8, 16), L.latLng(46, 16)],
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
    showAlternatives: true,
  });

  return instance;
};

const RoutingMachine = createControlComponent(createRoutineMachineLayer);

export default RoutingMachine;
