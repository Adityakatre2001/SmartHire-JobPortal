

import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';

function UserForm() {
  const [user, setUser] = useState({ name: '', email: '' });
  const { userId } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    if (userId) {
      axios.get(`http://localhost:8080/admin/users/${userId}`)
        .then(response => setUser(response.data))
        .catch(error => console.error('Error fetching user:', error));
    }
  }, [userId]);

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const request = userId
      ? axios.put(`http://localhost:8080/admin/users/${userId}`, user)
      : axios.post('http://localhost:8080/admin/users', user);

    request
      .then(() => navigate('/users'))
      .catch(error => console.error('Error saving user:', error));
  };

  return (
    <div>
      <h1>{userId ? 'Edit User' : 'Add User'}</h1>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label className="form-label">Name</label>
          <input type="text" name="name" value={user.name} onChange={handleChange} className="form-control" required />
        </div>
        <div className="mb-3">
          <label className="form-label">Email</label>
          <input type="email" name="email" value={user.email} onChange={handleChange} className="form-control" required />
        </div>
        <button type="submit" className="btn btn-primary">{userId ? 'Update' : 'Create'}</button>
      </form>
    </div>
  );
}

export default UserForm;
