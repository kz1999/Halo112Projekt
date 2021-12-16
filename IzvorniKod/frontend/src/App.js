import React from 'react';
import {BrowserRouter, Switch, Route} from 'react-router-dom';

import './styles/App.css';

import Login from './Login';
import Register from './Register';
import {HeaderLoggedIn, HeaderLoggedOut} from './Header';
import UsersList from './UsersList';
import Test from './Test';


function App() {

  const [isLoggedIn, setIsLoggedIn] = React.useState(false);

  function onLogin(){
    setIsLoggedIn(true)
  }

  function onLogout(){
    setIsLoggedIn(false)
  }

  if(!isLoggedIn){
    return(
      <BrowserRouter>
        <HeaderLoggedOut/>
        <div className="App">
          <Switch>
            <Login path='/' onLogin={onLogin}/>
            <Login path='/login' onLogin={onLogin}/>
            <Route path='/register' exact component={Register}/>
          </Switch>
        </div>
      </BrowserRouter>
    );
  }

  return (
    <BrowserRouter>
      <HeaderLoggedIn onLogout={onLogout}/>
      <div className="App">
        <Switch>
          <Route path='/register' exact component={Register}/>
          <Route path='/users' exact component={UsersList}/>
          <Route path='/test' exact component={Test}/>
        </Switch>
      </div>
    </BrowserRouter>
  );
}

export default App;
