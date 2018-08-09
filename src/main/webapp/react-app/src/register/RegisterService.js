import axios from 'axios';

export default {
    onComponentWillMount,

    submitRegister,
    onUsernameChange,
    onPasswordChange,
    onRoleChange,
    onFirstNameChange,
    onLastNameChange,
    onEmailChange,
    onDobChange
}

function onComponentWillMount() {
    this.registeredUsers = [];
    axios.get('/api/investor').then(investorRes => {
        this.registeredUsers = this.registeredUsers.concat(investorRes.data);
        axios.get('/api/manager').then(managerRes => {
            this.registeredUsers = this.registeredUsers.concat(managerRes.data);
            axios.get('/api/staff').then(staffRes => {
                this.registeredUsers = this.registeredUsers.concat(staffRes.data);
            });
        });
    });
}

function submitRegister() {
    if (this.state.username === '') {
        this.setState({ errorMessage: 'Enter a username' });
    } else if (this.state.password === '') {
        this.setState({ errorMessage: 'Enter a password' });
    } else if (this.state.role === '') {
        this.setState({ errorMessage: 'Choose a role' })
    } else {
        let existingUser = this.registeredUsers.find(user => user.userName === this.state.username);
        if (existingUser) {
            this.setState({ errorMessage: 'Username taken, try another' });
        } else {
            let requestBody = {
                firstName: this.state.firstName,
                lastName: this.state.lastName,
                userName: this.state.username,
                password: this.state.password,
                email: this.state.email,
                dob: this.state.dob,
                phones: this.state.phones,
                addresses: this.state.addresses
            }
            switch (this.state.role) {
                case 'investor':
                    axios.post('/api/investor', requestBody).then(() => this.props.setLocation('login'));
                    break;
                case 'manager':
                    axios.post('/api/manager', requestBody).then(() => this.props.setLocation('login'));
                    break;
                case 'staff':
                    axios.post('/api/staff', requestBody).then(() => this.props.setLocation('login'));
                    break;
                default:
            }
        }
    }
    
}

function onUsernameChange(event) {
    this.setState({ username: event.target.value });
}

function onPasswordChange(event) {
    this.setState({ password: event.target.value });
}

function onRoleChange(event) {
    this.setState({ role: event.target.value });
}

function onFirstNameChange(event) {
    this.setState({ firstName: event.target.value });
}

function onLastNameChange(event) {
    this.setState({ lastName: event.target.value });
}

function onEmailChange(event) {
    this.setState({ email: event.target.value });
}

function onDobChange(event) {
    this.setState({ dob: event.target.value });
}