import axios from 'axios';

export default {
    onComponentWillMount,

    onUserNameChange,
    getFilteredUsers,
    onRoleChange,
    saveUser,
    deleteUser,
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
                this.registeredUsers.forEach(u => this.state.roles[u.idPerson] = u.userType);
                this.setState({ registeredUsers: this.registeredUsers });
            });
        });
    });
}


function onUserNameChange(event) {
    this.setState({ userName: event.target.value });
}

function getFilteredUsers() {
    return this.state.registeredUsers.filter(u => u.userName.toLowerCase().includes(this.state.userName.toLowerCase()));
}

function onRoleChange(event, user) {
    this.state.roles[user.idPerson] = event.target.value;
    this.setState({ roles: this.state.roles });
}

function saveUser(user) {
    axios.delete('/api/' + user.userType + '/'+ user.idPerson).then(() => {
        axios.post('/api/' + this.state.roles[user.idPerson], user);
    });
}

function deleteUser(user) {
    this.state.registeredUsers = this.state.registeredUsers.filter(u => u.idPerson !== user.idPerson);
    axios.delete('/api/' + user.userType + '/'+ user.idPerson).then(() => this.setState({}));
}
