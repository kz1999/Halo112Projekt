import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";

import "./styles/App.css";

import Login from "./Login";
import Register from "./Register";
import { HeaderLoggedIn, HeaderLoggedOut } from "./Header";
import Users from "./Users";
import Test from "./Test";
import AddMemberToStation from "./AddMemberToStation";
import CreateStation from "./CreateStation";
import Map from "./Map";
import Location from "./Location";
import Comments from "./Comments";
import Actions from "./Actions";
import ResponderIsReady from "./ResponderIsReady";

function App() {
  const [isLoggedIn, setIsLoggedIn] = React.useState(false);
  const [isDirector, setIsDirector] = React.useState(false);
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

  function onLogout() {
    const options = {
      mode: "no-cors",
    };
    fetch("/logout", options).then(() => {});
    checkUserStatus();
  }

  function checkUserStatus() {
    fetch("/user")
      .then((data) => data.json())
      .then((data) => {
        if (data === null) {
          setIsLoggedIn(false);
          setIsDirector(false);
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
          if(user.role==="fireman" || user.role==="policeman" || user.role==="doctor"){
            setIsDirector(true);
          }
        }
      });
  }

  if (isLoggedIn === false) {
    return (
      <BrowserRouter>
        <HeaderLoggedOut />
        <div className="App">
          <Switch>
            <Login path="/login" checkUserStatus={checkUserStatus} />
            <Route path="/register" exact component={Register} />
          </Switch>
        </div>
      </BrowserRouter>
    );
  }

  return (
    <BrowserRouter>
      <HeaderLoggedIn
        isDirector={isDirector}
        onLogout={onLogout}
        currentUser={user.userName}
        role={user.role}
      />
      <div className="App">
        <Switch>
          <Route path="/" exact component={Test} />
          <Route path="/register" exact component={Register} />
          <Route path="/users" exact component={Users} />
          <Route path="/test" exact component={Test} />
          <Route path="/createStation" exact component={CreateStation} />¸
          <Route path="/station" exact component={AddMemberToStation} />
          <Route path="/map" exact component={Map} />
          <Route path="/location" exact component={Location} />
          <Route path="/comments" exact component={Comments} />
          <Route path="/actions" exact component={Actions} />
          <Route path="/status" exact component={ResponderIsReady} />
        </Switch>
      </div>
    </BrowserRouter>
  );
}

export default App;
