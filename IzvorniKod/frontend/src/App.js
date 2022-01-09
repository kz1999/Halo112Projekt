import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";

import "./styles/App.css";

import Login from "./Login/Login";
import Register from "./Login/Register";

import { HeaderLoggedIn, HeaderLoggedOut } from "./Header";
import Users from "./Admin/Users";
import Test from "./Test";
import AddMemberToStation from "./Responder/AddMemberToStation";
import CreateStation from "./Admin/CreateStation";
import Map from "./Map";
import CreateLocation from "./Dispatcher/CreateLocation";
import Comments from "./Comments";
import Actions from "./Dispatcher/Actions";
import ResponderActionMenager from "./Responder/ResponderActionMenager"
import Tasks from "./Dispatcher/Tasks"
import CreateAction from "./Dispatcher/CreateAction"

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
          if(data.role==="fireman" || data.role==="policeman" || data.role==="doctor"){
            fetch("/spasioci/current").then(data=>data.json()).then(spasioc=>setIsDirector(spasioc.director))
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
          <Route path="/location" exact component={CreateLocation} />
          <Route path="/comments" exact component={Comments} />
          <Route path="/actions" exact component={Actions} />
          <Route path="/status" exact component={ResponderActionMenager} />
          <Route path="/tasks" exact component={Tasks} />
          <Route path="/createAction" exact component={CreateAction} />
        </Switch>
      </div>
    </BrowserRouter>
  );
}

export default App;
