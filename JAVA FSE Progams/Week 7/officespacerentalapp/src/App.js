import React from 'react';
import './App.css';
import officeImage from './logo.svg'; // replace with actual image path

function App() {
  const element = "Office Space";

  const officeList = [
    { Name: "DBS", Rent: 50000, Address: "Chennai" },
    { Name: "WeWork", Rent: 75000, Address: "Hyderabad" },
    { Name: "Regus", Rent: 40000, Address: "Bangalore" }
  ];

  return (
    <div className="App">
      <h1>{element}, at Affordable Range</h1>
      {officeList.map((item, index) => {
        const rentClass = item.Rent <= 60000 ? "textRed" : "textGreen";

        return (
          <div key={index} className="officeCard">
            <img src={officeImage} width="25%" height="25%" alt="Office Space" />
            <h1>Name: {item.Name}</h1>
            <h3 className={rentClass}>Rent: Rs. {item.Rent}</h3>
            <h3>Address: {item.Address}</h3>
          </div>
        );
      })}
    </div>
  );
}

export default App;
