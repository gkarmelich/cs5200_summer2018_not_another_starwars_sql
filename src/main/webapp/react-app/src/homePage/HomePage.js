import React, { Component } from 'react';
import axios from 'axios';
import StockChart from '../stockChart/StockChart';
import Messages from '../messages/Messages';
import HomePageService from './HomePageService';
import './HomePage.css';

export default class HomePage extends Component {

  constructor(props) {
    super(props);
    
    Object.keys(HomePageService).forEach(key => {
      this[key] = HomePageService[key].bind(this);
    });

    this.state = { myManagedPortfolios: [], myStaffedPortfolios: [] };
    
  }

  componentWillMount() {
    this.onComponentWillMount();
  }

  render() {
    console.log(this.props.user);
    return (
      <div className="home-container">
        {this.props.user ? (
          <header className="home-header">
            <h1 className="home-title">Welcome {this.props.user.userName}</h1>
            <div className="profile-button" onClick={this.onProfileButtonClick}>
              Profile
            </div>
            <div className="login-button" onClick={this.onLogoutButtonClick}>
              Logout
            </div>
          </header>
        ) : (
          <header className="home-header">
            <h1 className="home-title">CS5200 Stock Trader</h1>
            <div className="login-button" onClick={this.onLoginButtonClick}>
              Login
            </div>
          </header>
        )}
        <div className="stockChart-container">
          {this.props.user == null ? (
            <StockChart />
          ) : this.props.user.userType === 'investor' ? (
            <div>
              <h2 className="portfolio-title">My Portfolio</h2>
              <StockChart user={this.props.user} myPortfolio={this.state.myPortfolio} />
            </div>
          ) : this.props.user.userType === 'manager' ? (
            <div>
              <h2 className="portfolio-title">My Managed Portfolios</h2>
              {this.state.myManagedPortfolios.map(p => <div>{p.investor.firstName}</div>)}
            </div>
          ) : (
            <div> staff </div>
          )}
        </div>

        {this.props.user && <div className="messages-container">
          <h2 className="messages-title">My Messages</h2>
          <Messages user={this.props.user} myPortfolio={this.state.myPortfolio} myManagedPortfolios={this.state.myManagedPortfolios} myStaffedPortfolios={this.state.myStaffedPortfolios} />
        </div> }
      </div>
    );
  }
}