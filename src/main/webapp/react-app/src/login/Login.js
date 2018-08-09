import React, { Component } from 'react';
import TextField from '@material-ui/core/TextField';
import LoginService from './LoginService';
import './Login.css';

export default class Login extends Component {

  constructor(props) {
    super(props);
    
    Object.keys(LoginService).forEach(key => {
      this[key] = LoginService[key].bind(this);
    });

    this.state = { username: '', password: '' };
    
  }

  componentWillMount() {
    this.onComponentWillMount();
  }

  render() {
    return (
      <div className="login-wrapper">
        <header className="home-header">
        <div className="back-button" onClick={() => this.props.setLocation('home')}>
            Back
          </div>
          <h1 className="home-title">CS5200 Stock Trader</h1>
        </header>

        <div className="login-container">
          <div className="login-header">Enter Username and Password to Login</div>
          <TextField
            id="username"
            label="Username"
            className="username-textfield"
            value={this.state.username}
            onChange={this.onUsernameChange}
            margin="normal"
          />
          <TextField
            id="password"
            label="Password"
            className="password-textfield"
            type="password"
            value={this.state.password}
            onChange={this.onPasswordChange}
            margin="normal"
          />
          <div className="register-button" onClick={this.register}>
            Register
          </div>
          <div className="submit-button" onClick={this.submitLogin}>
            Login
          </div>
          <div className="error-message">
            {this.state.errorMessage}
          </div>

        </div>
      </div>
    );
  }
}