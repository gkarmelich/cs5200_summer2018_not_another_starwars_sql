import React, { Component } from 'react';
import axios from 'axios';
import StockChart from '../stockChart/StockChart';
import HomePageService from './HomePageService';
import './HomePage.css';

export default class HomePage extends Component {

  constructor(props) {
    super(props);
    
    Object.keys(HomePageService).forEach(key => {
      this[key] = HomePageService[key].bind(this);
    });

    this.state = {};
    
  }

  componentWillMount() {
    axios.get('/api/investor').then(res => this.setState({ investor : res.data }));
  }

  render() {
    return (
      <div className="home-container">
        <header className="home-header">
          <h1 className="home-title">CS5200 Stock Trader</h1>
          <div className="login-button" onClick={this.onLoginButtonClick}>
            Login
          </div>
        </header>
        <div className="stockChart-container">
          <StockChart />
        </div>
        <div>
          {this.state.investor}
        </div>
      </div>
    );
  }
}