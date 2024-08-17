// src/services/EmployerService.js

import axios from 'axios';
import AuthService from './AuthService';

const API_URL = 'http://localhost:8080/employers/';

class EmployerService {
    createJobPosting(jobPosting) {
        return axios.post(API_URL + 'jobs', jobPosting, { headers: this.authHeader() });
    }

    updateJobPosting(jobId, jobPosting) {
        return axios.put(API_URL + `jobs/${jobId}`, jobPosting, { headers: this.authHeader() });
    }

    deleteJobPosting(jobId) {
        return axios.delete(API_URL + `jobs/${jobId}`, { headers: this.authHeader() });
    }

    getJobPostingById(jobId) {
        return axios.get(API_URL + `jobs/${jobId}`, { headers: this.authHeader() });
    }

    getAllJobPostings() {
        return axios.get(API_URL + 'jobs', { headers: this.authHeader() });
    }

    getApplicationsForJob(jobId) {
        return axios.get(API_URL + `jobs/${jobId}/applications`, { headers: this.authHeader() });
    }

    authHeader() {
        const user = AuthService.getCurrentUser();
        if (user && user.token) {
            return { Authorization: 'Bearer ' + user.token };
        } else {
            return {};
        }
    }
}

export default new EmployerService();
