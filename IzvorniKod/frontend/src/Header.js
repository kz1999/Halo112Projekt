import React from "react";
import { Link } from "react-router-dom";
import "./styles/Header.css";

function HeaderLoggedIn(props) {
  function logout() {
    fetch("/logout").then(() => {
      props.onLogout();
    });
  }
  
  if (props.role === "admin") {
    return (
      <header className="Header">
        <header className="App-header-container">
          <div className="App-header">
            <Link to="/users">Users list</Link>
            <Link to="/createStation">Create station</Link>
            <Link to="/location">Create location</Link>
            <Link to="/comments">Comments</Link>
            <Link to="/map">Map</Link>
            <button onClick={logout}>
              user: {props.currentUser}, role: admin
              <div />
              Logout!
            </button>
          </div>
        </header>
      </header>
    );
  } else if (props.role === "dispatcher") {
    return (
      <header className="Header">
        <header className="App-header-container">
          <div className="App-header">
            <Link to="/actions">Actions</Link>
            <Link to="/tasks">Tasks</Link>
            <button onClick={logout}>
              user: {props.currentUser}, role: dispatcher
              <div/>
              Logout!
            </button>
          </div>
        </header>
      </header>
    );
  } else if (props.role === "fireman" || props.role === "policeman" || props.role === "doctor") {
    
    var responder = ([])
    fetch('/spasioci/current').then(data => data.json()).then(data => {responder=data});
  
    //fetch('fireman') je sada, vraca sve firemane, slicno za 'police', za doktore nisam uspio otkriti.
    //fetch('fireman/id') bi vracao abilities, to mi netreba trenutacno
    //fetch('responder') vraca director boolean -> otkriva mu se stranica za stanicu i dodavanje ljudi u nju

    //ispod statusa bi pisao popis akcija na koje je on pozvan, moze se odazvati samo na jednu, onda mu se otkriva mapa i zatvara /status
    //popis stanica bi bio u obliku pendingActions i currentAction (id)
    
      return (
        <header className="Header">
          <header className="App-header-container">
            <div className="App-header">
              <Link to="/station" hidden={props.isDirector===false}>Add member to your station</Link>
              <Link to="/status">Status</Link>
              <Link to="/map">Map</Link>
              <button onClick={logout}>
                user: {props.currentUser}, role: {props.role}
                <div/>
                Logout!
              </button>
            </div>
          </header>
        </header>
      );
  }
  return (
    <header className="Header">
      <div className="Error">
        <p>Something went wrong</p>
      </div>
    </header>
  );
}

function HeaderLoggedOut() {
  return (
    <header className="Header">
      <header className="App-header-container">
        <div className="App-header">
          <Link to="/login">Login</Link>
          <Link to="/register">Register</Link>
        </div>
      </header>
    </header>
  );
}
export { HeaderLoggedIn, HeaderLoggedOut };
