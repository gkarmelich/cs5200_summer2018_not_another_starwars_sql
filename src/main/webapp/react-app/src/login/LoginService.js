export default {
    submitLogin,
    register,
    onUsernameChange,
    onPasswordChange
}

function submitLogin() {
    this.props.setLocation('profile');
}

function register() {
    this.props.setLocation('profile');
}

function onUsernameChange(event) {
    this.setState({ username: event.target.value });
}

function onPasswordChange(event) {
    this.setState({ password: event.target.value });
}