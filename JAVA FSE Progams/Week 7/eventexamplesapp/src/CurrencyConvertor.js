// src/CurrencyConvertor.js
import React from 'react';

class CurrencyConvertor extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      amount: '',
      currency: '',
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(e) {
    const { name, value } = e.target;
    this.setState({ [name]: value });
  }

  handleSubmit(e) {
    e.preventDefault(); // Synthetic event
    const { amount, currency } = this.state;

    if (currency.toLowerCase() === 'euro') {
      const result = parseFloat(amount) * 80; // Assume 1 Euro = 80 INR
      alert(`Converting to Euro Amount is ${result}`);
    } else {
      alert("Currency not supported!");
    }
  }

  render() {
    return (
      <div>
        <h2 style={{ color: 'green' }}>Currency Convertor!!!</h2>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Amount:</label>
            <input
              type="text"
              name="amount"
              value={this.state.amount}
              onChange={this.handleChange}
            />
          </div>
          <div>
            <label>Currency:</label>
            <textarea
              name="currency"
              value={this.state.currency}
              onChange={this.handleChange}
            />
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default CurrencyConvertor;
