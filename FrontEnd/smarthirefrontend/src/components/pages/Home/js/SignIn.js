import React, { useState } from 'react';
import axios from 'axios';
import '../css/SignIn.css';
import { useNavigate } from 'react-router-dom';
import { useDispatch } from 'react-redux';
import { setUser } from '../../../../redux/actions/action'; // Redux action to set user

function SignIn() {
    const [credentials, setCredentials] = useState({ email: '', password: '' });
    const [error, setError] = useState(null);
    const navigate = useNavigate();
    const dispatch = useDispatch();

    const handleChange = (e) => {
        setCredentials({ ...credentials, [e.target.name]: e.target.value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/api/authenticate', credentials)
            .then(response => {
                const token = response.data.token;
                const role = response.data.role; // Assume role is returned in response

                localStorage.setItem('token', token);
                localStorage.setItem('role', role);

                // Optionally set user in Redux state
                dispatch(setUser({ token, role }));

                if (role === 'admin') {
                    navigate('/admin'); // Redirect admin to admin dashboard
                } else {
                    navigate('/users'); // Redirect other users to user list or home page
                }
            })
            .catch(() => setError('Invalid credentials. Please try again.'));
    };

    return (
        <div className="signin-container">
            <div className="signin-form">
                <h2>Sign In</h2>
                <form onSubmit={handleSubmit}>
                    <div className="form-group">
                        <label htmlFor="email">Email address</label>
                        <input name="email" type="email" onChange={handleChange} required />
                    </div>
                    <div className="form-group">
                        <label htmlFor="password">Password</label>
                        <input name="password" type="password" onChange={handleChange} required />
                    </div>
                    <button type="submit" className='submit-button'>Sign In</button>
                    {error && <p>{error}</p>}
                </form>
            </div>
        </div>
    );
}

export default SignIn;

{/* <button
type="button"
className="register-button"
onClick={() => navigate('/admin/register')}
>
Register
</button> */}