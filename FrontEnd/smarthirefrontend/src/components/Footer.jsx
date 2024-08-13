import React from 'react';
import './Footer.css';

function Footer() {
  return (
    <footer id="contact" className="footer-section">
      <div className="footer-content">
        <h3>Contact Us</h3>
        <p>Email: contact@smarthire.com</p>
        <p>Phone: +123 456 7890</p>
        <p>Address: 123 Job Street, Employment City</p>
      </div>
      <div className="footer-social">
        <a href="#">Facebook</a>
        <a href="#">Twitter</a>
        <a href="#">LinkedIn</a>
      </div>
      <p>&copy; 2024 SmartHire. All rights reserved.</p>
    </footer>
  );
}

export default Footer;
