import { useState } from "react";
import ApiService from "../services/ApiService";

function LeadForm() {

    const [lead, setLead] = useState({
        fullName: "",
        email: "",
        phone: "",
        company: "",
        requirement: ""
    });

    const handleChange = (e) => {
        setLead({
            ...lead,
            [e.target.name]: e.target.value
        });
    };

    const submitLead = async (e) => {

        e.preventDefault();

        try {

            await ApiService.saveLead(lead);

            alert("Lead Saved Successfully.");

            setLead({
                fullName: "",
                email: "",
                phone: "",
                company: "",
                requirement: ""
            });

        } catch (error) {

            console.error(error);

            alert("Error Saving Lead");

        }

    };

    return (

        <div className="container mt-5">

            <div className="card shadow">

                <div className="card-header bg-primary text-white">

                    <h3>Lead Capture Form</h3>

                </div>

                <div className="card-body">

                    <form onSubmit={submitLead}>

                        <input
                            className="form-control mb-3"
                            placeholder="Full Name"
                            name="fullName"
                            value={lead.fullName}
                            onChange={handleChange}
                            required
                        />

                        <input
                            className="form-control mb-3"
                            placeholder="Email"
                            name="email"
                            type="email"
                            value={lead.email}
                            onChange={handleChange}
                            required
                        />

                        <input
                            className="form-control mb-3"
                            placeholder="Phone"
                            name="phone"
                            value={lead.phone}
                            onChange={handleChange}
                            required
                        />

                        <input
                            className="form-control mb-3"
                            placeholder="Company"
                            name="company"
                            value={lead.company}
                            onChange={handleChange}
                        />

                        <textarea
                            className="form-control mb-3"
                            rows="4"
                            placeholder="Requirement"
                            name="requirement"
                            value={lead.requirement}
                            onChange={handleChange}
                            required
                        />

                        <button
                            className="btn btn-success w-100"
                            type="submit"
                        >
                            Submit Lead
                        </button>

                    </form>

                </div>

            </div>

        </div>

    );
}

export default LeadForm;