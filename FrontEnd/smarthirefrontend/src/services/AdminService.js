// src/services/AdminService.js

import axios from 'axios';
import AuthService from './AuthService';

const API_URL = 'http://localhost:8080/admin/';

class AdminService {
    getAllUsers() {
        return axios.get(API_URL + 'users', { headers: this.authHeader() });
    }

    getUserById(userId) {
        return axios.get(API_URL + `users/${userId}`, { headers: this.authHeader() });
    }

    createUser(user) {
        return axios.post(API_URL + 'users', user, { headers: this.authHeader() });
    }

    updateUser(userId, user) {
        return axios.put(API_URL + `users/${userId}`, user, { headers: this.authHeader() });
    }

    deleteUser(userId) {
        return axios.delete(API_URL + `users/${userId}`, { headers: this.authHeader() });
    }

    getAllCompanies() {
        return axios.get(API_URL + 'companies', { headers: this.authHeader() });
    }

    getCompanyById(companyId) {
        return axios.get(API_URL + `companies/${companyId}`, { headers: this.authHeader() });
    }

    createCompany(company) {
        return axios.post(API_URL + 'companies', company, { headers: this.authHeader() });
    }

    updateCompany(companyId, company) {
        return axios.put(API_URL + `companies/${companyId}`, company, { headers: this.authHeader() });
    }

    deleteCompany(companyId) {
        return axios.delete(API_URL + `companies/${companyId}`, { headers: this.authHeader() });
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

export default new AdminService();
