import L from "leaflet";
import { createControlComponent } from "@react-leaflet/core";
import "leaflet-routing-machine/dist/leaflet-routing-machine.css";
import "leaflet-routing-machine";

const createRoutineMachineLayer = (props) => {
  const instance = L.Routing.control({
    waypoints: [L.latLng(45.8, 16), L.latLng(46, 16)],
    lineOptions: {
      styles: [{ color: "#6FA1EC", weight: 4 }],
    },
    show: false,
    addWaypoints: true,
    routeWhileDragging: true,
    draggableWaypoints: true,
    fitSelectedRoutes: true,
    showAlternatives: false,
  });

  return instance;
};

const RoutingMachine = createControlComponent(createRoutineMachineLayer);

export default RoutingMachine;
