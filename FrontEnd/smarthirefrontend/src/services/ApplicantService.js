// src/services/ApplicantService.js

import axios from 'axios';
import AuthService from './AuthService';

const API_URL = 'http://localhost:8080/applicants/';

class ApplicantService {
    createApplication(application) {
        return axios.post(API_URL + 'applications', application, { headers: this.authHeader() });
    }

    updateApplication(applicationId, application) {
        return axios.put(API_URL + `applications/${applicationId}`, application, { headers: this.authHeader() });
    }

    deleteApplication(applicationId) {
        return axios.delete(API_URL + `applications/${applicationId}`, { headers: this.authHeader() });
    }

    getApplicationById(applicationId) {
        return axios.get(API_URL + `applications/${applicationId}`, { headers: this.authHeader() });
    }

    getAllApplications() {
        return axios.get(API_URL + 'applications', { headers: this.authHeader() });
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

export default new ApplicantService();
