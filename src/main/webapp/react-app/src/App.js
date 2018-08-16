import React, { Component } from 'react';
import HomePage from './homePage/HomePage';
import Login from './login/Login';
import Register from './register/Register';
import Profile from './profile/Profile';
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
          <HomePage setLocation={this.setLocation} user={this.state.user} setUser={this.setUser} />
        ) : this.state.location === 'login' ? (
          <Login setLocation={this.setLocation} user={this.state.user} setUser={this.setUser} />
        ) : this.state.location === 'register' ? (
          <Register setLocation={this.setLocation} user={this.state.user} setUser={this.setUser} />
        ) : this.state.location === 'profile' ? (
          <Profile setLocation={this.setLocation} user={this.state.user} setUser={this.setUser} />
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