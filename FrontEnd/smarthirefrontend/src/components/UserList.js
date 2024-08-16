

import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function UserList() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/admin/users')
      .then(response => setUsers(response.data))
      .catch(error => console.error('Error fetching users:', error));
  }, []);

  const handleDelete = (userId) => {
    axios.delete(`http://localhost:8080/admin/users/${userId}`)
      .then(() => setUsers(users.filter(user => user.id !== userId)))
      .catch(error => console.error('Error deleting user:', error));
  };

  return (
    <div>
      <h1>User List</h1>
      <Link to="/add-user" className="btn btn-primary mb-3">Add User</Link>
      <ul className="list-group">
        {users.map(user => (
          <li key={user.id} className="list-group-item">
            {user.name} {/* Adjust according to your DTO fields */}
            <Link to={`/edit-user/${user.id}`} className="btn btn-secondary ms-2">Edit</Link>
            <button onClick={() => handleDelete(user.id)} className="btn btn-danger ms-2">Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default UserList;
