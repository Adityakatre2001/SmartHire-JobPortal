

import React, { useEffect, useState } from 'react';
import AdminService from '../services/AdminService';

function UserList() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    AdminService.getAllUsers()
      .then(response => setUsers(response.data))
      .catch(error => console.error('Error fetching users:', error));
  }, []);

  
}

export default UserList;
