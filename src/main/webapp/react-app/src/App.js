import React, { Component } from 'react';
import HomePage from './homePage/HomePage';
import Login from './login/Login';
import AppService from './AppService';

export default class App extends Component {

  constructor(props) {
    super(props);

    Object.keys(AppService).forEach(key => {
      this[key] = AppService[key].bind(this);
    });

    this.state = { location: 'home' };
    
  }

  render() {
    return (
      <div>
        { this.state.location === 'home' ? (
          <HomePage setLocation={this.setLocation} />
        ) : this.state.location === 'login' ? (
          <Login setLocation={this.setLocation} />
        ) : (
          <div>
            { this.state.location }
            <div onClick={() => this.setState({ location: 'home' })} >
            Click here to go home
            </div>
          </div>
        )}

      </div>
      
    );
  }
}