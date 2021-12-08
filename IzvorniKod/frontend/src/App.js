import React from 'react';
import {BrowserRouter, Switch, Route} from 'react-router-dom';

import './styles/App.css';

import Login from './Login';
import MainPage from './MainPage';
import Register from './Register';
import Header from './Header';
import UsersList from './UsersList';
import Logout from './Logout';


function App() {

  return (
    
    <BrowserRouter>
      <Header/>
      <div className="App">
        <Switch>
          <Route path='/register' exact component={Register}/>
          <Route path='/main' exact component={MainPage}/>
          <Route path='/users' exact component={UsersList}/>
          <Route path='/login' exact component={Login}/>
          <Route path='/logout' exact component={Logout}/>
        </Switch>
      </div>
    </BrowserRouter>
  );
}

export default App;
