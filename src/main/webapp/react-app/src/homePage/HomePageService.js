export default {
    onButtonClick,
    onLoginButtonClick
}

function onButtonClick() {
    this.props.setLocation('Not Home!');
}

function onLoginButtonClick() {
    this.props.setLocation('login');
}