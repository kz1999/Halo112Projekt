import React from 'react';
import {BrowserRouter, Switch, Route} from 'react-router-dom';

import './styles/App.css';

import StudentForm from './UserForm';


function App() {
  return (
    <div className="App">
      <header className="App-header">
          
      </header>
      <BrowserRouter>
        <Switch>
          <Route path='/' exact component={StudentForm}/>
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
