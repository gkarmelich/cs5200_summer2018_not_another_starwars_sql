export default {
    getLocation,
    setLocation
}


function getLocation() {
    return this.state.location;
}

function setLocation(location) {
    this.setState({ location });
}