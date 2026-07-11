import axios from "axios";

const BASE_URL = "https://lead-management-backend-g6ws.onrender.com";

const ApiService = {

    saveLead(data) {
        return axios.post(`${BASE_URL}/leads`, data);
    },

    getDashboard() {
        return axios.get(`${BASE_URL}/dashboard`);
    },

    getLeads() {
        return axios.get(`${BASE_URL}/leads`);
    }

};

export default ApiService;
