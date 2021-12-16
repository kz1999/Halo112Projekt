import React from 'react';
import {BrowserRouter, Switch, Route} from 'react-router-dom';

import './styles/App.css';

import Login from './Login';
import Register from './Register';
import Header from './Header';
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
      <div className='App'>
        <Login onLogin={onLogin}/>
      </div>
    )
  }





  return (
    
    <BrowserRouter>
      <Header onLogout={onLogout}/>
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
