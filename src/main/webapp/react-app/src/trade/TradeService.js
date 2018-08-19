import axios from 'axios';

export default {
    onComponentWillMount,
    onComponentWillUpdate,
    
    onUserNameChange,
    onTickerChange,
    onAmountChange,
    onActionChange,
    submitTrade
}

function onComponentWillMount() {
}

function onComponentWillUpdate(nextProps, nextState) {
}

function onUserNameChange(event) {
    this.setState({ userName: event.target.value });
}

function onTickerChange(event) {
    this.setState({ ticker: event.target.value });
}

function onAmountChange(event) {
    this.setState({ amount: event.target.value });
}

function onActionChange(event) {
    this.setState({ action: event.target.value });
}

function submitTrade() {
    this.state.successMessage = undefined;
    this.state.errorMessage = undefined;
    const tradePortfolio = this.props.myManagedPortfolios.find(p => p.investor.userName === this.state.userName);
    if (tradePortfolio) {
        if (this.state.ticker) {
            if (this.state.amount) {
                if (this.state.action === 'buy') {
                    const validAsset = tradePortfolio.assets.find(a => a.ticker && a.ticker.toLowerCase() === this.state.ticker.toLowerCase());
                    if (validAsset) {
                        const tradeMoney = tradePortfolio.assets.find(a => a.currencyName === 'USD');
                        if (tradeMoney && tradeMoney.unitsPurchased && tradeMoney.unitsPurchased >= this.state.amount * validAsset.currentUnitValue) {
                            const buy = {
                                stock : validAsset,
                                unitsPurchased: this.state.amount,
                                unitPurchasePrice: validAsset.currentUnitValue
                            };
                            axios.post('/api/buy', buy).then(res => {
                                axios.put('/api/trade/' + res.data.idTrade, tradePortfolio).then(() => 
                                    this.setState({ successMessage: 'Successful Buy' }));  
                            }); 
        
                        } else this.setState({ errorMessage: 'Insufficient funds' });
                    } else this.setState({ errorMessage: 'Ticker does not exist' });
                } else if (this.state.action === 'sell') {
                    const tradeAsset = tradePortfolio.assets.find(a => a.ticker && a.ticker.toLowerCase() === this.state.ticker.toLowerCase());
                    if (tradeAsset && tradeAsset.unitsHeld && tradeAsset.unitsHeld >= this.state.amount) {
        
                        const sell = {
                            stock : tradeAsset,
                            unitsSold: this.state.amount,
                            unitSoldPrice: tradeAsset.currentUnitValue
                        };
                        axios.post('/api/sell', sell).then(res => {
                            axios.put('/api/trade/' + res.data.idTrade, tradePortfolio).then(() => 
                                this.setState({ successMessage: 'Successful Sell' })); 
                        }); 
    
                    } else this.setState({ errorMessage: 'Invalid amount for Ticker' });
                } else this.setState({ errorMessage: 'Choose Buy or Sell' });
            } else this.setState({ errorMessage: 'Enter an amount' });
        } else this.setState({ errorMessage: 'Enter a Ticker' });
    } else this.setState({ errorMessage: 'Invalid username' });
}
