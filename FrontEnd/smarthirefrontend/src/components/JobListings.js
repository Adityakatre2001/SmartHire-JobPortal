import React from 'react';
import './JobListings.css';

function JobListings() {
  const jobs = [
    { title: 'Full Stack Developer', company: 'Tech Corp', location: 'Remote' },
    { title: 'Data Scientist', company: 'Data Inc', location: 'San Francisco, CA' },
    { title: 'UI/UX Designer', company: 'DesignPro', location: 'New York, NY' },
  ];

  return (
    <section id="jobs" className="job-listings-section">
      <h2>Latest Job Listings</h2>
      <div className="job-listings-container">
        {jobs.map((job, index) => (
          <div key={index} className="job-card">
            <h3>{job.title}</h3>
            <p>{job.company}</p>
            <p>{job.location}</p>
            <button className="btn-primary">Apply Now</button>
          </div>
        ))}
      </div>
    </section>
  );
}

export default JobListings;
