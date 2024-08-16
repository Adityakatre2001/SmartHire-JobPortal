import React from 'react';
import '../Header/Header.css';

function Header() {
  return (
    <section className="hero-section">
      <div className="hero-content">
        <h2>Your Dream Job Awaits</h2>
        <p>Find the perfect job or hire the perfect candidate with SmartHire.</p>
        <button className="btn-primary">Get Started</button>
      </div>
      <div className="hero-image">
        <img src="path/to/your/image.png" alt="Job Search" />
      </div>
    </section>
  );
}


export default Header;
