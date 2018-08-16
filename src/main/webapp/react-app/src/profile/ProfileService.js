import axios from 'axios';

export default {
    onComponentWillMount,

    submitUpdate,
    onPasswordChange,
    onFirstNameChange,
    onLastNameChange,
    onEmailChange,
    onDobChange
}

function onComponentWillMount() {
    this.setState({
        firstName: this.props.user.firstName,
        lastName: this.props.user.lastName,
        password: this.props.user.password,
        email: this.props.user.email,
        dob: this.props.user.dob,
        phones: this.props.user.phones,
        addresses: this.props.user.addresses,
    });
}

function submitUpdate() {
    if (this.state.password === '') {
        this.setState({ errorMessage: 'Enter a password' });
    } else {
        let requestBody = {
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            userName: this.props.user.userName,
            password: this.state.password,
            email: this.state.email,
            dob: this.state.dob,
            phones: this.state.phones,
            addresses: this.state.addresses
        }
        switch (this.props.user.userType) {
            case 'investor':
                axios.put('/api/investor/' + this.props.user.idPerson, requestBody).then(() => this.props.setLocation('home'));
                break;
            case 'manager':
                axios.put('/api/manager/' + this.props.user.idPerson, requestBody).then(() => this.props.setLocation('home'));
                break;
            case 'staff':
                axios.put('/api/staff/' + this.props.user.idPerson, requestBody).then(() => this.props.setLocation('home'));
                break;
            default:
        }
    }
    
}

function onPasswordChange(event) {
    this.setState({ password: event.target.value });
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