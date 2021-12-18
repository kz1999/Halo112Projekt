import React from 'react';
import {BrowserRouter, Switch, Route} from 'react-router-dom';

import './styles/App.css';
import 'leaflet/dist/leaflet.css';

import Login from './Login';
import Register from './Register';
import {HeaderLoggedIn, HeaderLoggedOut} from './Header';
import Users from './Users';
import Test from './Test';
import {MapContainer, TileLayer, Marker, Popup} from 'react-leaflet';

function App() {

  const [isLoggedIn, setIsLoggedIn] = React.useState(false);
  const [user, setUser] = React.useState( {username:'', password:'', name:'', lastName:'', phoneNumber:'', email:'', role:'', confirmed:false});
  
  function checkUserStatus(){
    fetch('/user')
      .then(data => data.json())
      .then(data =>{
        if(data === null){
          setIsLoggedIn(false);
          setUser({username:'', password:'', name:'', lastName:'', phoneNumber:'', email:'', role:'', confirmed:false});
        }else{
          setIsLoggedIn(true);
          setUser(data);
        }
    })
  }

  if(isLoggedIn !== true){
    return(
      <BrowserRouter>
        <HeaderLoggedOut/>
        <div className="App">
          <Switch>
            <Login path='/login' onLogin={checkUserStatus}/>
            <Route path='/register' exact component={Register}/>
          </Switch>
        </div>
      </BrowserRouter>
    );
  }

  return (
    <React.Fragment>
    <BrowserRouter>
      <HeaderLoggedIn onLogout={checkUserStatus} currentUser={user.userName} role={user.role}/>
      <div className="App">
        <Switch>
          <Route path='/' exact component={Test}/>
          <Route path='/register' exact component={Register}/>
          <Route path='/users' exact component={Users}/>
          <Route path='/test' exact component={Test}/>
        </Switch>
      </div>
    </BrowserRouter>

    <MapContainer center={[51.505, -0.09]} zoom={13} scrollWheelZoom={false}>
  <TileLayer
    attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
  />
  <Marker position={[51.505, -0.09]}>
    <Popup>
      A pretty CSS3 popup. <br /> Easily customizable.
    </Popup>
  </Marker>
</MapContainer>
    </React.Fragment>
  );
}

export default App;
