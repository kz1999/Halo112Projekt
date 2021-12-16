import React from 'react';
import {BrowserRouter, Switch, Route} from 'react-router-dom';

import './styles/App.css';

import Login from './Login';
import Register from './Register';
import {HeaderLoggedIn, HeaderLoggedOut} from './Header';
import UsersList from './UsersList';
import Test from './Test';


function App() {

  const [user, setUser] = React.useState(false);
  const [username, setUsername] = React.useState('');

  function checkUserStatus(){
    fetch('/user')
      .then(data => data.json())
      .then(data =>{
        if(data === null){
          setUser(false);
        }else{
          setUser(true);
          setUsername(data.userName);
        }
    })
  }

  if(user === false){
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
    <BrowserRouter>
      <HeaderLoggedIn onLogout={checkUserStatus} currentUser={username}/>
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
