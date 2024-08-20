import React, { useEffect, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import AdminService from '../../../services/AdminService';
import '../Admin/css/AdminDashboard.css';

export default function AdminDashboard() {
  const [users, setUsers] = useState([]);
  const [companies, setCompanies] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    AdminService.getAllUsers().then((response) => {
      setUsers(response.data);
    });

    AdminService.getAllCompanies().then((response) => {
      setCompanies(response.data);
    });
  }, []);

  const editUser = (userId) => {
    navigate(`/admin/users/edit/${userId}`);
  };

  const deleteUser = (userId) => {
    AdminService.deleteUser(userId).then(() => {
      setUsers(users.filter(user => user.id !== userId));
    });
  };

  const editCompany = (companyId) => {
    navigate(`/admin/companies/edit/${companyId}`);
  };

  const deleteCompany = (companyId) => {
    AdminService.deleteCompany(companyId).then(() => {
      setCompanies(companies.filter(company => company.id !== companyId));
    });
  };

  return (
    <div className="admin-dashboard">
      <h2>Admin Dashboard</h2>
      <div className="table-container">
        <h3>Users</h3>
        <Link to="/admin/users/create" className="add-button">Add User</Link>
        <table className="table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Email</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {users.map(user => (
              <tr key={user.id}>
                <td>{user.id}</td>
                <td>{user.name}</td>
                <td>{user.email}</td>
                <td className="actions">
                  <button className="edit-button" onClick={() => editUser(user.id)}>Edit</button>
                  <button className="delete-button" onClick={() => deleteUser(user.id)}>Delete</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      <div className="table-container">
        <h3>Companies</h3>
        <Link to="/admin/companies/create" className="add-button">Add Company</Link>
        <table className="table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Location</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {companies.map(company => (
              <tr key={company.id}>
                <td>{company.id}</td>
                <td>{company.name}</td>
                <td>{company.location}</td>
                <td className="actions">
                  <button className="edit-button" onClick={() => editCompany(company.id)}>Edit</button>
                  <button className="delete-button" onClick={() => deleteCompany(company.id)}>Delete</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
