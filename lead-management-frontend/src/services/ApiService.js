import axios from "axios";
VITE_API_URL=https://your-render-service.onrender.com/api

const BASE_URL = "https://lead-management-backend.onrender.com/api";

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
