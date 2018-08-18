import axios from 'axios';

export default {
    onComponentWillMount,
    onComponentWillUpdate,
    
    transformAssetData,
    getAssetName,
    onAssetClick,
    totalAssetValue,
    onSearchChange,
    getDisplayAssets
}

function onComponentWillMount() {
    if (this.props.myPortfolio) {
        const myPortfolio = this.props.myPortfolio;
        const selectedAsset = myPortfolio.assets.length === 0 ? null : myPortfolio.assets[0];
        this.setState({ myPortfolio, chartData: this.transformAssetData(myPortfolio.assets), selectedAsset, displayAssets: myPortfolio.assets });
    }
}

function onComponentWillUpdate(nextProps, nextState) {
    if (nextProps.myPortfolio && nextProps.myPortfolio !== this.props.myPortfolio) {
        const myPortfolio = nextProps.myPortfolio;
        const selectedAsset = myPortfolio.assets.length === 0 ? null : myPortfolio.assets[0];
        nextState.myPortfolio = myPortfolio;
        nextState.displayAssets = myPortfolio.assets;
        nextState.chartData = this.transformAssetData(myPortfolio.assets);
        nextState.selectedAsset = selectedAsset;
    }
}

function transformAssetData(assets) {
    const data = [];
    assets.forEach(a => {
        const name = this.getAssetName(a);
        const value = this.totalAssetValue(a);
        data.push({ name, value });
    });
    return data;
}

function getAssetName(asset) {
    return asset.currencyName !== undefined ? asset.currencyName : asset.securityName;
}

function onAssetClick(event) {
    const assetName = event.target.textContent;
    const asset = this.state.myPortfolio.assets.find(a => assetName === this.getAssetName(a));
    this.setState({ selectedAsset: asset });
}

function totalAssetValue(asset) {
    const currentValue = asset.currencyName !== undefined ? asset.unitPurchasePrice : asset.currentUnitValue;
    const totalValue = currentValue * ( asset.currencyName !== undefined ? asset.unitsPurchased : asset.unitsHeld );
    return totalValue;
}

function onSearchChange(event) {
    const searchTerm = event.target.value.toLowerCase();
    const displayAssets = this.getDisplayAssets(this.state.myPortfolio.assets, searchTerm)
    this.setState({ displayAssets });
}

function getDisplayAssets(assets, searchTerm) {
    if (searchTerm.length > 0) return assets.filter(a => this.getAssetName(a).toLowerCase().includes(searchTerm));
    else return assets;
}