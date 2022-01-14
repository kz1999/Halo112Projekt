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
            <Link class="header-link" to="/users">Popis korisnika</Link>
            <Link class="header-link" to="/createStation">Stvori stanicu</Link>
            <button class="header-button" onClick={logout}>
              Korisnik: {props.currentUser}
              <div />
              Odjavite se!
            </button>
          </div>
        </header>
      </header>
    );
  } else if (props.role === "dispatcher") {
    return (
      <header className="Header">
        <header className="App-header-container">
          <div className="App-header-dispatcher">
            <Link class="header-link" to="/createAction">Nova akcija</Link>
            <Link class="header-link" to="/actions">Postojeće akcije</Link>
            <Link class="header-link" to="/tasks">Zadaci</Link>
            <Link class="header-link" to="/location">Lokacije</Link>
            <button class="header-button" onClick={logout}>
              Korisnik: {props.currentUser}
              <div/>
              Odjavite se!
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
              <Link class="header-link" to="/station" hidden={props.isDirector!==true}>Dodaj spasioca u svoju stanicu</Link>
              <Link class="header-link" to="/abilities" hidden={props.isDirector!==true}>Posebne moći</Link>
              <Link class="header-link" to="/status">Akcije</Link>
              <button class="header-button" onClick={logout}>
                Korisnik: {props.currentUser}
                <div/>
                Odjavite se!
              </button>
            </div>
          </header>
        </header>
      );
  }
  return (
    <header className="Header">
      <div className="Error">
        <p>Nešto je pošlo po krivu</p>
      </div>
    </header>
  );
}

function HeaderLoggedOut() {
  return (
    <header className="Header">
      <header className="App-header-container">
        <div className="App-header">
          <Link class="header-link" to="/login">Prijavi se</Link>
          <Link class="header-link" to="/register">Registriraj se</Link>
        </div>
      </header>
    </header>
  );
}
export { HeaderLoggedIn, HeaderLoggedOut };
