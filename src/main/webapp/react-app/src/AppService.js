export default {
    getLocation,
    setLocation,
    setUser
}


function getLocation() {
    return this.state.location;
}

function setLocation(location) {
    this.setState({ location });
}

function setUser(user) {
    this.setState({ user });
}