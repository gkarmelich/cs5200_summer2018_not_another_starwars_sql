import React, { Component } from 'react';
import axios from 'axios';
import StockChart from '../stockChart/StockChart';
import DefaultHome from '../defaultHome/DefaultHome';
import Messages from '../messages/Messages';
import Trade from '../trade/Trade';
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
            {this.isAdminUser() && <div className="admin-button" onClick={this.onAdminButtonClick}>
              Admin
            </div>
            }
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
            <DefaultHome />
          ) : this.props.user.userType === 'investor' ? (
            <div>
              <h2 className="portfolio-title">My Portfolio</h2>
              <StockChart user={this.props.user} myPortfolio={this.state.myPortfolio} />
            </div>
          ) : this.props.user.userType === 'manager' ? (
            <div>
              <h2 className="portfolio-title">My Managed Portfolios</h2>
              {this.state.myManagedPortfolios.map(p => <div className="managed">{p.investor.firstName} {p.investor.lastName} ({p.investor.userName})</div>)}
            </div>
          ) : (
            <div> staff </div>
          )}
        </div>

        {this.props.user && <div className="messages-container">
          <h2 className="messages-title">My Messages</h2>
          <Messages user={this.props.user} myPortfolio={this.state.myPortfolio} myManagedPortfolios={this.state.myManagedPortfolios} myStaffedPortfolios={this.state.myStaffedPortfolios} />
        </div> }

        {this.props.user && this.props.user.userType === 'manager' && <div className="trade-wrapper">
          <h2 className="trade-title">Conduct Trade</h2>
          <Trade user={this.props.user} myManagedPortfolios={this.state.myManagedPortfolios} allPortfolios={this.state.allPortfolios} />
        </div>
        }
      </div>
    );
  }
}