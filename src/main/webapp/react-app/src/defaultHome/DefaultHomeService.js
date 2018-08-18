import axios from 'axios';

export default {
    onComponentWillMount,
    onComponentWillUpdate,
    
    onTickerChange,
    search
}

function onComponentWillMount() {
}

function onComponentWillUpdate(nextProps, nextState) {
}

function onTickerChange(event) {
    this.setState({ ticker: event.target.value });
}

function search() {
    const ticker = this.state.ticker.toUpperCase();
    axios.get('/api/stockrequest/' + ticker).then(res => {
        this.state.errorMessage = undefined;

        if (res.data['Error Message']) {
            this.setState({ errorMessage: 'Ticker not found' });
        } else {
            const data = [];

            const keys = Object.keys(res.data['Time Series (Daily)']);
            keys.forEach(key => {
                const record = {
                    date: key,
                    value: Number.parseFloat(res.data['Time Series (Daily)'][key]['4. close'])
                }
                data.push(record);
            });
            data.reverse();
            this.setState({ data });
        }

    });
}
