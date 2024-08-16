

import React from 'react';
import '../Navbar/Navbar.css'

//import smarthire from './logos/smarthire.png';

function Navbar() {
  return (
    <nav className="navbar">
      <div className="navbar-logo">
        {/* Clicking on SmartHire will reload the page */}
        <a href="/" className="navbar-logo-link">
        {/* <img src={smarthire} alt="SmartHire Logo" className="navbar-logo-img" /> */}
        <link rel="apple-touch-icon" href="%PUBLIC_URL%/smarthire.png" /><h1>SmartHire</h1>
        </a>
      </div>
      <ul className="navbar-links">
        <li><a href="about" >About</a></li>
        {/* <li><a href="#jobs">Jobs</a></li>
        <li><a href="#testimonials">Testimonials</a></li> */}
        <li><a href="contact">Contact</a></li>
        <li><a href="signin">Sign In</a></li> {/* Added Sign In link */}
        <li><a href="register">Register</a></li> {/* Added Register link */}
      </ul>
    </nav>
  );
}

export default Navbar;

