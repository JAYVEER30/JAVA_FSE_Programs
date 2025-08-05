// src/App.js
import React from 'react';
import CurrencyConvertor from './CurrencyConvertor';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      counter: 5
    };
    this.handleIncrement = this.handleIncrement.bind(this);
    this.handleDecrement = this.handleDecrement.bind(this);
    this.sayWelcome = this.sayWelcome.bind(this);
    this.handleClick = this.handleClick.bind(this);
  }

  handleIncrement() {
    this.setState({ counter: this.state.counter + 1 }, () => {
      this.sayHello(); // Method 1
      this.sayHelloWithMessage("Hello! Member1"); // Method 2
    });
  }

  handleDecrement() {
    this.setState({ counter: this.state.counter - 1 });
  }

  sayHello() {
    alert("Hello! Member1");
  }

  sayHelloWithMessage(message) {
    alert(message);
  }

  sayWelcome(message) {
    alert(message);
  }

  handleClick(e) {
    alert("I was clicked");
  }

  render() {
    return (
      <div style={{ padding: 20 }}>
        <h1>{this.state.counter}</h1>
        <button onClick={this.handleIncrement}>Increment</button>
        <br />
        <button onClick={this.handleDecrement}>Decrement</button>
        <br />
        <button onClick={() => this.sayWelcome("welcome")}>Say welcome</button>
        <br />
        <button onClick={this.handleClick}>Click on me</button>
        <br /><br />
        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;
