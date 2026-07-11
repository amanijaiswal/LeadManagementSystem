import { BrowserRouter, Routes, Route } from "react-router-dom";

import Navbar from "./components/Navbar";
import LeadForm from "./components/LeadForm";
import Dashboard from "./components/Dashboard";

function App() {

    return (

        <BrowserRouter>

            <Navbar />

            <Routes>

                <Route path="/" element={<LeadForm />} />

                <Route path="/dashboard" element={<Dashboard />} />

            </Routes>

        </BrowserRouter>

    );
}

export default App;