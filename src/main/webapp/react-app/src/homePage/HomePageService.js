export default {
    onButtonClick,
    onLoginButtonClick,
    onLogoutButtonClick
}

function onButtonClick() {
    this.props.setLocation('Not Home!');
}

function onLoginButtonClick() {
    this.props.setLocation('login');
}

function onLogoutButtonClick() {
    this.props.setUser(undefined);
}