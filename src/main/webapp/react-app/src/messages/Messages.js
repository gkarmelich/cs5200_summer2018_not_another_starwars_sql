import React, { Component } from 'react';
import axios from 'axios';
import MessagesService from './MessagesService';
import './Messages.css';

export default class Messages extends Component {

  constructor(props) {
    super(props);
    
    Object.keys(MessagesService).forEach(key => {
      this[key] = MessagesService[key].bind(this);
    });

    this.state = { people: [], selectedMessages: [] };
    
  }

  componentWillMount() {
      this.onComponentWillMount();
  }
  
  componentWillUpdate(nextProps, nextState) {
      this.onComponentWillUpdate(nextProps, nextState);
  }

  render() {
    
    return (
      <div className="messages-wrapper">
        <div className="people-list">
            <div>People: </div>
            {this.state.people.map(person => 
                <div className={"person" + (person === this.state.selectedPerson ? " selected" : "")} onClick={this.onPersonClick}>{person.firstName} {person.lastName}</div>
            )}
        </div>
        <div className="messages">
            <div className="selected-messages-wrapper">
            {this.state.selectedMessages.map(message => 
                <div className="message">
                    <span className="message-sender">{this.getDisplayName(message.idSender)}</span>{message.messageContent}
                </div> 
            )}
            </div>
            <div className="input-wrapper">
                <input placeholder="type a message" onChange={this.onMessageChange}/>
                <button onClick={this.onMessageSend}>Send</button>
            </div>
        </div>
      </div>
    );
  }
}