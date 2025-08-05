import React, { useState } from 'react';
import LoginButton from './components/LoginButton';
import LogoutButton from './components/LogoutButton';
import Greeting from './components/Greeting';
import FlightDetails from './components/FlightDetails';
import BookTicket from './components/BookTicket';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLoginClick = () => {
    setIsLoggedIn(true);
  };

  const handleLogoutClick = () => {
    setIsLoggedIn(false);
  };

  let button = isLoggedIn
    ? <LogoutButton onClick={handleLogoutClick} />
    : <LoginButton onClick={handleLoginClick} />;

  return (
    <div style={{ textAlign: 'center', marginTop: '50px' }}>
      <Greeting isLoggedIn={isLoggedIn} />
      {button}
      <hr />
      {isLoggedIn ? <BookTicket /> : <FlightDetails />}
    </div>
  );
}

export default App;
