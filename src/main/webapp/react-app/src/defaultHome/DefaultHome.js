import React, { Component } from 'react';
import TextField from '@material-ui/core/TextField';
import { ResponsiveContainer, LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend } from 'recharts';
import DefaultHomeService from './DefaultHomeService';
import './DefaultHome.css';

export default class DefaultHome extends Component {

  constructor(props) {
    super(props);
    
    Object.keys(DefaultHomeService).forEach(key => {
      this[key] = DefaultHomeService[key].bind(this);
    });

    this.state = { ticker: '' };
    
  }

  componentWillMount() {
    this.onComponentWillMount();
  }

  componentWillUpdate(nextProps, nextState) {
    this.onComponentWillUpdate(nextProps, nextState);
  }

  render() {

    return (
        <div className="default-container">
            
            <TextField
                id="ticker"
                label="Enter Ticker"
                className="ticker-textfield"
                value={this.state.ticker}
                onChange={this.onTickerChange}
                margin="normal"
            />

            <div className="search-button" onClick={this.search}>Search</div>

            {this.state.errorMessage ? (
                <div className="error-message">
                    {this.state.errorMessage}
                </div>
            ): this.state.data ? (
                <ResponsiveContainer width="100%" height={350}>
                    <LineChart data={this.state.data}
                        margin={{top: 5, right: 30, left: 20, bottom: 5}}>
                        <XAxis dataKey="date"/>
                        <YAxis/>
                        <CartesianGrid strokeDasharray="3 3"/>
                        <Tooltip/>
                        <Legend />
                        <Line type="monotone" dataKey="value" name={this.state.ticker.toUpperCase()} stroke="#8884d8" activeDot={{r: 5}}/>
                    </LineChart>
                </ResponsiveContainer>
            ) : ( null ) }

            
            

        </div>

    );
  }
}