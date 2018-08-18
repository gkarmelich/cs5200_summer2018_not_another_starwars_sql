import React, { Component } from 'react';
import TextField from '@material-ui/core/TextField';
import Radio from '@material-ui/core/Radio';
import RadioGroup from '@material-ui/core/RadioGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';

import TradeService from './TradeService';
import './Trade.css';

export default class Trade extends Component {

  constructor(props) {
    super(props);
    
    Object.keys(TradeService).forEach(key => {
      this[key] = TradeService[key].bind(this);
    });

    this.state = {};
    
  }

  componentWillMount() {
    this.onComponentWillMount();
  }

  componentWillUpdate(nextProps, nextState) {
    this.onComponentWillUpdate(nextProps, nextState);
  }

  render() {

    return (
      <div className="trade-container">
        <div className="trade-title">Enter trade information</div>
        <TextField
            id="userName"
            label="User Name"
            className="username-textfield"
            value={this.state.userName}
            onChange={this.onUserNameChange}
            margin="normal"
        />

        <TextField
            id="ticker"
            label="Ticker"
            className="username-textfield"
            value={this.state.ticker}
            onChange={this.onTickerChange}
            margin="normal"
        />

        <TextField
            id="amount"
            label="Amount"
            className="username-textfield"
            value={this.state.amount}
            onChange={this.onAmountChange}
            margin="normal"
        />

         <RadioGroup
            aria-label="Action"
            name="action"
            value={this.state.action}
            onChange={this.onActionChange}
          >
            <FormControlLabel value="buy" control={<Radio />} label="Buy" />
            <FormControlLabel value="sell" control={<Radio />} label="Sell" />

          </RadioGroup>

          <div className="submit-button" onClick={this.submitTrade}>Trade</div>

          {this.state.errorMessage && <div className="error-message">
            {this.state.errorMessage}
          </div>
          }

          {this.state.successMessage && <div className="success-message">
            {this.state.successMessage}
          </div>
          }

      </div>
    );
  }
}