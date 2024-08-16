
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';

function CompanyForm() {
  const [company, setCompany] = useState({ name: '', address: '' });
  const { companyId } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    if (companyId) {
      axios.get(`http://localhost:8080/admin/companies/${companyId}`)
        .then(response => setCompany(response.data))
        .catch(error => console.error('Error fetching company:', error));
    }
  }, [companyId]);

  const handleChange = (e) => {
    setCompany({ ...company, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const request = companyId
      ? axios.put(`http://localhost:8080/admin/companies/${companyId}`, company)
      : axios.post('http://localhost:8080/admin/companies', company);

    request
      .then(() => navigate('/companies'))
      .catch(error => console.error('Error saving company:', error));
  };

  return (
    <div>
      <h1>{companyId ? 'Edit Company' : 'Add Company'}</h1>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label className="form-label">Name</label>
          <input type="text" name="name" value={company.name} onChange={handleChange} className="form-control" required />
        </div>
        <div className="mb-3">
          <label className="form-label">Address</label>
          <input type="text" name="address" value={company.address} onChange={handleChange} className="form-control" required />
        </div>
        <button type="submit" className="btn btn-primary">{companyId ? 'Update' : 'Create'}</button>
      </form>
    </div>
  );
}

export default CompanyForm;
