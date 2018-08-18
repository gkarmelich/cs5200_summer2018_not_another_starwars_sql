import React, { Component } from 'react';
import TextField from '@material-ui/core/TextField';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import AdminService from './AdminService';
import './Admin.css';

export default class Admin extends Component {

  constructor(props) {
    super(props);
    
    Object.keys(AdminService).forEach(key => {
      this[key] = AdminService[key].bind(this);
    });

    this.state = { userName: '', registeredUsers: [], roles: {} };
    
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

        <div className="admin-container">
          
            <TextField
                id="userName"
                label="Search Username"
                className="username-textfield"
                value={this.state.userName}
                onChange={this.onUserNameChange}
                margin="normal"
            />

            {this.getFilteredUsers().map(u => 
                <div className="user-container">
                    <div className="user">
                        {u.userName}
                    </div>

                    <div className="delete-button" onClick={() => this.deleteUser(u)}>Delete</div>
                    <div className="save-button" onClick={() => this.saveUser(u)}>Save</div>

                    <FormControl className="role-select-wrapper">
                        <InputLabel>Role</InputLabel>
                        <Select value={this.state.roles[u.idPerson]} onChange={(event) => this.onRoleChange(event, u)} >
                            <MenuItem value={'investor'}>Investor</MenuItem>
                            <MenuItem value={'manager'}>Fund Manager</MenuItem>
                            <MenuItem value={'staff'}>Support Staff</MenuItem>
                        </Select>
                    </FormControl>
                    
                </div>
            )}

        </div>
      </div>
    );
  }
}