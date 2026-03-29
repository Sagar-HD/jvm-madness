import './App.css'
import Register from './components/Register'
import Login from './components/Login'
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Dashboard from './components/Dashboard';
import ProtectedRoute from './components/ProtectedRoute';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route 
          path='/' 
          element={
            <>
              <Register />
              <h1>hii</h1>
            </>
          } 
        />
        <Route path='/login' element={<Login />} />
         <Route path='/dashboard' element={<ProtectedRoute><Dashboard /></ProtectedRoute>} />
      </Routes>
    </BrowserRouter>
  )
}

export default App