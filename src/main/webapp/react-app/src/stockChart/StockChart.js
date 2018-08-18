import React, { Component } from 'react';
import { ResponsiveContainer, Cell, Tooltip, PieChart, Pie } from 'recharts';
import StockChartService from './StockChartService';
import './StockChart.css';

export default class StockChart extends Component {

  constructor(props) {
    super(props);
    
    Object.keys(StockChartService).forEach(key => {
      this[key] = StockChartService[key].bind(this);
    });

    this.state = { chartData: [], selectedAsset: {}, displayAssets: [] };
    
  }

  componentWillMount() {
    this.onComponentWillMount();
  }

  componentWillUpdate(nextProps, nextState) {
    this.onComponentWillUpdate(nextProps, nextState);
  }

  render() {

    const COLORS = ['#0088FE', '#00C49F', '#FFBB28', '#FF8042'];

    const RADIAN = Math.PI / 180;                    
    const renderCustomizedLabel = ({ cx, cy, midAngle, innerRadius, outerRadius, percent, index }) => {
      const radius = innerRadius + (outerRadius - innerRadius) * 0.5;
      const x  = cx + radius * Math.cos(-midAngle * RADIAN);
      const y = cy  + radius * Math.sin(-midAngle * RADIAN);
    
      return (
        <text x={x} y={y} fill="white" textAnchor={x > cx ? 'start' : 'end'} 	dominantBaseline="central">
          {`${(percent * 100).toFixed(0)}%`}
        </text>
      );
    };

    return (
      <div className="chart-container">
        {this.props.user ? (
          <div>
          <ResponsiveContainer width="100%" height={350}>
            <PieChart>
              <Pie data={this.state.chartData} outerRadius={120} fill="#8884d8" labelLine={false} label={renderCustomizedLabel}>
                { 
                  this.state.chartData.map((entry, index) => <Cell fill={COLORS[index % COLORS.length]}/>)
                }
              </Pie>
              <Tooltip/>
            </PieChart>
          </ResponsiveContainer>

          <div className="asset-info-container">
            <div className="asset-list">
                <div className="asset-list-title">My Assets:</div>
                <input placeholder="search assets" onChange={this.onSearchChange} />
                {this.state.myPortfolio && this.state.displayAssets.map(asset => 
                  <div className={"asset-name" + (asset === this.state.selectedAsset ? " selected" : "")} onClick={this.onAssetClick} >{this.getAssetName(asset)}</div>
                )}
            </div>
            <div className="selected-asset-info">
                Name: {this.getAssetName(this.state.selectedAsset)} <br />
                {this.state.selectedAsset.ticker && "Ticker: " + this.state.selectedAsset.ticker} <br />
                Date Purchased: {this.state.selectedAsset.datePurchased} <br />
                Unit Purchase Price: {this.state.selectedAsset.unitPurchasePrice} <br />
                {this.state.selectedAsset.currentUnitValue && "Current Unit Value: " + this.state.selectedAsset.currentUnitValue} <br />
                Units Owned: {this.state.selectedAsset.unitsHeld ? this.state.selectedAsset.unitsHeld : this.state.selectedAsset.unitsPurchased} <br />
                Total Value: {this.totalAssetValue(this.state.selectedAsset)}
            </div>
          </div>

          </div>

        ) : (
          null
        )}


        
      </div>
    );
  }
}