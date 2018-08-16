import axios from 'axios';

export default {
    onComponentWillMount,
    onComponentWillUpdate,

    onPersonClick,
    getDisplayName,
    onMessageChange,
    onMessageSend
}

function onComponentWillMount() {
    axios.get('/api/message').then(res => {
        console.log(res.data);
        const messages = res.data.filter(m => m.idSender === this.props.user.idPerson || m.idReceiver === this.props.user.idPerson);
        this.setState({ messages });
    });

}

function onComponentWillUpdate(nextProps, nextState) {
    if (nextProps.myPortfolio !== this.props.myPortfolio) {
        const people = [];
        if (nextProps.user.userType === 'investor') {
            people.push(nextProps.myPortfolio.manager);
            nextProps.myPortfolio.staff.forEach(s => people.push(s));
        } else if (nextProps.user.userType === 'manager') {
            nextProps.myManagedPortfolios.forEach(p => {
                people.push(p.investor);
                p.staff.forEach(s => people.push(s));
            });
        } else if (nextProps.user.userType === 'staff') {
            nextProps.myStaffedPortfolios.forEach(p => {
                people.push(p.investor);
                people.push(p.manager);
            });
        }
        nextState.people = people;
        nextState.selectedPerson = people[0];
        nextState.selectedMessages = this.state.messages.filter(m => m.idSender === nextState.selectedPerson.idPerson || m.idReceiver === nextState.selectedPerson.idPerson);
    }
}

function onPersonClick(event) {
    const personName = event.target.textContent;
    const nameArray = personName.split(' ');
    const selectedPerson = this.state.people.find(p => p.firstName === nameArray[0] && p.lastName === nameArray[1]);
    const selectedMessages = this.state.messages.filter(m => m.idSender === selectedPerson.idPerson || m.idReceiver === selectedPerson.idPerson);
    this.setState({ selectedPerson, selectedMessages });
}

function getDisplayName(id) {
    if (id == this.props.user.idPerson) return this.props.user.userName;
    else return this.state.people.find(p => p.idPerson === id).userName;
}

function onMessageChange(event) {
    this.setState({ message: event.target.value });
}

function onMessageSend() {
    const message = {
        idSender: this.props.user.idPerson,
        idReceiver: this.state.selectedPerson.idPerson,
        messageContent: this.state.message
    }
    axios.post('/api/message', message).then(() => {
        axios.get('/api/message').then(res => {
            const messages = res.data.filter(m => m.idSender === this.props.user.idPerson || m.idReceiver === this.props.user.idPerson);
            const selectedMessages = res.data.filter(m => (m.idSender === this.props.user.idPerson || m.idReceiver === this.props.user.idPerson) && (m.idSender === this.state.selectedPerson.idPerson || m.idReceiver === this.state.selectedPerson.idPerson) );
            this.setState({ messages, selectedMessages });
        });
    });
}
