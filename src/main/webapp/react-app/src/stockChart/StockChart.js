import React, { Component } from 'react';
import { ResponsiveContainer, LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend } from 'recharts';
import StockChartService from './StockChartService';
import './StockChart.css';

export default class StockChart extends Component {

  constructor(props) {
    super(props);
    
    Object.keys(StockChartService).forEach(key => {
      this[key] = StockChartService[key].bind(this);
    });

    this.state = {};
    
  }

  render() {

    const data = [
        {date: '8/1/18', google: 4000, microsoft: 2400},
        {date: '8/2/18', google: 3000, microsoft: 1398},
        {date: '8/3/18', google: 2000, microsoft: 9800},
        {date: '8/4/18', google: 2780, microsoft: 3908},
        {date: '8/5/18', google: 1890, microsoft: 4800},
        {date: '8/6/18', google: 2390, microsoft: 3800},
        {date: '8/7/18', google: 3490, microsoft: 4300},
    ];

    return (
      <div className="chart-container">
        <ResponsiveContainer width="100%" height={350}>
            <LineChart data={data}
                margin={{top: 5, right: 30, left: 20, bottom: 5}}>
                <XAxis dataKey="date"/>
                <YAxis/>
                <CartesianGrid strokeDasharray="3 3"/>
                <Tooltip/>
                <Legend />
                <Line type="monotone" dataKey="google" name="Google" stroke="#8884d8" activeDot={{r: 5}}/>
                <Line type="monotone" dataKey="microsoft" name="Microsoft" stroke="#82ca9d" activeDot={{r: 5}}/>
            </LineChart>
        </ResponsiveContainer>
      </div>
    );
  }
}