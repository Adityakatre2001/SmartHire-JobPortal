

import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function CompanyList() {
  const [companies, setCompanies] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/admin/companies')
      .then(response => setCompanies(response.data))
      .catch(error => console.error('Error fetching companies:', error));
  }, []);

  const handleDelete = (companyId) => {
    axios.delete(`http://localhost:8080/admin/companies/${companyId}`)
      .then(() => setCompanies(companies.filter(company => company.id !== companyId)))
      .catch(error => console.error('Error deleting company:', error));
  };

  return (
    <div>
      <h1>Company List</h1>
      <Link to="/add-company" className="btn btn-primary mb-3">Add Company</Link>
      <ul className="list-group">
        {companies.map(company => (
          <li key={company.id} className="list-group-item">
            {company.name} {/* Adjust according to your DTO fields */}
            <Link to={`/edit-company/${company.id}`} className="btn btn-secondary ms-2">Edit</Link>
            <button onClick={() => handleDelete(company.id)} className="btn btn-danger ms-2">Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default CompanyList;
