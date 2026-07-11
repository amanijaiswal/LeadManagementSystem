import { useEffect, useState } from "react";
import ApiService from "../services/ApiService";

function Dashboard() {

    const [dashboard, setDashboard] = useState({});

    useEffect(() => {

        loadDashboard();

    }, []);

    const loadDashboard = async () => {

        try {

            const response = await ApiService.getDashboard();

            setDashboard(response.data);

        } catch (error) {

            console.error(error);

        }

    };

    return (

        <div className="container mt-5">

            <h2 className="mb-4">
                Analytics Dashboard
            </h2>

            <div className="row">

                <div className="col-md-4 mb-3">
                    <div className="card shadow p-3">
                        <h5>Total Leads</h5>
                        <h2>{dashboard.totalLeads}</h2>
                    </div>
                </div>

                <div className="col-md-4 mb-3">
                    <div className="card shadow p-3">
                        <h5>Emails Sent</h5>
                        <h2>{dashboard.emailsSent}</h2>
                    </div>
                </div>

                <div className="col-md-4 mb-3">
                    <div className="card shadow p-3">
                        <h5>Emails Opened</h5>
                        <h2>{dashboard.emailsOpened}</h2>
                    </div>
                </div>

                <div className="col-md-6 mb-3">
                    <div className="card shadow p-3">
                        <h5>Links Clicked</h5>
                        <h2>{dashboard.linksClicked}</h2>
                    </div>
                </div>

                <div className="col-md-3 mb-3">
                    <div className="card shadow p-3">
                        <h5>Open Rate</h5>
                        <h2>{dashboard.openRate}%</h2>
                    </div>
                </div>

                <div className="col-md-3 mb-3">
                    <div className="card shadow p-3">
                        <h5>Click Rate</h5>
                        <h2>{dashboard.clickRate}%</h2>
                    </div>
                </div>

            </div>

        </div>

    );
}

export default Dashboard;