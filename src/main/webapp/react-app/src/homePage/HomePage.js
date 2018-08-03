import React, { Component } from 'react';
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
      </div>
    );
  }
}