import { Link } from "react-router-dom";

function Navbar() {
    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-primary">

            <div className="container">

                <Link className="navbar-brand" to="/">
                    Lead Management
                </Link>

                <div>

                    <Link
                        className="btn btn-light me-2"
                        to="/"
                    >
                        Home
                    </Link>

                    <Link
                        className="btn btn-warning"
                        to="/dashboard"
                    >
                        Dashboard
                    </Link>

                </div>

            </div>

        </nav>
    );
}

export default Navbar;