import axios from 'axios';
//import AuthService from './AuthService';

const baseurl = 'http://localhost:8080/admin';

class AdminService {
    getAllUsers() {
        return axios.get(baseurl + 'users', { headers: this.authHeader() });
    }

    getUserById(userId) {
        return axios.get(baseurl + `users/${userId}`, { headers: this.authHeader() });
    }

    createUser(user) {
        return axios.post(baseurl + 'users', user, { headers: this.authHeader() });
    }

    updateUser(userId, user) {
        return axios.put(baseurl + `users/${userId}`, user, { headers: this.authHeader() });
    }

    deleteUser(userId) {
        return axios.delete(baseurl + `users/${userId}`, { headers: this.authHeader() });
    }

    getAllCompanies() {
        return axios.get(baseurl + 'companies', { headers: this.authHeader() });
    }

    getCompanyById(companyId) {
        return axios.get(baseurl + `companies/${companyId}`, { headers: this.authHeader() });
    }

    createCompany(company) {
        return axios.post(baseurl + 'companies', company, { headers: this.authHeader() });
    }

    updateCompany(companyId, company) {
        return axios.put(baseurl + `companies/${companyId}`, company, { headers: this.authHeader() });
    }

    deleteCompany(companyId) {
        return axios.delete(baseurl + `companies/${companyId}`, { headers: this.authHeader() });
    }

    // authHeader() {
    //     const user = AuthService.getCurrentUser();
    //     if (user && user.token) {
    //         return { Authorization: 'Bearer ' + user.token };
    //     } else {
    //         return {};
    //     }
    // }
}

export default new AdminService();
