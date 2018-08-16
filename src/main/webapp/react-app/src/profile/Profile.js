import React, { Component } from 'react';
import TextField from '@material-ui/core/TextField';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import ProfileService from './ProfileService';
import './Profile.css';

export default class Profile extends Component {

  constructor(props) {
    super(props);
    
    Object.keys(ProfileService).forEach(key => {
      this[key] = ProfileService[key].bind(this);
    });

    this.state = { username: '', password: '', role: '' };
    
  }

  componentWillMount() {
    this.onComponentWillMount();
  }

  render() {
    return (
      <div className="register-wrapper">
        <header className="home-header">
        <div className="back-button" onClick={() => this.props.setLocation('home')}>
            Back
          </div>
          <h1 className="home-title">CS5200 Stock Trader</h1>
        </header>

        <div className="register-container">
          <div className="register-header">{this.props.user.userName} Profile</div>
          <TextField
            id="password"
            label="Password"
            className="password-textfield"
            type="password"
            value={this.state.password}
            onChange={this.onPasswordChange}
            margin="normal"
          />

          <TextField
            id="firstName"
            label="First Name"
            className="username-textfield"
            value={this.state.firstName}
            onChange={this.onFirstNameChange}
            margin="normal"
          />

          <TextField
            id="lastName"
            label="Last Name"
            className="username-textfield"
            value={this.state.lastName}
            onChange={this.onLastNameChange}
            margin="normal"
          />

          <TextField
            id="email"
            label="Email"
            className="username-textfield"
            value={this.state.email}
            onChange={this.onEmailChange}
            margin="normal"
          />

          <TextField
            id="dob"
            label="Date of Birth (YYY-MM-DD)"
            className="username-textfield"
            value={this.state.dob}
            onChange={this.onDobChange}
            margin="normal"
          />

          <div className="submit-button" onClick={this.submitUpdate}>
            Update
          </div>
          <div className="error-message">
            {this.state.errorMessage}
          </div>
        </div>
      </div>
    );
  }
}