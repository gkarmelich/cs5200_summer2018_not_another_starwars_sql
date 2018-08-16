import axios from 'axios';

export default {
    onComponentWillMount,

    submitLogin,
    register,
    onUsernameChange,
    onPasswordChange
}

function onComponentWillMount() {
    this.registeredUsers = [];
    axios.get('/api/investor').then(investorRes => {
        investorRes.data.forEach(i => i.userType = 'investor');
        this.registeredUsers = this.registeredUsers.concat(investorRes.data);
        axios.get('/api/manager').then(managerRes => {
            managerRes.data.forEach(m => m.userType = 'manager');
            this.registeredUsers = this.registeredUsers.concat(managerRes.data);
            axios.get('/api/staff').then(staffRes => {
                staffRes.data.forEach(s => s.userType = 'staff');
                this.registeredUsers = this.registeredUsers.concat(staffRes.data);
            });
        });
    });
}

function submitLogin() {
    let existingUser = this.registeredUsers.find(user => user.userName === this.state.username);
    if (!existingUser) {
        this.setState({ errorMessage: 'Username does not exist' });
    } else if (this.state.password !== existingUser.password) {
        this.setState({ errorMessage: 'Wrong username/password combination' });
    } else {
        this.props.setUser(existingUser);
        this.props.setLocation('home');
    }
}

function register() {
    this.props.setLocation('register');
}

function onUsernameChange(event) {
    this.setState({ username: event.target.value });
}

function onPasswordChange(event) {
    this.setState({ password: event.target.value });
}