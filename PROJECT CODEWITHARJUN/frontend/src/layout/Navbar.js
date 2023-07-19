import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <>
      <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
        <div className="container-fluid">
          <Link className="navbar-brand" to="/">
            Fullstack application
          </Link>
          <Link className="btn btn-outline-light" to="/adduser">Add User</Link>


        </div>
      </nav>
    </>
  );
};

export default Navbar;
