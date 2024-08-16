import React from 'react';
import '../css/SignIn.css';

function SignIn() {
  return (
    <div className="signin-container">
      <div className="signin-form">
        <h2>Sign In</h2>
        <form>
          <div className="form-group">
            <label htmlFor="email">Email address</label>
            <input type="email" id="email" placeholder="Enter email" required />
          </div>
          <div className="form-group">
            <label htmlFor="password">Password</label>
            <input type="password" id="password" placeholder="Password" required />
          </div>
          <button type="submit" className="submit-button">Sign In</button>
        </form>
      </div>
    </div>
  );
}

export default SignIn;
