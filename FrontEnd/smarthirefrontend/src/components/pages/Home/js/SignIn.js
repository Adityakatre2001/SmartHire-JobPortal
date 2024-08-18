import React, { useState } from 'react';
import axios from 'axios';
import '../css/SignIn.css';
import { useNavigate } from 'react-router-dom';
import { useDispatch } from 'react-redux';
import { setUser } from '../../../../redux/actions/action'; 
import UserService from '../../../../services/UserService';

export default function SignInForm() {
    const [formDetails, setFormDetails] = useState({
      email: '',
      password: ''
    });
    const [errorMessage, setErrorMessage] = useState('');  // New state for error messages
  
    const navigate = useNavigate();
  
    const handleChange = (event) => {
      const name = event.target.name;
      setFormDetails({
        ...formDetails,
        [name]: event.target.value
      });
    };
  
    const signInUser = () => {
      if (formDetails.email === '' || formDetails.password === '') {
        alert('Please fill all the details');
        return;
      }
  
      UserService.userSignIn(formDetails)
        .then((result) => {
          console.log('User signed in successfully:', result);
  
          const user = result.data;
          if (user && user.id) {
            localStorage.setItem('userId', user.id);
            console.log('User role:', user.role);
            if (user.role === 'ROLE_APPLICANT') {
              navigate('/JobPostings');
            } else if (user.role === 'ROLE_ADMIN') {
              navigate('/Admin/dashboard');
            } else if(user.role === 'ROLE_EMPLOYER'){
              navigate('/Employer/dashboard');
            }
          } else {
            alert('Failed to retrieve user information.');
          }
        })
        .catch((error) => {
          console.error('There was an error signing in!', error);
          // Set the error message based on the response
          setErrorMessage(error.response?.data?.message || 'Failed to sign in. Please check your credentials and try again.');
        });
    };
  
    const handleForgotPassword = () => {
      navigate('/reset-password');
    };
    return (
        <div className="signin-container">
            <div className="signin-form">
                <h2>Sign In</h2>
                <form >
                    <div className="form-group">
                        <label htmlFor="email">Email</label>
                        <input 
                        type="email"
                        id="email"
                        name="email"
                        className="form-control"
                        placeholder="Enter email"
                        value={formDetails.email}
                        onChange={handleChange}
                        required 
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="password">Password</label>
                        <input 
                        type="password"
                        id="password"
                        name="password"
                        className="form-control"
                        placeholder="Enter password"
                        value={formDetails.password}
                        onChange={handleChange}
                        required />
                    </div>
                    <button type="submit" className='submit-button' onClick={signInUser}>
                        Sign In

                    </button>
                    
                </form>
            </div>
        </div>
    );
}


