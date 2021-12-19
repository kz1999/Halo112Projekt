import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";

import "./styles/App.css";

import Login from "./Login";
import Register from "./Register";
import { HeaderLoggedIn, HeaderLoggedOut } from "./Header";
import Users from "./Users";
import Test from "./Test";
import Map from "./Map";
//import { MapContainer } from "react-leaflet";

function App() {
  const [isLoggedIn, setIsLoggedIn] = React.useState(false);
  const [user, setUser] = React.useState({
    username: "",
    password: "",
    name: "",
    lastName: "",
    phoneNumber: "",
    email: "",
    role: "",
    confirmed: false,
  });

  function checkUserStatus() {
    fetch("/user")
      .then((data) => data.json())
      .then((data) => {
        if (data === null) {
          setIsLoggedIn(false);
          setUser({
            username: "",
            password: "",
            name: "",
            lastName: "",
            phoneNumber: "",
            email: "",
            role: "",
            confirmed: false,
          });
        } else {
          setIsLoggedIn(true);
          setUser(data);
        }
      });
  }

  if (isLoggedIn !== true) {
    return (
      <BrowserRouter>
        <HeaderLoggedOut />
        <div className="App">
          <Switch>
            <Login path="/login" onLogin={checkUserStatus} />
            <Route path="/register" exact component={Register} />
          </Switch>
        </div>
      </BrowserRouter>
    );
  }

  return (
    <BrowserRouter>
      <HeaderLoggedIn
        onLogout={checkUserStatus}
        currentUser={user.userName}
        role={user.role}
      />
      <div className="App">
        <Switch>
          <Route path="/" exact component={Test} />
          <Route path="/register" exact component={Register} />
          <Route path="/users" exact component={Users} />
          <Route path="/test" exact component={Test} />
        </Switch>
      </div>
      <div>
        <Map />
      </div>
    </BrowserRouter>
  );
}

export default App;
