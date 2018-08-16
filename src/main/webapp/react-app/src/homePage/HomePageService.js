import axios from 'axios';

export default {
    onComponentWillMount,

    onLoginButtonClick,
    onLogoutButtonClick,
    onProfileButtonClick
}

function onComponentWillMount() {
    if (this.props.user) {
        axios.get('/api/portfolio').then(portfolios => {
            const myPortfolios = portfolios.data.filter(p => p.investor.idPerson === this.props.user.idPerson);
            const myManagedPortfolios = portfolios.data.filter(p => p.manager.idPerson === this.props.user.idPerson);
            const myStaffedPortfolios = portfolios.data.filter(p => p.staff.includes(s => s.idPerson === this.props.user.idPerson));
            const myPortfolio = myPortfolios.length === 0 ? null : myPortfolios[0];
            this.setState({ myPortfolio, myManagedPortfolios, myStaffedPortfolios });
            console.log(myPortfolio);
        });
    }
}

function onLoginButtonClick() {
    this.props.setLocation('login');
}

function onLogoutButtonClick() {
    this.props.setUser(undefined);
}

function onProfileButtonClick() {
    this.props.setLocation('profile');
}