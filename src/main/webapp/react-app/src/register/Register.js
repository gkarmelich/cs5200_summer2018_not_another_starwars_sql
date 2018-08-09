import React, { Component } from 'react';
import TextField from '@material-ui/core/TextField';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import RegisterService from './RegisterService';
import './Register.css';

export default class Register extends Component {

  constructor(props) {
    super(props);
    
    Object.keys(RegisterService).forEach(key => {
      this[key] = RegisterService[key].bind(this);
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
          <div className="register-header">Enter Information to Register</div>
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

          <FormControl className="role-select-wrapper">
            <InputLabel>Role</InputLabel>
            <Select value={this.state.role} onChange={this.onRoleChange} >
                <MenuItem value={'investor'}>Investor</MenuItem>
                <MenuItem value={'manager'}>Fund Manager</MenuItem>
                <MenuItem value={'staff'}>Support Staff</MenuItem>
            </Select>
          </FormControl>

          <div className="submit-button" onClick={this.submitRegister}>
            Register
          </div>
          <div className="error-message">
            {this.state.errorMessage}
          </div>
        </div>
      </div>
    );
  }
}