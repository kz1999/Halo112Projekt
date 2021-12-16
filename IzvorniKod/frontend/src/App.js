import React from 'react';
import {BrowserRouter, Switch, Route} from 'react-router-dom';

import './styles/App.css';

import Login from './Login';
import Register from './Register';
import Header from './Header';
import UsersList from './UsersList';
import Test from './Test';


function App() {

  return (
    
    <BrowserRouter>
      <Header/>
      <div className="App">
        <Switch>
          <Route path='/register' exact component={Register}/>
          <Route path='/users' exact component={UsersList}/>
          <Route path='/login' exact component={Login}/>
          <Route path='/test' exact component={Test}/>
        </Switch>
      </div>
    </BrowserRouter>
  );
}

export default App;
