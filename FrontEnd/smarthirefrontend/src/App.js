import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Navbar from './components/commons/Navbar/Navbar';
import Home from './components/commons/Home/Home';
import About from './components/pages/Home/js/About';
import Contact from './components/pages/Home/js/Contact';
import Footer from './components/commons/Footer/Footer';
import './App.css';
import UserList from './components/UserList';
import UserForm from './components/UserForm';
import CompanyList from './components/CompanyList';
import CompanyForm from './components/CompanyForm';
import SignIn from './components/pages/Home/js/SignIn';
import Register from './components/pages/Home/js/Register';


function App() {
  return (
    <Router>
      <Navbar />
      <div className="app-content">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path="/contact" element={<Contact />} />
          <Route path="/signin" element={<SignIn />} />
          <Route path="/register" element={<Register />} />
          <Route path="/users" element={<UserList />} />
        <Route path="/add-user" element={<UserForm />} />
        <Route path="/edit-user/:userId" element={<UserForm />} />
        <Route path="/companies" element={<CompanyList />} />
        <Route path="/add-company" element={<CompanyForm />} />
        <Route path="/edit-company/:companyId" element={<CompanyForm />} />
        </Routes>
      </div>
      <Footer />
    </Router>
  );
}

export default App;
